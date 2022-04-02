package lesson33.WebApplication.controller;

import com.google.gson.Gson;
import lesson33.WebApplication.dto.CurrencyRate;
import lesson33.WebApplication.dto.CurrencyValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

@RestController
public class ConvertorController {

    @PostMapping("/convert")
    public CurrencyValue convert(@RequestParam(value = "source-currency-value") BigDecimal sourceCurrencyValue,
                                 @RequestParam(value = "source-currency") String sourceCurrency,
                                 @RequestParam(value = "result-currency") String resultCurrency) {
        CurrencyRate currencyRate = getCurrencyRate();
        BigDecimal sourceCurrencyRate = currencyRate.getRate(sourceCurrency);
        BigDecimal convertValue = sourceCurrencyValue.multiply(sourceCurrencyRate);

        return new CurrencyValue(convertValue.setScale(2, RoundingMode.HALF_UP), sourceCurrency, resultCurrency);
    }

    public CurrencyRate getCurrencyRate() {
        String json = "";
        try {
            json = download();
        } catch (IOException e) {
            CurrencyRate currencyRate = new CurrencyRate();
            System.out.println("Данные по валюте недоступны: " + e.getMessage());
        }
        Gson gson = new Gson();
        CurrencyRate currencyRate = gson.fromJson(json, CurrencyRate.class);
        return currencyRate;
    }

    public String download() throws IOException {
        String json = "";
        URL currencyUrl = new URL("https://www.cbr-xml-daily.ru/daily_json.js");
        URLConnection currencyConnection = currencyUrl.openConnection();
        currencyConnection.connect();
        Scanner currencyScanner = new Scanner(currencyConnection.getInputStream());
        while (currencyScanner.hasNextLine()) {
            json += currencyScanner.nextLine();
        }
        return json;
    }
}

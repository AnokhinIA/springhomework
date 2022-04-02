package lesson33.WebApplication.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

//Переменные указаны с заглавной буквы для корректной десериализации из json с сайта курсов ЦБ

@Getter
public class CurrencyRate {
    private java.util.Date Date;
    private Date PreviousDate;
    private String PreviousURL;
    private Date Timestamp;
    private Map<String, Valute> Valute;

    public BigDecimal getRate(String currency) {
        return this.Valute.get(currency).Value;
    }
}

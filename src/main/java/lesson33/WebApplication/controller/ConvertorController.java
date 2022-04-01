package lesson33.WebApplication.controller;

import lesson33.WebApplication.dto.CurrencyValue;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConvertorController {


    @PostMapping("/convert")
    public CurrencyValue convert(){
       return new CurrencyValue(100.00, "тест");
    }

}

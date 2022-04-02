package lesson33.WebApplication.dto;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

//Переменные указаны с заглавной буквы для корректной десериализации из json с сайта курсов ЦБ

@AllArgsConstructor
public class Valute {
    private String ID;
    private Integer NumCode;
    private String CharCode;
    private Integer Nominal;
    private String Name;
    BigDecimal Value;
    private BigDecimal Previous;
}

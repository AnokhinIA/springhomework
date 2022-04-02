package lesson33.WebApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class CurrencyValue {
    private BigDecimal value;
    private String sourceCurrency;
    private String resultCurrency;

}

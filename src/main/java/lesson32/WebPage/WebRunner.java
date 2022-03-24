package lesson32.WebPage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
Сверстать простенькую HTML-страницу, на которой разместить текстовые поля, чекбоксы, комбобоксы
и прочие HTML-элементы, кнопку для отправки данных, обернув их в форму.
Также предлагается добавить CSS-правил и код JS для валидации передаваемых клиентом данных.
 */

@SpringBootApplication
public class WebRunner {
    public static void main(String[] args) {
        SpringApplication.run(WebRunner.class, args);
    }
}

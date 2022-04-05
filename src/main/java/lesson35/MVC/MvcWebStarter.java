package lesson35.MVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
1. Реализовать веб-приложение с набором CRUD-операций для произвольного справочника (например, справочника регионов/городов, товаров и т.д.)
по аналогии с приведенным на вебинаре примером. В качестве шаблонизатора использовать Thymeleaf.
2*. Реализовать поддержку локализации приложения с переключением локали через параметр запроса.
 */

@SpringBootApplication
public class MvcWebStarter {
    public static void main(String[] args) {
        SpringApplication.run(MvcWebStarter.class,args);
    }
}

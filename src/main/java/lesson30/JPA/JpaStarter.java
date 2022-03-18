package lesson30.JPA;

/*
Реализовать поддержку справочника городов (или любого другого справочника),
сохраняя информацию в БД, введенную пользователем через консоль. Среди атрибутов города следует отметить код города,
наименование на русском и английском языке, численность проживающих. Манипулирование с данными в БД следует осуществлять,
используя технологию Spring Data JPA, а при взаимодействии с пользователем полагаться на возможности Spring Shell,
предоставляя CRUD-операции.
*Исходное создание схемы БД рекомендуется сделать через скрипты миграции (liquibase).
Реализован другой справочник.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaStarter {
    public static void main(String[] args) {
        SpringApplication.run(JpaStarter.class, args);
    }
}

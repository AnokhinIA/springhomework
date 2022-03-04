package lesson29.Zipper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
1. С помощью Spring Boot реализовать приложение-архиватор, который получает от пользователя расположение до файла,
 который предполагается сжать/заархивировать, используя встроенные возможности Java (из пакета java.util.zip)
  или полагаясь на сторонние библиотеки (например, zip4j).
2. Наряду с архивацией также предлагается добавить возможность разархивирования файлов.
3*. Поддержать возможность разархивации «запароленного» архива.
*/


@SpringBootApplication
public class ShellZipRunner {
    public static void main(String[] args) {
        SpringApplication.run(ShellZipRunner.class,args);
    }
}

package itpark2021.homework.spring.springhomework;

import itpark2021.homework.spring.springhomework.service.ImpArchivation;
import net.lingala.zip4j.ZipFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;


@SpringBootApplication
public class SpringhomeworkApplication {

    public static void main(String[] args) throws IOException {

		final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringhomeworkApplication.class, args);

		MessageSource messageSource = (MessageSource) applicationContext.getBean("messageSource");
		Locale locale = new Locale("ru");

		System.out.println(messageSource.getMessage("welcome", null,locale));
		System.out.println(messageSource.getMessage("choice", null,locale));
		//Zip файл

		Path path = Path.of(new File("").getAbsolutePath()+"/src/main/resources/archives/");

		try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
			for (Path p : files)
				System.out.println(p.getFileName());
		}

		//Архивация
		ImpArchivation activation = (ImpArchivation) applicationContext.getBean("activation");
		activation.setMessageSource(messageSource);
		activation.setLocale(locale);
		activation.zip(path.toString());

		//Разархивация
		File destDir = new File("src/main/resources/archives/compressed.zip");
		File parent = new File("src/main/resources/archives/unzip/");
		ZipFile zipFile = new ZipFile(destDir);
		zipFile.extractAll(String.valueOf(parent));


    }

}

package itpark2021.homework.spring.springhomework;

import itpark2021.homework.spring.springhomework.dto.TestSpring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringhomeworkApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringhomeworkApplication.class, args);
		TestSpring test = (TestSpring) applicationContext.getBean("Test");
		test.print();

	}
}

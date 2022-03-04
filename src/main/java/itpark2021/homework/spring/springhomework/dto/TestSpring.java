package itpark2021.homework.spring.springhomework.dto;

import org.springframework.stereotype.Component;

@Component("Test")
public class TestSpring implements TestSpringInterface{
    @Override
    public void print(){
        System.out.println("Тест работоспособоности Spring");
    }
}

package spring.app.fin.lesson_14_hw;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;


//@Component
public class ClassicalMusic implements Music {

    @PostConstruct
    public void doMyInit(){
        System.out.println("Doing my initialization");
    }

    @PreDestroy
    public void doMyDestroy(){
        System.out.println("Doing my destruction");
    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}

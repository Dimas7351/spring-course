package spring.app.fin.lesson_13;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {

    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}

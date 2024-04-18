package spring.app.fin.lesson_12_qualifier;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {

    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}

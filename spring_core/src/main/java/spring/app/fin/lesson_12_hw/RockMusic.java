package spring.app.fin.lesson_12_hw;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music {

    String[] songs = {"Wind cries Mary", "Три дня дождя", "Тринадцать карат"};

    @Override
    public String[] getSongs() {

        return songs;
    }
}

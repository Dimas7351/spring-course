package spring.app.fin.lesson_12_hw;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {

    private String[] songs = {"Hungarian Rhapsody", "Bethoven", "Vivaldi"};
    @Override
    public String[] getSongs() {
        return songs;
    }
}

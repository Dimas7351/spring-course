package spring.app.fin.lesson_14_hw_with_annotations;

import org.springframework.stereotype.Component;

@Component
public class JazzMusic implements Music {

    @Override
    public String getSong() {
        return "Ya hz voobsche";
    }
}

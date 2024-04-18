package spring.app.fin.lesson_5;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.app.fin.lesson_1.TestBean;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "lesson_5/applicationContext.xml"
        );

        // Модифицировали xml, чтобы автоматически DI внедряло bean в конструктор
//        Music music = context.getBean("musicBean", Music.class);
//        MusicPlayer musicPlayer = new MusicPlayer(music);

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();

        context.close();
    }
}

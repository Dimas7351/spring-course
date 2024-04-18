package spring.app.fin.lesson_11_autowired;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "lesson_11/applicationContext.xml"
        );

//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//
//        musicPlayer.playMusic();

        Computer computer = context.getBean("computer", Computer.class);
        System.out.println(computer);

        context.close();
    }
}

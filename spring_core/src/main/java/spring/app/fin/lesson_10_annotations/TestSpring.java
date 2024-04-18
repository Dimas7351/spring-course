package spring.app.fin.lesson_10_annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "lesson_10/applicationContext.xml"
        );

        Music music = context.getBean("classicalMusic", Music.class);
        Music music2 = context.getBean("rockMusic", Music.class);

        MusicPlayer musicPlayer = new MusicPlayer(music);
        MusicPlayer musicPlayer1 = new MusicPlayer(music2);

        musicPlayer.playMusic();
        musicPlayer1.playMusic();

        context.close();
    }
}

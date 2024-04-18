package spring.app.fin.lesson_7_DI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "lesson_7/applicationContext.xml"
        );

        // Модифицировали xml, чтобы автоматически DI внедряло bean в конструктор
//        Music music = context.getBean("musicBean", Music.class);
//        MusicPlayer musicPlayer = new MusicPlayer(music);

        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        musicPlayer.playMusic();

        boolean comparison = firstMusicPlayer == secondMusicPlayer;
        System.out.println(comparison);

        System.out.println(firstMusicPlayer);
        System.out.println(secondMusicPlayer);

        firstMusicPlayer.setVolume(10);

        System.out.println(firstMusicPlayer.getVolume());
        System.out.println(secondMusicPlayer.getVolume());

        /*
        При settere происходит
        MusicPLayer musicPlayer = new MusicPLayer();
        musicPLayer.setMusic(ref); // передает ссылку на musicBean
         */

//        System.out.println(musicPlayer.getName());
//        System.out.println(musicPlayer.getVolume());

        context.close();
    }
}

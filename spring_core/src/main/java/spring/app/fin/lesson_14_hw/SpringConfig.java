package spring.app.fin.lesson_14_hw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
//@ComponentScan("spring.app.fin.lesson_14")
@PropertySource("classpath:lesson_13/musicPlayer.properties")
public class SpringConfig {
    @Bean
    public ClassicalMusic classicalMusic(){
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }

    @Bean
    public JazzMusic jazzMusic() { return new JazzMusic(); }

    @Bean
    public List<Music> genres() { return Arrays.asList(classicalMusic(), rockMusic(), jazzMusic());
    }

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(genres());
    }

    @Bean
    public Computer computer(){
        return new Computer(musicPlayer());
    }
}

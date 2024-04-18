package spring.app.fin.lesson_14_hw_with_annotations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    private List<Music> genres = new ArrayList<>();

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    @Autowired
    public MusicPlayer(List<Music> genres) {
        this.genres = genres;
    }

    public String playMusic(){
        Random random = new Random();
        int rand = random.nextInt(3);

        return "Playing + " + genres.get(rand).getSong();
    }
}

package spring.app.fin.lesson_7_HW;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {


    private List<Music> musicList = new ArrayList<>();
    
    private String name;
    private int volume;

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void playMusicList(){
        for (Music music : musicList)
            System.out.println("Playing " + music.getSong());
    }

    // Нужно создать пустой конструктор, чтобы в xml можно было внедрить bean через setter
    public MusicPlayer(){}


}

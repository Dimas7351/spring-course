package spring.app.fin.lesson_10_annotations;

public class MusicPlayer {
    private Music music;

    // IoC
    public MusicPlayer(Music music){
        this.music = music;
    }

    public void playMusic(){
        System.out.println("Playing " + music.getSong());
    }
}

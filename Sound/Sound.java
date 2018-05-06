package Sound;





import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eelik
 */
public class Sound {

String file;
Media sound;
private static MediaPlayer player;

public Sound(String file) {
        this.file = file;
        this.sound = new Media(new File(file).toURI().toString());
        Sound.player = new MediaPlayer(sound);
    }

    public void play(){
        player.play();
    }

    public void stop(){
        player.stop();
    }
    

    public static void setVolume(double value){
        player.setVolume(value);
    }

    public double getVolume(){
        return player.getVolume();
    }
}





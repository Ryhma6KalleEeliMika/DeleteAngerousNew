
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kalle
 */
public class SoundFX {
    
    public static void main(String[] args) {
     
        try{
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(SoundFX.class.getResourceAsStream("sound2.wav"));
            clip.open(ais);
            System.out.println(clip.getFrameLength());
            clip.setFramePosition(3000);
            clip.start();
            Thread.sleep(10000);
            clip.close();
        }
        catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}

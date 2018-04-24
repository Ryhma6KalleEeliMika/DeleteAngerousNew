/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sound;

import static Main.main.soundPath;

/**
 *
 * @author eelik
 */
public class SoundEffects {

public static void Sound(String file){
        Sound Sound = new Sound(soundPath+file);
        Sound.play();
    }
}

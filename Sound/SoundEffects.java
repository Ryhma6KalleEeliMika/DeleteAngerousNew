/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sound;

import Main.main;

/**
 *
 * @author eelik
 */
public class SoundEffects {

public static void Sound(String file){
        Sound Sound = new Sound(main.SOUNDPATH+file);
        Sound.play();
    }
}

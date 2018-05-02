package Objects;

import javafx.scene.image.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mika Vuorinen
 */
public class Weapon {
    
    private String name;    //Unarmed, Mining laser, Pulse laser, Multi cannon
    
    private int weaponDmg;
    
    private Image weaponImage;
    
    private final int unarmed = 0;
    
    private final int miningLaserDmg = 10;
    
    private final int pulseLaserDmg = 60;
    
    private final int multiCannonDmg = 85;
    
    //Constructor
    public Weapon(String moduleName){
        setName(moduleName);
        Image newWpnImage = new Image("Images/Modules/" + moduleName + ".png");
        setWeaponImage(newWpnImage);
        switch(moduleName) {
            case "Unarmed":
                setWeaponDmg(unarmed);
                break;
                
                case "Mining Laser":
                setWeaponDmg(miningLaserDmg);
                break;
                
                case "Pulse Laser":
                setWeaponDmg(pulseLaserDmg);
                break;
                
                case "Multi-cannon":
                setWeaponDmg(multiCannonDmg);
                break;
        }
    }
    
    
    //Setters and getters................................
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeaponImage(Image weaponImage) {
        this.weaponImage = weaponImage;
    }

    public Image getWeaponImage() {
        return weaponImage;
    }

    public void setWeaponDmg(int weaponDmg) {
        this.weaponDmg = weaponDmg;
    }

    public int getWeaponDmg() {
        return weaponDmg;
    }

    public int getMiningLaserDmg() {
        return miningLaserDmg;
    }

    public int getMultiCannonDmg() {
        return multiCannonDmg;
    }

    public int getPulseLaserDmg() {
        return pulseLaserDmg;
    }

    public int getUnarmed() {
        return unarmed;
    }
    
}

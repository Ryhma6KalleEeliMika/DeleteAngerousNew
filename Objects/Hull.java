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
public class Hull {
    private int hull;
    private int maxHull;
    private String name;    //Lightweight, Reinforced, Military
    private Image hullImage;
    
    private final int lightweightArmor = 100;
    
    private final int reinforcedArmor = 200;
    
    private final int militaryArmor = 300;
    
    //Constructor
    public Hull(String moduleName){
        setName(moduleName);
        Image newHullImage = new Image("Images/Modules/" + moduleName + ".png");
        setHullImage(newHullImage);
        switch(moduleName) {
            case "Lightweight":
                setMaxHull(lightweightArmor);
                setHull(getMaxHull());
                break;
                
                case "Reinforced":
                setMaxHull(reinforcedArmor);
                setHull(getMaxHull());
                break;
                
                case "Military":
                setMaxHull(militaryArmor);
                setHull(getMaxHull());
                break;
        }
    }
    
    //Hull loss method
    public void hullLoss(int hullLoss){
        setHull(hull - hullLoss);
    }
    
    //Hull gain method "Not used yet."
    public void hullGain(int hullGain){
        if(hullGain + getHull() >= getMaxHull()){
            setHull(getMaxHull());
        }
        else{
            setHull(getHull() + hullGain);
        }    
    }
    
    //Setters and getters................................
    public int getHull() {
        return hull;
    }

    public void setHull(int hull) {
        this.hull = hull;
    }

    public int getMaxHull() {
        return maxHull;
    }

    public void setMaxHull(int maxHull) {
        this.maxHull = maxHull;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHullImage(Image hullImage) {
        this.hullImage = hullImage;
    }

    public Image getHullImage() {
        return hullImage;
    }

    public int getLightweightArmor() {
        return lightweightArmor;
    }

    public int getReinforcedArmor() {
        return reinforcedArmor;
    }

    public int getMilitaryArmor() {
        return militaryArmor;
    }
}

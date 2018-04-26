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
    private double hull;
    private double maxHull;
    private String name;    //Lightweight, Reinforced, Military
    private Image hullImage;
    
    private final double lightweightArmor = 1;
    
    private final double reinforcedArmor = 200;
    
    private final double militaryArmor = 300;
    
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
    public void hullLoss(double hullLoss){
        setHull(hull - hullLoss);
    }
    
    //Hull gain method "Not used yet."
    public void hullGain(double hullGain){
        if(hullGain + getHull() >= getMaxHull()){
            setHull(getMaxHull());
        }
        else{
            setHull(getHull() + hullGain);
        }    
    }
    
    //Setters and getters................................
    public double getHull() {
        return hull;
    }

    public void setHull(double hull) {
        this.hull = hull;
    }

    public double getMaxHull() {
        return maxHull;
    }

    public void setMaxHull(double maxHull) {
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

    public double getLightweightArmor() {
        return lightweightArmor;
    }

    public double getReinforcedArmor() {
        return reinforcedArmor;
    }

    public double getMilitaryArmor() {
        return militaryArmor;
    }
}

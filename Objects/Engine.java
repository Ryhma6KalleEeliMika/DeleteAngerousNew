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
public class Engine {
    
    private int fuelUsageJump;
    
    private int fuelUsageTravel;
    
    private String name;    //Basic, Advanced, Elite
    
    private Image engineImage;
    
    private final int basicEngJump = 15;
    
    private final int basicEngTravel = 2;
    
    private final int advancedEngJump = 10;
    
    private final int advancedEngTravel = 1;
    
    private final int eliteEngineJump = 5;
    
    private final int eliteEngineTravel = 0;
    
    public Engine(String moduleName){

        setName(moduleName);
        Image image = new Image("Images/Modules/" + moduleName + ".png");
        setEngineImage(image);
        
        switch(moduleName){
            case "Basic":
                setFuelUsageJump(basicEngJump);
                setFuelUsageTravel(basicEngTravel);
                break;
                
            case "Advanced":
                setFuelUsageJump(advancedEngJump);
                setFuelUsageTravel(advancedEngJump);
                break;
                                
            case "Elite":
                setFuelUsageJump(eliteEngineJump);
                setFuelUsageTravel(eliteEngineTravel);
                break;
        }
    }

    //Setters and getters.................................
    public int getFuelUsageJump() {
        return fuelUsageJump;
    }

    public void setFuelUsageJump(int fuelUsageJump) {
        this.fuelUsageJump = fuelUsageJump;
    }

    public int getFuelUsageTravel() {
        return fuelUsageTravel;
    }

    public void setFuelUsageTravel(int fuelUsageTravel) {
        this.fuelUsageTravel = fuelUsageTravel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getEngineImage() {
        return engineImage;
    }

    public void setEngineImage(Image engineImage) {
        this.engineImage = engineImage;
    }

    public int getBasicEngJump() {
        return basicEngJump;
    }

    public int getBasicEngTravel() {
        return basicEngTravel;
    }

    public int getAdvancedEngJump() {
        return advancedEngJump;
    }

    public int getAdvancedEngTravel() {
        return advancedEngTravel;
    }

    public int getEliteEngineJump() {
        return eliteEngineJump;
    }

    public int getEliteEngineTravel() {
        return eliteEngineTravel;
    }
}

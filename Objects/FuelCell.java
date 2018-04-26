package Objects;

import javafx.scene.image.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kalle Mustonen
 */
public class FuelCell {
    private double fuel;
    
    private double maxFuel;
    
    private String name;    //Small, Medium, Large
    
    private Image fuelImage;
    
    private final double smallMaxFuel = 100;
    
    private final double mediumMaxFuel = 150;
    
    private final double largeMaxFuel = 200;
    
    //Fuel loss method
    public void fuelLoss(double fuelLoss){
        setFuel(fuel - fuelLoss);
    }
    
    //Fuel gain method
    public void fuelGain(double fuelGain){
        if(fuelGain + getFuel() >= getMaxFuel()){
            setFuel(getMaxFuel());
        }
        else{
            setFuel(getFuel() + fuelGain);
        }
    }
    
    //Constructor
    public FuelCell(String moduleName){
        
        setName(moduleName);
        Image image = new Image("Images/Modules/" + moduleName + ".png");
        setFuelImage(image);
        
        //Fuel cell type selection.
        switch(moduleName){
            case "Small":
                setMaxFuel(smallMaxFuel);
                setFuel(getMaxFuel());
                break;
                
            case "Medium":
                setMaxFuel(mediumMaxFuel);
                setFuel(getMaxFuel());
                break;
                
            case "Large":
                setMaxFuel(largeMaxFuel);
                setFuel(getMaxFuel());
                break;
        }
    }
    
    //Setters and getters................................
    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getMaxFuel() {
        return maxFuel;
    }

    public void setMaxFuel(double maxFuel) {
        this.maxFuel = maxFuel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFuelImage(Image fuelImage) {
        this.fuelImage = fuelImage;
    }

    public Image getFuelImage() {
        return fuelImage;
    }

    public double getSmallMaxFuel() {
        return smallMaxFuel;
    }

    public double getMediumMaxFuel() {
        return mediumMaxFuel;
    }

    public double getLargeMaxFuel() {
        return largeMaxFuel;
    }
}

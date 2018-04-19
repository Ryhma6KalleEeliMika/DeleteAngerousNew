package Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mika Vuorinen
 */
public class FuelCell {
    private int fuel;
    private int maxFuel;
    private String name;    //Small, Medium, Large
    
    //Fuel loss method
    public void fuelLoss(int fuelLoss){
        setFuel(fuel - fuelLoss);
    }
    
    //Fuel gain method
    public void fuelGain(int fuelGain){
        if(fuelGain + getFuel() >= getMaxFuel()){
            setFuel(getMaxFuel());
        }
        else{
            setFuel(getFuel() + fuelGain);
        }
    }
    
    //Constructor
    FuelCell(int newMaxFuel, String newName){
        setMaxFuel(newMaxFuel);
        setFuel(newMaxFuel);
        setName(newName);
    }
    
    //Setters and getters................................
    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getMaxFuel() {
        return maxFuel;
    }

    public void setMaxFuel(int maxFuel) {
        this.maxFuel = maxFuel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

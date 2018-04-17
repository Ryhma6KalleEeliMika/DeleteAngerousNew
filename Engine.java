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
    
    Engine(int newFuelUsageJump, int newFuelUsageTravel, String newName){
        setFuelUsageJump(newFuelUsageJump);
        setFuelUsageTravel(newFuelUsageTravel);
        setName(newName);
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
}

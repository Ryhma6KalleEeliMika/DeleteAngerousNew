

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kalle
 */
public class Ship {
    //Ship's info
    private final String NAME = "Python mkII";
    private String location;
    private Star star;
    private String planetName = "";
    private Planet planet;
    private int fuel = 100;
    private int oxygen = 100;
    private int hull = 100;

    //Ship's constructor
    Ship(String location, Star star) {
        setLocation(location);
        setStar(star);
    }
    
    //Fuel loss method
    public void fuelLoss(int fuelLoss){
        setFuel(fuel - fuelLoss);
    }
    
    //Fuel gain method "Not used yet."
    public void fuelGain(int fuelGain){
        setFuel(fuel + fuelGain);
    }

    //Prints the name of the current star system.
    public String currentStarName() {
        Star currentStar = getStar();
        return currentStar.getName();
    }

    //Getters and setters.........................................................
    public String getNAME() {
        return NAME;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public Star getStar() {
        return star;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getOxygen() {
        return oxygen;
    }

    public void setOxygen(int oxygen) {
        this.oxygen = oxygen;
    }

    public int getHull() {
        return hull;
    }

    public void setHull(int hull) {
        this.hull = hull;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getPlanetName() {
        return planetName;
    }
}
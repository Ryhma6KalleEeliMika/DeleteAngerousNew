

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
    private String name;
    private String currentStarName;
    private Star currentStar;
    private String currentPlanetName = "";
    private Planet currentPlanet;
    //private int fuel = 10000;
    //private int oxygen = 100;
    //private int hull = 100;
    private int starsScanned = 0;
    private int planetsScanned = 0;
    private FuelCell shipFuelCell;
    private Hull shipHull;
    private Engine shipEngine;

    //Ship's constructor
    Ship(String location, Star star, String newName) {
        setName(newName);
        setLocation(location);
        setStar(star);
        switch(newName){
            case "eaglemkII":
                FuelCell newFuelCell = new FuelCell(100, "Small Fuelcell");
                Hull newHull = new Hull(100, "Alloy Hull");
                Engine newEngine = new Engine(10, 1, "Reinforced Engine");
                setShipEngine(newEngine);
                setShipFuelCell(newFuelCell);
                setShipHull(newHull);
                break;
            case "hauler":
                FuelCell newFuelCell2 = new FuelCell(150, "Huge Fuelcell");
                Hull newHull2 = new Hull(75, "Lightweight Alloy Hull");
                Engine newEngine2 = new Engine(11, 2, "Small Engine");
                setShipEngine(newEngine2);
                setShipFuelCell(newFuelCell2);
                setShipHull(newHull2);
                break;
            case "adder":
                FuelCell newFuelCell3 = new FuelCell(125, "Fuelcell");
                Hull newHull3 = new Hull(150, "Reinforced Alloy Hull");
                Engine newEngine3 = new Engine(12, 1, "Engine");
                setShipEngine(newEngine3);
                setShipFuelCell(newFuelCell3);
                setShipHull(newHull3);
                break;
        }
    }
    
    //Fuel loss method
    /*public void fuelLoss(int fuelLoss){
        setFuel(fuel - fuelLoss);
    }
    
    //Fuel gain method "Not used yet."
    public void fuelGain(int fuelGain){
        setFuel(fuel + fuelGain);
    }
    //Hull loss method
    public void hullLoss(int hullLoss){
        setHull(hull - hullLoss);
    }
    
    //Hull gain method
    public void hullGain(int hullGain){
        setHull(hull + hullGain);
    }*/

    //Prints the name of the current currentStar system.
    public String currentStarName() {
        Star currentStar = getStar();
        return currentStar.getName();
    }
    
    
    
    //Getters and setters.........................................................
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public void setStar(Star star) {
        this.currentStar = star;
    }

    public Star getStar() {
        return currentStar;
    }

    public String getLocation() {
        return currentStarName;
    }

    public void setLocation(String location) {
        this.currentStarName = location;
    }

    /*public int getFuel() {
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
    }*/

    
    public void setPlanet(Planet planet) {
        this.currentPlanet = planet;
    }

    public Planet getPlanet() {
        return currentPlanet;
    }

    public void setPlanetName(String planetName) {
        this.currentPlanetName = planetName;
    }

    public String getPlanetName() {
        return currentPlanetName;
    }

    public void setStarsScanned(int starsScanned) {
        this.starsScanned = starsScanned;
    }

    public int getStarsScanned() {
        return starsScanned;
    }

    public void setPlanetsScanned(int planetsScanned) {
        this.planetsScanned = planetsScanned;
    }

    public int getPlanetsScanned() {
        return planetsScanned;
    }

    public Engine getShipEngine() {
        return shipEngine;
    }

    public void setShipEngine(Engine shipEngine) {
        this.shipEngine = shipEngine;
    }

    public FuelCell getShipFuelCell() {
        return shipFuelCell;
    }

    public void setShipFuelCell(FuelCell shipFuelCell) {
        this.shipFuelCell = shipFuelCell;
    }

    public Hull getShipHull() {
        return shipHull;
    }

    public void setShipHull(Hull shipHull) {
        this.shipHull = shipHull;
    }
    
}
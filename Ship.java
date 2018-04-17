

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
        
        //Ship module creation based on the chosen ship's name.
        switch(newName){
            case "eaglemkII":
                FuelCell newFuelCell = new FuelCell(100, "Small");
                Hull newHull = new Hull(100, "Lightweight");
                Engine newEngine = new Engine(10, 1, "Advanced");
                setShipEngine(newEngine);
                setShipFuelCell(newFuelCell);
                setShipHull(newHull);
                break;
                
            case "hauler":
                FuelCell newFuelCell2 = new FuelCell(100, "Small");
                Hull newHull2 = new Hull(200, "Reinforced");
                Engine newEngine2 = new Engine(15, 2, "Basic");
                setShipEngine(newEngine2);
                setShipFuelCell(newFuelCell2);
                setShipHull(newHull2);
                break;
                
            case "adder":
                FuelCell newFuelCell3 = new FuelCell(150, "Medium");
                Hull newHull3 = new Hull(100, "Lightweight");
                Engine newEngine3 = new Engine(15, 2, "Basic");
                setShipEngine(newEngine3);
                setShipFuelCell(newFuelCell3);
                setShipHull(newHull3);
                break;
        }
    }
    
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
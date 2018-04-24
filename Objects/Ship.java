package Objects;


import Main.main;
import Objects.Engine;
import Objects.FuelCell;
import javafx.scene.image.Image;



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
    private boolean fuelScoopInstalled = false;
    private Image fuelScoopImage;
    private int Credits = 0;
    

    //Ship's constructor
    public Ship(String location, Star star, String newName) {
        setName(newName);
        setCurrentStarName(location);
        setStar(star);
        Image shipsImage = new Image("Images/Ships/" + newName + ".png");
        main.setShipImage(shipsImage);
        Image scoopImage = new Image("Images/Modules/FuelScoop.png");
        setFuelScoopImage(scoopImage);
        
        //Ship module creation based on the chosen ship's name.
        switch(newName){
            case "Eagle MkII":  //Eagle MkII ship
                FuelCell newFuelCell = new FuelCell("Small");
                Hull newHull = new Hull("Lightweight");
                Engine newEngine = new Engine("Advanced");
                setShipEngine(newEngine);
                setShipFuelCell(newFuelCell);
                setShipHull(newHull);
                break;
                
            case "Hauler":  //Hauler ship
                FuelCell newFuelCell2 = new FuelCell("Small");
                Hull newHull2 = new Hull("Reinforced");
                Engine newEngine2 = new Engine("Basic");
                setShipEngine(newEngine2);
                setShipFuelCell(newFuelCell2);
                setShipHull(newHull2);
                break;
                
            case "Adder":   //Adder ship
                FuelCell newFuelCell3 = new FuelCell("Medium");
                Hull newHull3 = new Hull("Lightweight");
                Engine newEngine3 = new Engine("Basic");
                setShipEngine(newEngine3);
                setShipFuelCell(newFuelCell3);
                setShipHull(newHull3);
                break;
        }
    }
    
    //Gain credits method
    public void gainCredits(int ammount) {
        setCredits(getCredits() + ammount);
    }
    
    //Lose credits method
    public void loseCredits(int ammount) {
        setCredits(getCredits() - ammount);
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

    public String getCurrentStarName() {
        return currentStarName;
    }

    public void setCurrentStarName(String location) {
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

    public void setCredits(int Credits) {
        this.Credits = Credits;
    }

    public int getCredits() {
        return Credits;
    }

    public void setFuelScoopInstalled(boolean fuelScoopInstalled) {
        this.fuelScoopInstalled = fuelScoopInstalled;
    }
    
    public boolean getFuelScoopInstalled() {
        return fuelScoopInstalled;
    }

    public void setFuelScoopImage(Image fuelScoopImage) {
        this.fuelScoopImage = fuelScoopImage;
    }

    public Image getFuelScoopImage() {
        return fuelScoopImage;
    }
}
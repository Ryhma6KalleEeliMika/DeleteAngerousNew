package Objects;


import Main.main;
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
    private String name, currentStarName;
    
    private Star currentStar;
    
    private String currentPlanetName = "";
    
    private Planet currentPlanet;
    
    private int starsScanned = 0;
    
    private int planetsScanned = 0;
    
    private FuelCell shipFuelCell;
    
    private Hull shipHull;
    
    private Engine shipEngine;
    
    private Weapon shipWeapon;
    
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
                Engine newEngine = new Engine("Basic");
                Weapon newWeapon = new Weapon("Pulse Laser");
                setShipWeapon(newWeapon);
                setShipEngine(newEngine);
                setShipFuelCell(newFuelCell);
                setShipHull(newHull);
                break;
                
            case "Hauler":  //Hauler ship
                FuelCell newFuelCell2 = new FuelCell("Small");
                Hull newHull2 = new Hull("Reinforced");
                Engine newEngine2 = new Engine("Basic");
                Weapon newWeapon2 = new Weapon("Mining Laser");
                setShipWeapon(newWeapon2);
                setShipEngine(newEngine2);
                setShipFuelCell(newFuelCell2);
                setShipHull(newHull2);
                break;
                
            case "Adder":   //Adder ship
                FuelCell newFuelCell3 = new FuelCell("Medium");
                setFuelScoopInstalled(true);
                Hull newHull3 = new Hull("Lightweight");
                Engine newEngine3 = new Engine("Basic");
                Weapon newWeapon3 = new Weapon("Unarmed");
                setShipWeapon(newWeapon3);
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
    
    //Method for traveling to between stars.
    public String starJump(Star destinationStar) {
        if (getShipFuelCell().getFuel() >= getShipEngine().getFuelUsageJump()) { //If fuel is above the current engine's jump fuel usage.
            setStar(destinationStar); //Ship's star is set to the new star.
            setCurrentStarName(destinationStar.getName());
            getShipFuelCell().fuelLoss(getShipEngine().getFuelUsageJump());  //Ship loses fuel after the jump
            setPlanet(null); //Ship is not orbiting any planet after jump.
            setPlanetName("");
            return "Jump succesful";        
        }
        else {  //If not enough fuel for the jump.
            return "Not enough fuel for jump!";
        }
    }
    
    
    //Method for traveling between planet.
    public String planetTravel(Planet destinationPlanet) {
        if (getPlanetName().equals(destinationPlanet.getName())) {  //Checks if the player is already orbiting the destination planet.
            return "Already orbiting " + getPlanetName();
        }
        else if (getShipFuelCell().getFuel() >= getShipEngine().getFuelUsageTravel()) { //Checks if there is enough fuel.
                getShipFuelCell().fuelLoss(getShipEngine().getFuelUsageTravel()); //Fuel depletes.
                setPlanet(destinationPlanet); //Sets ships current planet as the new planet.
                setPlanetName(destinationPlanet.getName()); //Sets ships current planet name as the new planet.
                return "Orbiting " + destinationPlanet.getName();
            }
        else { //If no enough fuel.
            return "Travel failed. Not enough fuel!";
        }
    }
    
    public String starScanner() {
        if(!currentStar.isScanned()) {
            main.starMap.put(currentStarName, true);
            currentStar.setScanned(true);
            starsScannedCounter();
            gainCredits(5);
            return currentStarName + " scanned +5cr";
        }
        else {
            return "";
        }
    }
    
    private void starsScannedCounter() {
        setStarsScanned(getStarsScanned() + 1);
    }
    
    public String planetScanner() {
        if(!currentPlanet.isScanned()) {
            main.planetMap.put(currentPlanetName, true);
            currentPlanet.setScanned(true);
            planetScannedCounter();
            gainCredits(1);
            return currentPlanetName + " scanned +1cr";
        }
        else {
            return "";
        }
    }
    
    private void planetScannedCounter() {
        setPlanetsScanned(getPlanetsScanned() + 1);
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

    public Weapon getShipWeapon() {
        return shipWeapon;
    }

    public void setShipWeapon(Weapon shipWeapon) {
        this.shipWeapon = shipWeapon;
    }
}
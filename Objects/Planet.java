package Objects;


import javafx.scene.image.Image;
import Main.main;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.concurrent.ThreadLocalRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kalle
 */
public class Planet {
    
    //Name of the planet and the type: rock, lava, ring, gas, terran(earth like), water or ice.
    private String name, type, resGrade;
    
    //Planet's surface
    private Surface planetSurface;
    
    //Planet's parent star.
    private Star parentStar;
    
    //Planetäs "Orbiting reticle" image.
    private Image planetImage;
    
    //Resources and tax for terran planets
    private int resources, tax;
    
    private String population = "0";
    
    //Planets rng story
    private Story story;
    
    //Checks if the planet has been explored
    private boolean explored;

    //Checks if the planet has been scanned.
    private boolean scanned;
    
    //Constructor  
    public Planet(Star parent, String name, String type,Image planetImage) {
        setName(name);
        Surface newSurface = new Surface(name);
        setPlanetSurface(newSurface);
        setParentStar(parent);
        setPlanetImage(planetImage);
        setType(type);
        main.planetMap.put(name, false);
        
        try{
            if (type.equals("rock") || type.equals("lava")) {
                resourceGeneration(type);
            }
            else if(type.equals("terran")) {
                terranGeneration();
            }
            
            else if (type.equals("black hole")) {
                
            }
            
            else {
                storyGeneration();
            }
        }
        catch (Exception e) {
        }
    }
    
    //Story generation
    private void storyGeneration() {
        Story story = new Story();
        setStory(story);
        setExplored(false);
    }
    
    //Generating resources and population for lava and rock planets
    private void resourceGeneration(String planetType){
            switch (planetType) {
                case "rock":
                    if (coinFlip() == 1) {  //Low resources 1 - 30
                        setResources(lowRes());
                        setResGrade("Low");
                    }
                    else {  //Medium resources 30 - 60
                        setResources(medRes());
                        setResGrade("Medium");
                    }
                    //Small population for rock planets 100 - 1000;
                    setPopulation(Integer.toString(ThreadLocalRandom.current().nextInt(100, 1000 + 1)));
                    break;
                    
                case "lava":
                    if (coinFlip() == 1) {  //Medium resources 30 - 60
                        setResources(medRes());
                        setResGrade("Medium");
                    }
                    else {  //High resources 60 - 100
                        setResources(highRes());
                        setResGrade("High");
                    }
                    break;
            }
    }
    
    //Setting population for terran planets.
    private void terranGeneration() {   //Population for earth-like planets 5.000.000.000 - 50.000.000.000
        setPopulation(Integer.toString(ThreadLocalRandom.current().nextInt(1, 50 + 1)) + ".000.000.000");
        
        //Add price variation to different shops
        setTax(ThreadLocalRandom.current().nextInt(-50, 50));
    }
    
    
    // 50/50 rng
    private int coinFlip() {
        return ThreadLocalRandom.current().nextInt(1, 2 + 1);
    }
    
    // Low resource rng
    private int lowRes() {
        return ThreadLocalRandom.current().nextInt(1, 30 + 1);    
    }
    
    // Medium resource rng
    private int medRes() {
        return ThreadLocalRandom.current().nextInt(30, 60 + 1);
    }
    
    // High resource rng
    private int highRes() {
        return ThreadLocalRandom.current().nextInt(60, 100 + 1);
    }
    
    //Getters and setters........................................................
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Star getParentStar() {
        return parentStar;
    }

    public void setParentStar(Star parentStar) {
        this.parentStar = parentStar;
    }

    public void setPlanetImage(Image planetImage) {
        this.planetImage = planetImage;
    }

    public Image getPlanetImage() {
        return planetImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPlanetSurface(Surface planetSurface) {
        this.planetSurface = planetSurface;
    }

    public Surface getPlanetSurface() {
        return planetSurface;
    }

    public int getResources() {
        return resources;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getResGrade() {
        return resGrade;
    }

    public void setResGrade(String resGrade) {
        this.resGrade = resGrade;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }  

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public void setExplored(boolean explored) {
        this.explored = explored;
    }
    
    public boolean getExplored() {
        return explored;
    }

    public void setScanned(boolean scanned) {
        this.scanned = scanned;
    }

    public boolean isScanned() {
        return scanned;
    }
}
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
    private String name, type;
    
    //Planet's surface
    private Surface planetSurface;
    
    //Planet's parent star.
    private Star parentStar;
    
    //Planetäs "Orbiting reticle" image.
    private Image planetImage;
    
    //Resources
    private int resources;
    
    private String population = "0";
    
    //Constructor  
    public Planet(Star parent, String name, String type,Image planetImage) {
        main.planetsScanned.put(name,false);
        setName(name);
        Surface newSurface = new Surface(name);
        setPlanetSurface(newSurface);
        setParentStar(parent);
        setPlanetImage(planetImage);
        setType(type);
        
        try{
                    
            if (type.equals("rock") || type.equals("lava")) {
                resourceGeneration(type);
            }

            else if(type.equals("terran")) {
                terranGeneration();
            }
        }
        catch (Exception e) {
            
        }

    }
    
    //
    private void resourceGeneration(String planetType){
            switch (planetType) {
                case "rock":
                    int lowMed = ThreadLocalRandom.current().nextInt(1, 2 + 1);
                    if (lowMed == 1) {  //Low resources 1 - 20
                        setResources(ThreadLocalRandom.current().nextInt(1, 20 + 1));
                    }
                    else {  //Medium resources 20 - 40
                        setResources(ThreadLocalRandom.current().nextInt(20, 40 + 1));
                    }
                    //Small population for rock planets 100 - 1000;
                    setPopulation(Integer.toString(ThreadLocalRandom.current().nextInt(100, 1000 + 1)));
                    break;
                    
                case "lava":
                    int medHigh = ThreadLocalRandom.current().nextInt(1, 2 + 1);
                    if (medHigh == 1) {  //Medium resources 20 - 40
                        setResources(ThreadLocalRandom.current().nextInt(1, 40 + 1));
                    }
                    else {  //High resources 40 - 80
                        setResources(ThreadLocalRandom.current().nextInt(40, 80 + 1));
                    }
                    break;
        }
    }
    
    private void terranGeneration() {   //Population for earth-like planets 5.000.000.000 - 50.000.000.000
        setPopulation(Integer.toString(ThreadLocalRandom.current().nextInt(5, 50 + 1)) + ".000.000.000");
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
}
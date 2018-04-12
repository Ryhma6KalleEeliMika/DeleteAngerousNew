
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
public class Planet {
    
    //Name of the planet and the type: rock, lava, ring, gas, terran(earth like), water or ice.
    private String name, type;
    
    //Planet's parent star.
    private Star parentStar;
    
    //Planetäs "Orbiting reticle" image.
    private Image planetImage;
    
    //Constructor  
    Planet(Star parent, String name, String type,Image planetImage) {
        setName(name);
        setParentStar(parent);
        setPlanetImage(planetImage);
        setType(type);
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
}
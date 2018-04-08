
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
    
    private String name;
    
    private Star parentStar;
    
    private Image planetImage;
    
    //Constructor
    Planet(Star parent, String name, Image planetImage) {
        setName(name);
        setParentStar(parent);
        setPlanetImage(planetImage);
        
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
}
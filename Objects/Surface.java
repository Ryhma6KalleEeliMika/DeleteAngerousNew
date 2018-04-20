package Objects;


import javafx.scene.image.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mika Vuorinen
 */
public class Surface {
    
    private Image surfaceImage;
    
    private String Name;
    
    private String imgPath = "Images/Surface/";
    
    //Constructor
    Surface(String newName){
        setName(newName);
        try{
            Image newImage = new Image(imgPath + Name + ".png");
            setSurfaceImage(newImage);
        }
        catch (Exception e){
        }
    }
    
    //Setters and getters..................................
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Image getSurfaceImage() {
        return surfaceImage;
    }

    public void setSurfaceImage(Image surfaceImage) {
        this.surfaceImage = surfaceImage;
    }
}

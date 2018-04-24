/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Main.main;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.image.Image;

/**
 *
 * @author Mika Vuorinen
 */
public class Story {
    
    private String story;
    
    private String conclusion1, conclusion2, option1, option2;
    
    private Image img;
    
    private final String imgPath = "Images/Story/";
    
    public Story(){
        switch (rng()) {
                    
            case 1:
                //Premise of the event.
                setStory("You see a stranded ship orbiting the planet. The ship hails you and asks you for a fuel.");
            
                //First option button text.
                setOption1("Give them 20 fuel");
                
                //Second option button text.
                setOption2("Don\'t give fuel");
                
                //Conclusion of the first option.
                setConclusion1("You gave them 20 fuel and they paid you 50cr.");

                //Conclusion of the second option.
                setConclusion2("You left them on their own.");
                
                //Image of the event
                Image img1 = new Image(imgPath + "stranded.png");
                setImg(img1);

                break;
                    
            //Pirate chase.
            case 2: 
                setStory("A pirate is chasing you and starts firing at you.");

                setOption1("Accelerate");

                setOption2("Dodge");

                setConclusion1("You escaped the pirate.");

                setConclusion2("You took few hits, but you managed to escape.");

                Image img2 = new Image(imgPath + "pirateAttack.png");

                setImg(img2);

                break;
            
            //Ship debris
            default: 
                setStory("You see a space debris most likely from a destroyed ship.");
            
                setOption1("Explore");

                setOption2("Don\'t explore");

                setConclusion2("You leave the scene.");

                Image img3 = new Image(imgPath + "shipDebris.png");

                setImg(img3);

                break;
        }
    }
    
    //Exploration rewards and label texts.
    public String reward(String rewardName, Story story){
        Ship myShip = main.getMyShip();
        switch(rewardName){
            
            //Find a stranded ship.
            case "Give them 20 fuel":
                if (myShip.getShipFuelCell().getFuel() >= 20) {
                    myShip.getShipFuelCell().fuelLoss(20);
                    myShip.gainCredits(50);
                    return "-20 fuel & +50cr";
                }
                else {
                    story.setConclusion1("You don't have enough fuel to give.");
                    return "";
                }
                
            case "Don\'t give fuel":
                break;
                
            //Pirate attacks you.
            case "Accelerate":
                myShip.getShipFuelCell().fuelLoss(10);
                return "-10 fuel";
                
            case "Dodge":
                myShip.getShipHull().hullLoss(20);
                return "Warning! Hull damage";
                
            //Ship debris exploration.
            case "Explore":
                switch (coinFlip()) {
                    
                    case 1: //Found a fuelcell in the debris.
                    story.setConclusion1("You found a fuelcell with some fuel left in it.");
                    myShip.getShipFuelCell().fuelGain(50);
                    return "+50 fuel";
                    
                    case 2: //A pirate attacks you.
                    story.setConclusion1("A pirate ambushes you, but you managed to escape.");
                    Image pirateImg = new Image(imgPath + "pirateAttack.png");
                    story.setImg(pirateImg);
                    myShip.getShipHull().hullLoss(20);
                    return "Warning! Hull damage";
                    
                    case 3: //Found some credits in the debris.
                    story.setConclusion1("You found some credits in the debris.");
                    myShip.gainCredits(20);
                    return "+20cr";
                }

            case "Don\'t explore":
                break;
        }
        return "";
    }
    //  rng for adventure creation
    private int rng() {
        return ThreadLocalRandom.current().nextInt(1, 5 + 1);
    }
    
    // sub rng for other stuff
    private int coinFlip() {
        return ThreadLocalRandom.current().nextInt(1, 3 + 1);
    }

    //Setters and getters.....................................................
    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getConclusion1() {
        return conclusion1;
    }

    public void setConclusion1(String conclusion1) {
        this.conclusion1 = conclusion1;
    }

    public String getConclusion2() {
        return conclusion2;
    }

    public void setConclusion2(String conclusion2) {
        this.conclusion2 = conclusion2;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption2() {
        return option2;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}

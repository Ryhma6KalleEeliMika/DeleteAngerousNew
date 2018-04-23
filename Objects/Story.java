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
    
    private String reward1, reward2;
    
    private Image img;
    
    private final String imgPath = "Images/Story/";
    
    public Story(){
        
        switch (coinFlip()) {
            
            case 1: setStory("You see a stranded ship orbiting the planet. The ship hails you and asks you for a fuel.");
            
                    setOption1("Give them 20 fuel");
                    
                    setOption2("Don\'t give fuel");
            
                    setConclusion1("You gave them 20 fuel and they paid you 50cr.");
                    
                    setConclusion2("You left them on their own.");
                    
                    Image img1 = new Image(imgPath + "stranded.png");
                    
                    setImg(img1);
                    
                    break;
                    
            case 2: setStory("A pirate is chasing you and starts firing at you.");
            
                    setOption1("Accelerate");
                    
                    setOption2("Dodge");
            
                    setConclusion1("You escaped the pirates.");
                    
                    setConclusion2("You took few hits, but were able to escape.");
                    
                    Image img2 = new Image(imgPath + "pirateAttack.png");
                    
                    setImg(img2);
                    
                    break;
                    
            case 3: setStory("You see a space debris most likely from a destroyed ship.");
            
                    setOption1("Explore");
                    
                    setOption2("Don\'t explore");
            
                    setConclusion1("You found fuelcell with some fuel left.");
                    
                    setConclusion2("You leave the scene.");
                    
                    Image img3 = new Image(imgPath + "shipDebris.png");
                    
                    setImg(img3);
                    
                    break;
        }
        
        
    }
    
    public void reward(String rewardName){
        Ship myShip = main.getMyShip();
        switch(rewardName){
            case "Give them 20 fuel":
                myShip.getShipFuelCell().fuelLoss(20);
                myShip.gainCredits(50);
                break;
            case "Don\'t give fuel":
                break;
            case "Accelerate":
                myShip.getShipFuelCell().fuelLoss(10);
                break;
            case "Dodge":
                myShip.getShipHull().hullLoss(20);
                break;
            case "Explore":
                myShip.getShipFuelCell().fuelGain(50);
                break;
            case "Don\'t explore":
                break;
        }
    }
    // 50/50 rng
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

    public String getReward1() {
        return reward1;
    }

    public void setReward1(String reward1) {
        this.reward1 = reward1;
    }

    public String getReward2() {
        return reward2;
    }

    public void setReward2(String reward2) {
        this.reward2 = reward2;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    
    
    
}

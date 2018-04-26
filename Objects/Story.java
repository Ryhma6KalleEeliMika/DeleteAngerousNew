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
    
    private String blueLabel, redLabel;
    
    private Image img;
    
    private final String IMGPATH = "Images/Story/";
    
    public Story(){
        switch (rng()) {
            //Starnded ship
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
                Image img1 = new Image(IMGPATH + "stranded.png");
                setImg(img1);

                break;
                    
            //Pirate chase.
            case 2: 
                setStory("A pirate is chasing you and starts firing at you.");

                setOption1("Accelerate");

                setOption2("Dodge");

                setConclusion1("You escaped the pirate.");

                setConclusion2("You took few hits, but you managed to escape.");

                Image img2 = new Image(IMGPATH + "pirateAttack.png");

                setImg(img2);

                break;
            
            //Pirate fleet.    
            case 3:
                setStory("You run into small pirate fleet and they demand you to give them 50cr.");
                
                setOption1("Give 50cr");
                
                setOption2("Try to escape");
                
                Image img3 = new Image(IMGPATH + "pirateFleet.png");
                setImg(img3);
                
                break;
                
            //Conflict zone.
            case 4:
                setStory("You come across a conflict zone between the Empire and pirates. You surely get reward if you help the Empire.");
                
                setOption1("Help the Empire");
                
                setOption2("Don\t help");
                
                setConclusion2("You decide to leave.");
                
                Image img4 = new Image(IMGPATH + "conflictZone.png");
                setImg(img4);
                
                break;
            
            //Ship debris
            default: 
                setStory("You see a space debris most likely from a destroyed ship.");
            
                setOption1("Explore");

                setOption2("Don\'t explore");

                setConclusion2("You leave the scene.");

                Image img20 = new Image(IMGPATH + "shipDebris.png");

                setImg(img20);

                break;
        }
    }
    
    //Exploration rewards and label texts.
    public void reward(String rewardName, Story story){
        Ship myShip = main.getMyShip();
        switch(rewardName){
            
            //Find a stranded ship.
            case "Give them 20 fuel":
                myShip.getShipFuelCell().fuelLoss(20);
                myShip.gainCredits(50);
                story.setBlueLabel("-20 fuel & +50cr");
                break;
                
            //Pirate attacks you.
            case "Accelerate":
                if(myShip.getShipFuelCell().getFuel() >= 10){
                    myShip.getShipFuelCell().fuelLoss(10);
                    story.setRedLabel("-10 fuel");
                    break;
                }
                else{
                    myShip.getShipHull().setHull(0);
                    story.setConclusion1("You didn\'t have enough fuel to get away and the pirate catches you and destroys your ship.");
                    story.setRedLabel("Ship Destroyed");
                    break;
                }
                
            case "Dodge":
                myShip.getShipHull().hullLoss(20);
                story.setRedLabel("Warning! Hull damage");
                break;
            
            //Conflict zone
            case "Help the Empire":
                switch (subrng()) {
                    case 1:
                        story.setConclusion1("You help the Empire and managed to bring few pirate ships down without problems.");
                        myShip.gainCredits(150);
                        Image conflictImg = new Image(IMGPATH + "conflictSuccess.png");
                        story.setImg(conflictImg);
                        story.setBlueLabel("+150cr");
                        break;
                        
                    case 2:
                        story.setConclusion1("You help the Empire and managed to bring few pirate ships down, although you took few hits");
                        myShip.getShipHull().hullLoss(25);
                        myShip.gainCredits(100);
                        Image conflict2Img = new Image(IMGPATH + "conflictOk.png");
                        story.setImg(conflict2Img);
                        story.setBlueLabel("+100cr");
                        story.setRedLabel("Warning! Hull damage");
                        break;
                        
                    case 3:
                        story.setConclusion1("You were mostly a moving practice target to the pirates and you took few really bad hits.");
                        myShip.getShipHull().hullLoss(50);
                        myShip.gainCredits(75);
                        Image conflict3Img = new Image(IMGPATH + "conflictFail.png");
                        story.setImg(conflict3Img);
                        story.setBlueLabel("+75cr");
                        story.setRedLabel("Warning! Hull damage");
                        break;
                }
                
                
            //pirate fleet escape needs to be under this case.
            case "Give 50cr":
                myShip.loseCredits(50);
                story.setConclusion1("You gave them 50cr and they leave you alone.");
                story.setRedLabel("-50cr");
                break;
                
            //pirate fleet escape. case give 50cr needs to be above this.
            case "Try to escape":
                switch (subrng()) {
                    case 1: //Took damage on attack.
                        story.setConclusion2("You managed to escape, but took some heave damage.");
                        myShip.getShipHull().hullLoss(30);
                        Image pirateImg = new Image(IMGPATH + "pirateAttack.png");
                        story.setImg(pirateImg);
                        story.setRedLabel("Warning! Hull damage");
                        break;
                    
                    case 2: //Lost some fuel and hull.
                        story.setConclusion2("You managed to escape and dodge most of the attacks, but you lost some fuel on the process.");
                        myShip.getShipHull().hullLoss(15);
                        Image pirate2Img = new Image(IMGPATH + "narrowEscape.png");
                        story.setImg(pirate2Img);
                        story.setRedLabel("Warning! Hull damage");
                        break;
                        
                    case 3: //Only fuel lost.
                        story.setConclusion2("You managed to escape without beeing hit, but you lost some fuel on the process.");
                        myShip.getShipFuelCell().fuelLoss(15);
                        Image pirate3Img = new Image(IMGPATH + "pirateEscape.png");
                        story.setImg(pirate3Img);
                        story.setRedLabel("-15 fuel");
                        break;
                }
                
            //Ship debris exploration.
            case "Explore":
                switch (subrng()) {
                    
                    case 1: //Found a fuelcell in the debris.
                    story.setConclusion1("You found a fuelcell with some fuel left in it.");
                    myShip.getShipFuelCell().fuelGain(50);
                    story.setBlueLabel("+50 fuel");
                    break;
                    
                    case 2: //A pirate attacks you.
                    story.setConclusion1("A pirate ambushes you, but you managed to escape.");
                    Image pirateImg = new Image(IMGPATH + "pirateAttack.png");
                    story.setImg(pirateImg);
                    myShip.getShipHull().hullLoss(20);
                    story.setRedLabel("Warning! Hull damage");
                    break;
                    
                    case 3: //Found some credits in the debris.
                    story.setConclusion1("You found some credits in the debris.");
                    myShip.gainCredits(20);
                    story.setBlueLabel("+20cr");
                    break;
                }

            case "Don\'t explore":
                break;
                
            case "Don\'t help":
                break;
        }
    }
    
    //rng for adventure creation
    private int rng() {
        return ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }
    
    //sub rng for other stuff
    private int subrng() {
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

    public void setBlueLabel(String blueLabel) {
        this.blueLabel = blueLabel;
    }

    public void setRedLabel(String redLabel) {
        this.redLabel = redLabel;
    }

    public String getBlueLabel() {
        return blueLabel;
    }

    public String getRedLabel() {
        return redLabel;
    }
}

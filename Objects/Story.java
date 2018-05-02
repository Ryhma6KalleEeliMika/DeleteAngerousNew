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
    
    private String storyType, story, conclusion1, conclusion2, option1, option2, blueLabel, redLabel;
    
    private Image img;
    
    private static String beaconReward, beaconFail;

    private static Image beaconImg;
    
    private static Image interdictImg;
    
    private final String IMGPATH = "Images/Story/";
    
    public Story(){
        switch (rng()) {
            //Stranded ship
            case 1:
                setStoryType("Stranded ship");
                
                //Premise of the event.
                setStory("You see a stranded ship orbiting the planet. The ship hails you and asks you for a fuel.");
            
                //First option button text.
                setOption1("Give them 20 fuel");
                
                //Second option button text.
                setOption2("Don\'t give fuel");
                
                //Conclusion of the second option.
                setConclusion2("You left them on their own.");
                
                //Image of the event
                Image img1 = new Image(IMGPATH + "stranded.png");
                setImg(img1);

                break;
                    
            //Pirate chase.
            case 2:
                setStoryType("Pirate Chase");
                
                setStory("A pirate is chasing you and starts firing at you.");

                setOption1("Accelerate");

                setOption2("Fight");

                Image img2 = new Image(IMGPATH + "pirateAttack.png");

                setImg(img2);

                break;
            
            //Pirate fleet.    
            case 3:
                setStoryType("Pirate Fleet");
                
                setStory("You run into a large pirate fleet and they demand you to give them 50cr.");
                
                setOption1("Give 50cr");
                
                setOption2("Try to escape");
                
                Image img3 = new Image(IMGPATH + "pirateFleet.png");
                setImg(img3);
                
                break;
                
            //Conflict zone.
            case 4:
                setStoryType("Conflict Zone");
                
                setStory("You come across a conflict zone between the Empire and pirates. You surely get reward if you help the Empire.");
                
                setOption1("Help the Empire");
                
                setOption2("Don\'t help");
 
                Image img4 = new Image(IMGPATH + "conflictZone.png");
                setImg(img4);
                
                break;
            
            //Ship debris
            default: 
                setStoryType("Space Debris");
                
                setStory("You see some space debris most likely from a destroyed ship.");
            
                setOption1("Explore");

                setOption2("Don\'t explore");
                
                Image imgDebris = new Image(IMGPATH + "shipDebris.png");

                setImg(imgDebris);

                break;
        }
    }
    
    //Exploration rewards and label texts..................................................................................
    public void explorationConclusion(String action, Story story){
        Ship myShip = main.getMyShip();
        switch(action){
            
            //Find a stranded ship.
            case "Give them 20 fuel":
                myShip.getShipFuelCell().fuelLoss(20.0);
                myShip.gainCredits(50);
                story.setBlueLabel("+50cr");
                story.setRedLabel("-20 fuel");
                story.setConclusion1("You gave them 20 fuel and they paid you 50cr.");
                break;
                
            //Pirate attacks you.
            case "Accelerate":
                myShip.getShipFuelCell().fuelLoss(10.0);
                story.setRedLabel("-10 fuel");
                story.setConclusion1("You escaped the pirate.");
                Image pirChase = new Image(IMGPATH + "pirateEscape.png");
                story.setImg(pirChase);
                break;

                
            case "Fight":
                if (weaponRng()) {
                    story.setConclusion2("You were able to destroy the pirate, and gained few credits.");
                    myShip.gainCredits(50);
                    story.setBlueLabel("+50cr");
                    Image pirChase2 = new Image(IMGPATH + "explosion.png");
                    story.setImg(pirChase2);
                    break;
                }
                else {
                    story.setConclusion2("You took some damage and had to escape.");
                    myShip.getShipHull().hullLoss(20.0);
                    story.setRedLabel("Warning! Hull damage");
                    Image pirChase2 = new Image(IMGPATH + "narrowEscape.png");
                    story.setImg(pirChase2);
                    break;
                }
                
            //Conflict zone...............................................................................................................
            case "Help the Empire":
                if (weaponRng()) {
                    story.setConclusion1("You helped the Empire and managed to bring many pirate ships down without any problems.");
                    myShip.gainCredits(200);
                    Image conflictImg = new Image(IMGPATH + "conflictSuccess.png");
                    story.setImg(conflictImg);
                    story.setBlueLabel("+200cr");
                    break;
                }
                else {  //If combat fails, still 1/3 chance to win.
                    switch (subRng()) {        
                        case 1:
                            story.setConclusion1("You helped the Empire and were barely able to bring few pirate ships down, although you took some damage.");
                            myShip.getShipHull().hullLoss(25.0);
                            myShip.gainCredits(40);
                            Image conflict2Img = new Image(IMGPATH + "conflictOk.png");
                            story.setImg(conflict2Img);
                            story.setBlueLabel("+40cr");
                            story.setRedLabel("Warning! Hull damage");
                            break;

                        default:
                            story.setConclusion1("You were mostly a moving target practice to the pirates and you took critical damage.");
                            myShip.getShipHull().hullLoss(50.0);
                            Image conflict3Img = new Image(IMGPATH + "conflictFail.png");
                            story.setImg(conflict3Img);
                            story.setRedLabel("Warning! Hull damage");
                            break;
                    }
                    break;
                }
                
            //pirate fleet escape needs to be under this case..............................................................
            case "Give 50cr":
                myShip.loseCredits(50);
                story.setConclusion1("You gave them 50cr and they left you alone.");
                story.setRedLabel("-50cr");
                break;
                
            //pirate fleet escape. case give 50cr needs to be above this.........................................................
            case "Try to escape":
                switch (subRng()) {
                    case 1: //Took heavy damage.
                        story.setConclusion2("You managed to escape, but took some heave damage.");
                        myShip.getShipHull().hullLoss(30.0);
                        Image pirateImg = new Image(IMGPATH + "pirateAttack.png");
                        story.setImg(pirateImg);
                        story.setRedLabel("Warning! Hull damage");
                        break;
                    
                    case 2: //Took some damage.
                        story.setConclusion2("You managed to escape and dodged most of the attacks.");
                        myShip.getShipHull().hullLoss(10.0);
                        Image pirate2Img = new Image(IMGPATH + "narrowEscape.png");
                        story.setImg(pirate2Img);
                        story.setRedLabel("Warning! Hull damage");
                        break;
                        
                    case 3: //No loss
                        story.setConclusion2("You managed to escape without being hit.");
                        Image pirate3Img = new Image(IMGPATH + "pirateEscape.png");
                        story.setImg(pirate3Img);
                        break;
                }
                break;
                
            //Ship debris exploration....................................................................................
            case "Explore":
                switch (subRng()) {
                    
                    case 1: //Found a fuelcell in the debris.
                    story.setConclusion1("You found a fuelcell with some fuel left in it.");
                    myShip.getShipFuelCell().fuelGain(50.0);
                    story.setBlueLabel("+50 fuel");
                    break;
                    
                    case 2: //A pirate attacks you.
                    story.setConclusion1("A pirate ambushes you. You took a few hits, but managed to escape.");
                    Image pirateImg = new Image(IMGPATH + "pirateAttack.png");
                    story.setImg(pirateImg);
                    myShip.getShipHull().hullLoss(20.0);
                    story.setRedLabel("Warning! Hull damage");
                    break;
                    
                    case 3: //Found some credits in the debris.
                    story.setConclusion1("You found some credits in the debris.");
                    myShip.gainCredits(20);
                    story.setBlueLabel("+20cr");
                    break;
                }
                break;

            case "Don\'t explore":
                story.setConclusion2("You left the scene.");
                break;
                
            case "Don\'t help":
                story.setConclusion2("You decided to leave.");
                break;
        }
    }
    
    public static String interDictionEncounter(String option) {
        setBeaconFail("");
        setBeaconReward("");
        switch(option) {
            
            case "Fight":
                return interdictFight();
                
            case "Escape":
                return interdictEscape();
            
        }
        return "";
    }
    
    //Distress Beacon encounter
    public static String beaconEncounter() {
        setBeaconFail("");
        setBeaconReward("");
        switch(ThreadLocalRandom.current().nextInt(1, 3 + 1)) {
            case 1:
                main.myShip.getShipHull().setHull(0);
                setBeaconFail("Critical damage!");
                Image img = new Image("Images/Story/pirateAttack.png");
                setBeaconImg(img);
                return "A pirate ship picked up on your signal before anyone else";
                
            default:
                main.myShip.getShipFuelCell().fuelGain(20);
                setBeaconReward("+20 fuel");
                Image img2 = new Image("Images/Story/stranded.png");
                setBeaconImg(img2);
                return "A fuel rat arrives and brings you some fuel";
        }
    }
    
    //Interdiction fight
    public static String interdictFight() {
        if (weaponIntRng()) {
          main.myShip.gainCredits(50);
          setBeaconReward("+50cr");
          Image img3 = new Image("Images/Story/explosion.png");
          setInterdictImg(img3);
          return "You were able to destroy your target without any problems.";
            
        }
        else {
            main.myShip.getShipHull().hullLoss(40);
            setBeaconFail("Hull damage!");
            Image img = new Image("Images/Story/narrowEscape.png");
            setInterdictImg(img);
            return "The fight didn\'t go so well and you took some heavy damage.";
        }
    }
    
    //Interdiction escape
    public static String interdictEscape() {
        switch (intSubRng()) {
            case 1:
                main.myShip.getShipHull().hullLoss(40);
                main.myShip.getShipFuelCell().fuelLoss(5);
                setBeaconFail("-5 fuel & Hull damage!");
                Image img = new Image("Images/Story/narrowEscape.png");
                setInterdictImg(img);
                return "You were able to escape, but took some heavy damage.";
            
            default: 
                main.myShip.getShipFuelCell().fuelLoss(5);
                setBeaconFail("-5 fuel");
                Image img2 = new Image("Images/Story/pirateEscape.png");
                setInterdictImg(img2);
                return "You were able to escape your pursuer.";
        }
    }
    
    
    //rng for adventure creation
    private int rng() {
        return ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }
    
    //sub rng for other stuff
    private int subRng() {
        return ThreadLocalRandom.current().nextInt(1, 3 + 1);
    }
    
    //sub rng for interdiction stuff
    private static int intSubRng() {
        return ThreadLocalRandom.current().nextInt(1, 3 + 1);
    }

    //Weapon rng for exploration combat
    private boolean weaponRng() {
        if(main.myShip.getShipWeapon().getWeaponDmg() == 0) {
            return false;
        }                                       //D6 dice roll 1 - 100, if roll =< weaponDmg success
        else if (ThreadLocalRandom.current().nextInt(1, 100 + 1) <= main.myShip.getShipWeapon().getWeaponDmg()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    //Weapon rng for interdiction combat
    private static boolean weaponIntRng() {
        if(main.myShip.getShipWeapon().getWeaponDmg() == 0) {
            return false;
        }                                       //D6 dice roll 1 - 100, if roll =< weaponDmg success
        else if (ThreadLocalRandom.current().nextInt(1, 100 + 1) <= main.myShip.getShipWeapon().getWeaponDmg()) {
            return true;
        }
        else {
            return false;
        }
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

    public static void setBeaconReward(String beaconReward) {
        Story.beaconReward = beaconReward;
    }

    public static String getBeaconReward() {
        return beaconReward;
    }

    public static void setBeaconFail(String beaconFail) {
        Story.beaconFail = beaconFail;
    }

    public static String getBeaconFail() {
        return beaconFail;
    }

    public static void setBeaconImg(Image beaconImg) {
        Story.beaconImg = beaconImg;
    }

    public static Image getBeaconImg() {
        return beaconImg;
    }

    public static void setInterdictImg(Image interdictImg) {
        Story.interdictImg = interdictImg;
    }

    public static Image getInterdictImg() {
        return interdictImg;
    }

    public void setStoryType(String storyType) {
        this.storyType = storyType;
    }

    public String getStoryType() {
        return storyType;
    }
}

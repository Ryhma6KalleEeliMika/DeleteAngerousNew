/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Kalle
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML   //Center screen image.
    private ImageView mainImage;
    
    @FXML   //BLue "jump successful" label, fuel ammount, ship name.
    private Label jumpLabel, fuelLabel, shipNameLabel;
    
    @FXML   //Current star, current planet, galaxy map button 
    private Button currentStarLabel, currentPlanetLabel, gMBapButton;
    
    @FXML   //Star buttons
    private Button n1, n2, n3, n4;

    @FXML   //Planet buttons
    private Button p1, p2, p3, p4;

    @FXML   //Fuel meter/ammount
    private void setFuelAmmount() {
        Ship myShip = main.getMyShip();
        fuelLabel.setText(Integer.toString(myShip.getFuel()));
        if (myShip.getFuel() < 21){
            fuelLabel.setTextFill(Color.web("red"));
        }
    }
    
    @FXML //Setting the starButtons to display the neighbouring stars and other gui things default after star jump. GUI refresh basically.
    private void setStarButtonNames() {
        Ship myShip = main.getMyShip();
        Star currentStar = myShip.getStar();
        setFuelAmmount();
        mainImage.setImage(main.myShip.getStar().getStarImage());
        shipNameLabel.setText(myShip.getNAME());
        currentStarLabel.setText(currentStar.getName());
        n1.setText(currentStar.getN1());
        n2.setText(currentStar.getN2());
        n3.setText(currentStar.getN3());
        n4.setText(currentStar.getN4());
        currentPlanetLabel.setText(myShip.getPlanetName());
        p1.setText(currentStar.getPlanet1().getName());
        p2.setText(currentStar.getPlanet2().getName());
        p3.setText(currentStar.getPlanet3().getName());
        p4.setText(currentStar.getPlanet4().getName());
        
        //Sets planet button colors orange/blue and changes the image to correct orbiting planet.
        if (myShip.getPlanet() == currentStar.getPlanet1()) {
            p1.setStyle("-fx-background-color:DeepSkyBlue");
            mainImage.setImage(main.myShip.getStar().getStarImage1());
        }
        else {
            p1.setStyle("-fx-background-color:DarkOrange");
        }
        if (myShip.getPlanet() == currentStar.getPlanet2()) {
            p2.setStyle("-fx-background-color:DeepSkyBlue");
            mainImage.setImage(main.myShip.getStar().getStarImage2());
        }
        else {
            p2.setStyle("-fx-background-color:DarkOrange");
        }
        if (myShip.getPlanet() == currentStar.getPlanet3()) {
            p3.setStyle("-fx-background-color:DeepSkyBlue");
            mainImage.setImage(main.myShip.getStar().getStarImage3());
        }
        else {
            p3.setStyle("-fx-background-color:DarkOrange");
        }
        if (myShip.getPlanet() == currentStar.getPlanet4()) {
            p4.setStyle("-fx-background-color:DeepSkyBlue");
            mainImage.setImage(main.myShip.getStar().getStarImage4());
        }
        else {
            p4.setStyle("-fx-background-color:DarkOrange");
        }
    }
    
    //Label that appears after jump attempt. "Jump succesful or something else."
    private void setJumpLabel(String jumpResult){
        jumpLabel.setText(jumpResult);
        
        //Code for the text to fade.
        FadeTransition fader = createFader(jumpLabel);
        SequentialTransition blinkThenFade = new SequentialTransition(fader);
        blinkThenFade.play();
        createFader(jumpLabel);
    }
    
    //More code to fade the text.
    private FadeTransition createFader(Node node) {
        FadeTransition fade = new FadeTransition(Duration.seconds(4), node);
        fade.setFromValue(1);
        fade.setToValue(0);
        return fade;
    }
    
    //Switches to the galaxy map view.
    @FXML
    private void gMapButton(ActionEvent event) throws IOException {
        Parent gMap = FXMLLoader.load(getClass().getResource("GalaxyMap.fxml"));
        Scene gMapScene = new Scene(gMap);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(gMapScene);
        window.show();
    }
    
    //N1 - N4 buttons for jumping neighbouring star systems.
    @FXML
    private void n1Button(ActionEvent event) {
        Ship myShip = main.getMyShip(); //Get my ship from the main
        try {
            Star starToTravel = myShip.getStar().getStar1(); //Get the target star
            String jumpResult = starTravel(myShip, starToTravel); //Returns a string wether the jump was success or not.
            setJumpLabel(jumpResult); //Sets the jump label after trip E.G. "Jump successful"
        } catch (Exception e) {
            setJumpLabel("Error! Invalid selection.");
        }
    }
    
    @FXML
    private void n2Button(ActionEvent event) {
        Ship myShip = main.getMyShip();
        try {
            Star starToTravel = myShip.getStar().getStar2();
            String jumpResult = starTravel(myShip, starToTravel);
            setJumpLabel(jumpResult);
        } catch (Exception e) {
            setJumpLabel("Error! Invalid selection.");
        }
    }
    
    @FXML
    private void n3Button(ActionEvent event) {
        Ship myShip = main.getMyShip();
        try {
            Star starToTravel = myShip.getStar().getStar3();
            String jumpResult = starTravel(myShip, starToTravel);
            setJumpLabel(jumpResult);
        } catch (Exception e) {
            setJumpLabel("Error! Invalid selection.");
        }
    }
    
    @FXML
    private void n4Button(ActionEvent event) {
        Ship myShip = main.getMyShip();
        try {
            Star starToTravel = myShip.getStar().getStar4();
            String jumpResult = starTravel(myShip, starToTravel);
            setJumpLabel(jumpResult);
        } catch (Exception e) {
            setJumpLabel("Error! Invalid selection.");
        }
    }
    
    //Method for traveling to between stars.  Warns the player if fuel is low or 0.
    private String starTravel(Ship myShip, Star starTo){
        if (starTo == null) {   //If star doesn't exist
            return "Error! Invalid selection.";
        }
        else if (myShip.getFuel() > 9) { //If fuel is above 10
            myShip.setStar(starTo); //Ship's star is set to the new star.
            myShip.fuelLoss(10);    //Ship loses 10 fuel after the jump
            myShip.setPlanet(null); //Ship is not orbiting any planet after jump.
            myShip.setPlanetName("");
            mainImage.setImage(starTo.getStarImage()); //Main image changes to the new star system.
            setStarButtonNames();   //Gui refresh
            if (myShip.getFuel() == 0) {    //If fuel is zero after the jump.
                return "Jump succesful Critical warning!\nFuel cells depleted!";
            }
            else if (myShip.getFuel() < 21) {   //If fuel is low after the jump.
                 return "Jump succesful Warning!\nFuel cells close to depletion.";
            }
            else {  //Normal procedures
                return "Jump succesful";
            }
        }
        else {  //If not enough fuel for the jump.
            return "Not enough fuel for jump!";
        }
    }
    
    //Planet buttons P1 - P4.
    @FXML
    private void p1Button(ActionEvent event) {
        try {
            Ship myShip = main.getMyShip(); //Get my ship from the main
            Planet destinationPlanet = myShip.getStar().getPlanet1(); //Get the destination planet.
            String planetName = destinationPlanet.getName(); //Destination planet's name.
            String travelResult = planetTravel(myShip, planetName, destinationPlanet); //Returns the resulting string if the travel was possible or not.
            setJumpLabel(travelResult); //Sets the jump label after trip E.G. "Orbiting Terra"
        }
        catch (Exception e) {
            setJumpLabel("Error! Invalid selection!");
        }
    }
    
    @FXML
    private void p2Button(ActionEvent event) {
        try {
            Ship myShip = main.getMyShip();
            Planet destinationPlanet = myShip.getStar().getPlanet2();
            String planetName = destinationPlanet.getName();
            String travelResult = planetTravel(myShip, planetName, destinationPlanet);
            setJumpLabel(travelResult);
        }
        catch (Exception e) {
            setJumpLabel("Error! Invalid selection!");
        }
    }
    
    @FXML
    private void p3Button(ActionEvent event) {
        try {
            Ship myShip = main.getMyShip();
            Planet destinationPlanet = myShip.getStar().getPlanet3();
            String planetName = destinationPlanet.getName();
            String travelResult = planetTravel(myShip, planetName, destinationPlanet);
            setJumpLabel(travelResult);
        }
        catch (Exception e) {
            setJumpLabel("Error! Invalid selection!");
        }
    }
    
    @FXML
    private void p4Button(ActionEvent event) {
        try {
            Ship myShip = main.getMyShip();
            Planet destinationPlanet = myShip.getStar().getPlanet4();
            String planetName = destinationPlanet.getName();
            String travelResult = planetTravel(myShip, planetName, destinationPlanet);
            setJumpLabel(travelResult);
        }
        catch (Exception e) {
            setJumpLabel("Error! Invalid selection!");
        }
    }
    
    //Method for traveling between planet. Warns the player if fuel is low or 0.
    private String planetTravel(Ship myShip, String planetName, Planet destinationPlanet) {
        if(myShip.getPlanetName().equals(planetName)){  //Checks if the ship is already orbiting that planet
            return "Error! Invalid selection!\nAlready orbiting " + planetName;   
        }
        else if (myShip.getFuel() > 0 && destinationPlanet != null) { //Checks if there is enough fuel and the target exists
            if (planetName != null) { //If planet exists.
                myShip.fuelLoss(1); //Fuel depletes by one.
                currentPlanetLabel.setText(planetName); //Sets the "Current planet" label as the name of the planet the ship is currently at.
                myShip.setPlanet(destinationPlanet); //Sets ships current planet as the new planet.
                myShip.setPlanetName(planetName); //Sets ships current planet name as the new planet.
                mainImage.setImage(destinationPlanet.getPlanetImage()); //Changes the main image to orbit that planet.
                setStarButtonNames();
                if (myShip.getFuel() == 0) { //If fuel is at zero after the travel
                    return "Orbiting " + planetName +" Critical warning!\nFuel cells depleted!";
                }
                else if (myShip.getFuel() < 21) { //If fuel is low after the travel
                     return "Orbiting " + planetName +" Warning!\nFuel cells close to depletion.";
                }
                else { //Normal procedures
                    return "Orbiting " + planetName;
                }
            }return "Invalid selection";    //If null button was pressed.
        }
        else { //If no enough fuel.
            return "Travel failed. Not enough fuel!";
        }
    }
    
    //Code that runs first when the GUI starts. Updates the ships name label and the N1-N4 button labels to view neihgbouring stars.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setStarButtonNames();  //GUI refresh
        setJumpLabel("");   //Empty jump label "Jump successful"


    }
}

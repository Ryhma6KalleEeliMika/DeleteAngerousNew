package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Kalle
 */
public class PlanetPopUpController implements Initializable {
    
    @FXML    
    private Button exitButton, actionButton;
    
    @FXML
    private Label planetNameLabel, planetTypeLabel, planetPopLabel, actionLabel;
    
    @FXML
    private ImageView planetImage;
    
    @FXML
    private void exitButtonAction(){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void actionButtonAction() {
        
        int planetResources = main.getMyShip().getPlanet().getResources();
        
        if (planetResources > 0) {
            main.myShip.setCredits(main.myShip.getCredits() + planetResources);
            main.getMyShip().getPlanet().setResources(0);
            setActionLabel(planetResources + " credits mined.");
        }
    }
    
    
    //Label that appears after action.
    private void setActionLabel(String action){
        actionLabel.setText(action);
        
        //Code for the text to fade.
        FadeTransition fader = createFader(actionLabel);
        SequentialTransition blinkThenFade = new SequentialTransition(fader);
        blinkThenFade.play();
        createFader(actionLabel);
    }
    
    //More code to fade the text.
    private FadeTransition createFader(Node node) {
        FadeTransition fade = new FadeTransition(Duration.seconds(6), node);
        fade.setFromValue(1);
        fade.setToValue(0);
        return fade;
    }
    
    /*
    * Initializes the controller class.
    */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        planetNameLabel.setText(main.myShip.getPlanetName()); //Sets the planets to the screen.
        planetTypeLabel.setText(main.myShip.getPlanet().getType());
        planetPopLabel.setText(main.myShip.getPlanet().getPopulation());
        planetImage.setImage(main.myShip.getPlanet().getPlanetSurface().getSurfaceImage());
        actionLabel.setText("");
        
        switch(main.myShip.getPlanet().getType()) {
            case "rock":
                actionButton.setText("Mine");
                break;
        }
    }
}

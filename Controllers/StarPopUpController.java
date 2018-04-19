package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Kalle
 */
public class StarPopUpController implements Initializable {
    @FXML    
    private Button fuelScoopButton, exitButton;
    
    @FXML
    private Label starNameLabel, actionLabel, warningLabel;
    
    @FXML
    private ImageView starImage;
    
    @FXML
    private void exitButtonAction(){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void fuelScoopButtonAction() {
        if(main.myShip.getStar().getScoopTimes() == 2){
            main.myShip.getShipFuelCell().fuelGain(25);
            main.myShip.getStar().setScoopTimes(1);
            setActionLabel(25 + " fuel scooped.", false);
        }
        else if(main.myShip.getStar().getScoopTimes() == 1){
            main.myShip.getShipFuelCell().fuelGain(25);
            main.myShip.getShipHull().hullLoss(20);
            main.myShip.getStar().setScoopTimes(0);
            fuelScoopButton.setDisable(true);
            main.myShip.getStar().setScoop(false);
            setActionLabel(25 + " fuel scooped", true);
        }
    }
    
    //Label that appears after action.
    private void setActionLabel(String action, boolean warning){
        actionLabel.setText(action);
        
        if (warning) {
            warningLabel.setText("Warning! Heat damage.");
            
            //Code for the text to fade.
            FadeTransition fader = createFader(warningLabel);
            SequentialTransition blinkThenFade = new SequentialTransition(fader);
            blinkThenFade.play();
            createFader(warningLabel);
        }
        
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        starNameLabel.setText(main.myShip.currentStarName());
        starImage.setImage(main.myShip.getStar().getStarsSurface().getSurfaceImage());
        actionLabel.setText("");
        warningLabel.setText("");
        if (!main.myShip.getStar().getScoop()){
            fuelScoopButton.setDisable(true);
        }
    }
}

package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.main;
import Objects.*;
import Sound.SoundEffects;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Kalle
 */
public class BeaconPopUpController implements Initializable {
    
    @FXML    
    private Button option1Button, option2Button, exitButton;
    
    @FXML
    private Label eventOutcomeLabel, gainLabel, lossLabel;
    
    @FXML
    private ImageView eventImage;
    
    @FXML   //Exit button after exploration event has concluded.
    private void exitButtonAction() throws IOException {
        SoundEffects.Sound("Button.wav");
        gameOver();
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML   //Choice 1 in the exploration event.
    private void option1ButtonAction() {
        eventOutcomeLabel.setText(Story.beaconEncounter());
        gainLabel.setText(Story.getBeaconReward());
        lossLabel.setText(Story.getBeaconFail());
        eventImage.setImage(Story.getBeaconImg());
        eventEnd();
    }
    
    @FXML   //Choice 2 in the exploration event.
    private void option2ButtonAction() {
        eventOutcomeLabel.setText("You didn\'t want to attract any unwanted attention");
        eventEnd();
    }
    
    private void eventEnd() {
        exitButton.setVisible(true);
        option1Button.setDisable(true);
        option2Button.setDisable(true);  
    }
    
    //Opens game over pop up.
    private void gameOver() throws IOException {
        if (main.myShip.getShipHull().getHull() <= 0){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Controllers/GameOver.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT); //Removes the x-button and top bar.
            stage.initModality(Modality.APPLICATION_MODAL); //Makes the window so that it has to be closed before going back to the main view.
            stage.setScene(new Scene(root1));
            stage.show();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gainLabel.setText("");
        lossLabel.setText("");
        eventOutcomeLabel.setText("");
        exitButton.setVisible(false);
        option1Button.setDisable(false);
        option2Button.setDisable(false);  
        Image img = new Image("Images/Story/beacon.png");
        eventImage.setImage(img);
    }
}

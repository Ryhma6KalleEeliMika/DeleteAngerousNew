package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.main;
import Objects.Story;
import Sound.SoundEffects;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Mika Vuorinen
 */
public class GameOverController implements Initializable {
    
    @FXML   
    private Button tryAgainButton, quitButton;
    
    @FXML
    private Label gameOverLabel, reasonLabel, jumpsMadeNumber, totalCreditsNumber, planetStarNumber, hullLostNumber, fuelUsedNumber, fuelBuyedNumber, attackNumber, hullGainedNumber;
    
    @FXML //Close program
    private void quitButtonAction(ActionEvent event) throws IOException {
        SoundEffects.Sound("Button.wav");
        System.exit(0);
    }
    
    private void gameInformation(){
        jumpsMadeNumber.setText(Integer.toString(main.myShip.getAllJumps()));
        totalCreditsNumber.setText(Integer.toString(main.myShip.getAllCredits()));
        fuelUsedNumber.setText(Double.toString(main.myShip.getShipFuelCell().getFuelUsed()));
        planetStarNumber.setText(Integer.toString(main.myShip.getStarsScanned()) + "/" + Integer.toString(main.myShip.getPlanetsScanned()));
        hullLostNumber.setText(Double.toString(main.myShip.getShipHull().getHullLost()));
        hullGainedNumber.setText(Double.toString(main.myShip.getShipHull().getHullGained()));
        fuelBuyedNumber.setText(Double.toString(main.myShip.getShipFuelCell().getFuelGained()));
        attackNumber.setText(Integer.toString(Story.getTimesAttacked()));
    }
    
    @Override   //Mouse hover action.
    public void initialize(URL url, ResourceBundle rb) {
        if (main.myShip.getShipHull().getHull() <= 0) {
            SoundEffects.Sound("PlayerExplosion.wav");
            gameOverLabel.setText("Game Over");
            reasonLabel.setText("Your ship was destroyed");
            gameInformation();
        }
        else {
            gameOverLabel.setText("Exploration victory");
            SoundEffects.Sound("Victory.wav");
            reasonLabel.setText("You have scoured the entire galaxy and there is nothing left to do than retire");
            reasonLabel.setTextFill(Color.web("DeepSkyBlue"));
            gameInformation();
        }
    }
}

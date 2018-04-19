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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kalle
 */
public class StarPopUpController implements Initializable {
    @FXML    
    private Button fuelScoopButton, exitButton;
    
    @FXML
    private Label starNameLabel;
    
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
        }
        else if(main.myShip.getStar().getScoopTimes() == 1){
            main.myShip.getShipFuelCell().fuelGain(25);
            main.myShip.getShipHull().hullLoss(20);
            main.myShip.getStar().setScoopTimes(0);
            fuelScoopButton.setDisable(true);
            main.myShip.getStar().setScoop(false);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        starNameLabel.setText(main.myShip.currentStarName());
        starImage.setImage(main.myShip.getStar().getStarsSurface().getSurfaceImage());
        if (!main.myShip.getStar().getScoop()){
            fuelScoopButton.setDisable(true);
        }
    }
}

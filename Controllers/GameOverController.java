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
    private Label gameOverLabel, reasonLabel;
    
    @FXML //Close program
    private void quitButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
    @Override   //Mouse hover action.
    public void initialize(URL url, ResourceBundle rb) {
        if (main.myShip.getShipHull().getHull() <= 0) {
            gameOverLabel.setText("Game Over");
            reasonLabel.setText("Your ship was destroyed");
        }
        else {
            gameOverLabel.setText("Exploration victory");
            reasonLabel.setText("You have scoured the entire galaxy and there is nothing left to do than retire");
            reasonLabel.setTextFill(Color.web("DeepSkyBlue"));
        }
    }
}

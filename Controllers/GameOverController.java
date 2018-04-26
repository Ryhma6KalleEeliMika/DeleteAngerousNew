package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.main;
import static Main.main.myShip;
import Objects.Ship;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Mika Vuorinen
 */
public class GameOverController implements Initializable {
    
    @FXML   
    private Button tryAgainButton, quitButton;
    
    @FXML //Close program
    private void quitButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
    @Override   //Mouse hover action.
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}

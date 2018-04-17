/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.MouseEvent;
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
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Mika Vuorinen
 */
public class FXMLShipPopUpController implements Initializable {

    
    @FXML   //Ship choose buttons.
    private Button eaglemk2Button, haulerButton, adderButton;
    
    @FXML   //Ship name and information labels.
    private Label startFuelLabel, startHullLabel, startGargoLabel, shipNameLabel;
    
    @FXML   //Ship images.
    private ImageView shipImage;
    
    @FXML   //Mouse hower actions.
    private MouseEvent eagleEntered, haulerEntered, adderEntered;
    
    @FXML //Button that takes you back to the main view.
    private void eagleHower(MouseEvent event) throws IOException {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}

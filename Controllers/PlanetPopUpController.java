package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
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
public class PlanetPopUpController implements Initializable {
    
    @FXML    
    private Button exitButton, actionButton;
    
    @FXML
    private Label planetNameLabel, planetTypeLabel;
    
    @FXML
    private ImageView planetImage;
    
    @FXML
    private void exitButtonAction(){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
    /*
    * Initializes the controller class.
    */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        planetNameLabel.setText(main.myShip.getPlanetName()); //Sets the planets to the screen.
        planetTypeLabel.setText(main.myShip.getPlanet().getType());
        planetImage.setImage(main.myShip.getPlanet().getPlanetSurface().getSurfaceImage());
        
    }
}

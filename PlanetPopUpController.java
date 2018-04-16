/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kalle
 */
public class PlanetPopUpController implements Initializable {
    
    @FXML    
    private Button backButton;
    
    @FXML
    private Label planetName;
    
    @FXML
    private void backButtonAction(){
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
    
    /*
    * Initializes the controller class.
    */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        planetName.setText(main.myShip.getPlanetName()); //Sets the planets to the screen.
    }
}

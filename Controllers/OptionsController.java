/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Sound.Sound;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mika Vuorinen
 */
public class OptionsController implements Initializable {

    @FXML
    private Button optionOkButton;
    
    @FXML
    private static CheckBox muteMusicCheck, muteSoundCheck;
    
    @FXML
    private void optionOkButtonAction(ActionEvent event) throws IOException{
        Stage stage = (Stage) optionOkButton.getScene().getWindow();
        stage.close();
    }
    /*
    @FXML
    private void muteMusicCheckAction() {
        muteMusicCheck.setOnAction((event) -> {
            boolean selected = muteMusicCheck.isSelected();
            if(selected){
                
            }
            else{
                
            }
    });
    }
    
    @FXML
    private void muteSoundCheckAction() {
        muteSoundCheck.setOnAction((event) -> {
            boolean selected = muteSoundCheck.isSelected();
            if(selected){
                Sound.setVolume(0.0);
            }
            else{
                Sound.setVolume(1.0);
            }
    });
    }*/
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

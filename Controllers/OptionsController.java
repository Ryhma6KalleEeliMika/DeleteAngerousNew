/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Sound.Sound.*;
import Sound.SoundEffects;
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
    private CheckBox muteSoundCheck;
    
    @FXML
    private void optionOkButtonAction(ActionEvent event) throws IOException{
        SoundEffects.Sound("Button.wav");
        Stage stage = (Stage) optionOkButton.getScene().getWindow();
        stage.close();
    }
    
    
    @FXML //Mutes sound effects.
    private void muteSoundCheckAction(ActionEvent e) {
        if(muteSoundCheck.isSelected()){
            Main.main.muteSound = true;
            
        }
        else{
            Main.main.muteSound = false;
        }
    }
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        muteSoundCheck.setSelected(Main.main.muteSound);
    }
}

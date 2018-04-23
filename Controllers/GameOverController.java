package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.main;
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
    
    
    @FXML //Restart Game..
    private void tryAgainButtonAction(ActionEvent event) throws IOException {
        //reStartGame();
    }

    @FXML //Close program
    private void quitButtonAction(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
    
    //Game restarts
    private void reStartGame() throws IOException {
        
        //main.worldGeneration();
        
        //Closes the ship selection pop up.
        Stage popUpStage = (Stage) tryAgainButton.getScene().getWindow();
        popUpStage.close();
        
        //Switches the main menu to the main view.
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Controllers/MainMenu.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Second window");
        stage.initStyle(StageStyle.TRANSPARENT); //Removes the x-button and top bar.
        stage.initModality(Modality.APPLICATION_MODAL); //Makes the window so that it has to be closed before going back to the main view.
        stage.setScene(new Scene(root1));
        stage.show();


    }
    
    @Override   //Mouse hover action.
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class FXMLShipPopUpController implements Initializable {
    
    @FXML   //Ship choose buttons.
    private Button eaglemk2Button, haulerButton, adderButton;
    
    @FXML   //Ship name and information labels.
    private Label startFuelLabel, startHullLabel, startEngineLabel, shipNameLabel;
    
    @FXML   //Ship images.
    private ImageView shipImage;
    
    @FXML //Button when the Eagle MkII ship is selected.
    private void eaglemk2ButtonAction(ActionEvent event) throws IOException {
        main.setChosenShipName("Eagle MkII");
        startGame();
    }
    
    @FXML //Button when the Hauler ship is selected.
    private void haulerButtonAction(ActionEvent event) throws IOException {
        main.setChosenShipName("Hauler");
        startGame();
    }
    
    @FXML //Button when the Adder ship is selected.
    private void adderButtonAction(ActionEvent event) throws IOException {
        main.setChosenShipName("Adder");
        startGame();
    }
    
    @FXML   //game starts when the ship is chosen
    private void startGame() throws IOException {
        
        //Closes the mainmenu view.
        Stage popUpStage = (Stage) adderButton.getScene().getWindow();
        popUpStage.close();
        Stage mainMenu = (Stage) main.getMainMenu().getWindow();
        mainMenu.close();
        
        //Ship generation Starting star system name, star system object and the chosen ship name.
        Ship newShip = new Ship("Sol", main.getStartingStar(), main.getChosenShipName());
        main.setMyShip(newShip);
        
        //Main game view opens.
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        //stage.initStyle(StageStyle.TRANSPARENT); //Removes the x-button and top bar.
        stage.setScene(new Scene(root1));
        stage.show();
    }
    
    @Override   //Mouse hover action.
    public void initialize(URL url, ResourceBundle rb) {
        eaglemk2Button.hoverProperty().addListener(l->{ //EagleMK2 button mouse hover.
            Image image = new Image("Images/Ships/EagleMKII.png");
            shipImage.setImage(image);
            startFuelLabel.setText("100");
            startHullLabel.setText("100");
            startEngineLabel.setText("Advanced");
            shipNameLabel.setText("Eagle MkII");
            
        });
        haulerButton.hoverProperty().addListener(l->{ //Hauler button mouse hover.
            Image image = new Image("Images/Ships/Hauler.png");
            shipImage.setImage(image);
            startFuelLabel.setText("100");
            startHullLabel.setText("200");
            startEngineLabel.setText("Basic");
            shipNameLabel.setText("Hauler");
        });
        
        adderButton.hoverProperty().addListener(l->{ //Adder button mouseHover.
            Image image = new Image("Images/Ships/Adder.png");
            shipImage.setImage(image);
            startFuelLabel.setText("150");
            startHullLabel.setText("100");
            startEngineLabel.setText("Basic");
            shipNameLabel.setText("Adder");
        });
    }
}

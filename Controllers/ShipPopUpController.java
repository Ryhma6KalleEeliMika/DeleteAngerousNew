package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.main;
import static Main.main.setMainMenu;
import Objects.Ship;
import Sound.SoundEffects;
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
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Mika Vuorinen
 */
public class ShipPopUpController implements Initializable {
    
    @FXML   //Ship choose and exit buttons.
    private Button eaglemk2Button, haulerButton, adderButton, shipExitButton;
    
    @FXML   //Ship name and information labels.
    private Label shipTypeLabel, startModuleLabel, startWpnLabel, startFuelLabel, startHullLabel, startEngineLabel, shipNameLabel;
    
    @FXML   //Ship images.
    private ImageView shipImage;
    
    @FXML //Button when the Eagle MkII ship is selected.
    private void eaglemk2ButtonAction(ActionEvent event) throws IOException {
        main.setChosenShipName("Eagle MkII");
        SoundEffects.Sound("Button.wav");
        SoundEffects.Sound("EagleMkII.wav");
        startGame();
    }
    
    @FXML //Button when the Hauler ship is selected.
    private void haulerButtonAction(ActionEvent event) throws IOException {
        main.setChosenShipName("Hauler");
        SoundEffects.Sound("Button.wav");
        SoundEffects.Sound("Hauler.wav");
        startGame();
    }
    
    @FXML //Button when the Adder ship is selected.
    private void adderButtonAction(ActionEvent event) throws IOException {
        main.setChosenShipName("Adder");
        SoundEffects.Sound("Button.wav");
        SoundEffects.Sound("Adder.wav");
        startGame();
    }
    
    @FXML
    private void shipExitButtonAction(ActionEvent event) throws IOException {
        SoundEffects.Sound("Button.wav");
        Stage stage = (Stage) shipExitButton.getScene().getWindow();
        stage.close();
    }
    
    //game starts when the ship is chosen
    private void startGame() throws IOException {
        
        //Closes the ship selection pop up.
        Stage popUpStage = (Stage) adderButton.getScene().getWindow();
        popUpStage.close();
        
        //Ship generation Starting star system name, star system object and the chosen ship name.
        Ship newShip = new Ship("Sol", main.getStartingStar(), main.getChosenShipName());
        main.setMyShip(newShip);
        
        //Switches the main menu to the main view.
        Parent normalView = FXMLLoader.load(getClass().getClassLoader().getResource("Controllers/MainView.fxml"));
        Scene normalScene = new Scene(normalView);
        main.setMainView(normalScene);
    
        Stage window = (Stage)main.getMainMenu().getWindow();
        main.setMainView(normalScene);
        window.setScene(normalScene);
        window.show();
    }
    
    @Override   //Mouse hover action.
    public void initialize(URL url, ResourceBundle rb) {
     
        eaglemk2Button.hoverProperty().addListener(l->{ //EagleMK2 button mouse hover.
            Image image = new Image("Images/Ships/Eagle MkII.png");
            shipImage.setImage(image);
            shipTypeLabel.setText("Combat");
            startModuleLabel.setText("Weapon");
            startWpnLabel.setText("Pulse laser");
            startFuelLabel.setText("100");
            startHullLabel.setText("100");
            startEngineLabel.setText("Basic");
            shipNameLabel.setText("Eagle MkII");
            SoundEffects.Sound("ButtonHover.mp3");
        });
        
        haulerButton.hoverProperty().addListener(l->{ //Hauler button mouse hover.
            Image image = new Image("Images/Ships/Hauler.png");
            shipImage.setImage(image);
            shipTypeLabel.setText("Mining");
            startModuleLabel.setText("Weapon");
            startWpnLabel.setText("Mining laser");
            startFuelLabel.setText("100");
            startHullLabel.setText("200");
            startEngineLabel.setText("Basic");
            shipNameLabel.setText("Hauler");
            SoundEffects.Sound("ButtonHover.mp3");
        });
        
        adderButton.hoverProperty().addListener(l->{ //Adder button mouseHover.
            Image image = new Image("Images/Ships/Adder.png");
            shipImage.setImage(image);
            shipTypeLabel.setText("Exploration");
            startModuleLabel.setText("Module");
            startWpnLabel.setText("Fuel scoop");
            startFuelLabel.setText("150");
            startHullLabel.setText("100");
            startEngineLabel.setText("Basic");
            shipNameLabel.setText("Adder");
            SoundEffects.Sound("ButtonHover.mp3");
        });
    }
}

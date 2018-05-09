package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.main;
import Sound.SoundEffects;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Kalle
 */
public class PlanetPopUpController implements Initializable {
    
    @FXML    
    private Button exitButton, actionButton;
    
    @FXML
    private Label planetNameLabel, planetTypeLabel, planetPopLabel, actionLabel,  resGradeLabel;
    
    @FXML
    private ImageView planetImage;
    
    @FXML
    private HBox resHbox;
    
    @FXML
    private BorderPane borderPane;
    
    @FXML
    private void exitButtonAction() throws IOException{
        SoundEffects.Sound("Button.wav");
        gameOver();
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML   //Action depends on what kind of planet you are on.
    private void actionButtonAction() throws IOException {    
        
       
        
        int planetResources = main.getMyShip().getPlanet().getResources();    
        
        //In rock and lava planets you can mine.
        if (planetResources > 0 && actionButton.getText().equals("Mine")) {
            if (!main.myShip.getShipWeapon().getName().equals("Mining Laser")) {
                setActionLabel("No mining laser.");
                 SoundEffects.Sound("NoMoney.wav");
            }
            else {
                 SoundEffects.Sound("Credit.wav");
                main.myShip.gainCredits(planetResources);
                main.getMyShip().getPlanet().setResources(0);
                setActionLabel(planetResources + " credits mined.");
                main.myShip.getPlanet().setResGrade("Empty");
                resGradeLabel.setText(main.myShip.getPlanet().getResGrade());
                actionButton.setDisable(true);
            }
        }
        //In terran planets there are shops.
        else if (actionButton.getText().equals("Shop")) {
                SoundEffects.Sound("Button.wav");
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Controllers/ShopPopUp.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT); //Removes the x-button and top bar.
                stage.initModality(Modality.APPLICATION_MODAL); //Makes the window so that it has to be closed before going back to the main view.
                stage.setScene(new Scene(root));
                stage.show();
                stage.setAlwaysOnTop(true);
        }
        
        //In gas, ring, water, ice planets and black holes you can explore.
        else if (actionButton.getText().equals("Explore")) {
                SoundEffects.Sound("Button.wav");
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Controllers/ExplorePopUp.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT); //Removes the x-button and top bar.
                stage.initModality(Modality.APPLICATION_MODAL); //Makes the window so that it has to be closed before going back to the main view.
                stage.setScene(new Scene(root));
                stage.show();
                stage.setAlwaysOnTop(true);
        }
    }
    
    //GameOver
    private void gameOver() throws IOException{
        //Opens win screen if all planets and stars are scanned
        if (main.myShip.getPlanetsScanned() == main.getMAXPLANETS() && main.myShip.getStarsScanned() == main.getMAXSTARS()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Controllers/GameOver.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT); //Removes the x-button and top bar.
            stage.initModality(Modality.APPLICATION_MODAL); //Makes the window so that it has to be closed before going back to the main view.
            stage.setScene(new Scene(root1));
            stage.show();
            stage.setAlwaysOnTop(true);
        }
    }
    
    //Label that appears after action.
    private void setActionLabel(String action){
        actionLabel.setText(action);
        
        //Code for the text to fade.
        FadeTransition fader = createFader(actionLabel);
        SequentialTransition blinkThenFade = new SequentialTransition(fader);
        blinkThenFade.play();
        createFader(actionLabel);
    }
    
    //More code to fade the text.
    private FadeTransition createFader(Node node) {
        FadeTransition fade = new FadeTransition(Duration.seconds(6), node);
        fade.setFromValue(1);
        fade.setToValue(0);
        return fade;
    }
    
    /*
    * Initializes the controller class.
    */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Sets the planets info.
        planetNameLabel.setText(main.myShip.getPlanetName()); 
        planetTypeLabel.setText(main.myShip.getPlanet().getType());
        planetPopLabel.setText(main.myShip.getPlanet().getPopulation());
        planetImage.setImage(main.myShip.getPlanet().getPlanetSurface().getSurfaceImage());
        actionLabel.setText("");
        
        //Disables action button if the planet has been explored.
        borderPane.hoverProperty().addListener(l->{
            if (actionButton.getText().equals("Explore")) {
                actionButton.setDisable(main.myShip.getPlanet().getExplored());
            }
        });
        
        
        //Planet info based on the type.
        switch(main.myShip.getPlanet().getType()) {
            
            //Rock and lava planets
            case "rock": case "lava":
                actionButton.setText("Mine");
                resHbox.setVisible(true);
                resGradeLabel.setText(main.myShip.getPlanet().getResGrade());
                if (main.myShip.getPlanet().getResources() == 0) {
                    actionButton.setDisable(true);
                }
                break;

            //Terran planets.
            case "terran":
                actionButton.setText("Shop");
                resHbox.setVisible(false);
                break;
                
            //Exploration planets. gas, ring, ice, water
            default:
                actionButton.setText("Explore");
                resHbox.setVisible(false);
                actionButton.setDisable(main.myShip.getPlanet().getExplored());
                 break;
        }
    }
}

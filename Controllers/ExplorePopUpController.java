package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.main;
import Objects.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Kalle
 */
public class ExplorePopUpController implements Initializable {
    
    @FXML    
    private Button option1Button, option2Button, exitButton;
    
    @FXML
    private Label eventExplanationLabel, eventOutcomeLabel;
    
    @FXML
    private ImageView eventImage;
    
    @FXML
    private void exitButtonAction(){
        main.myShip.getPlanet().setExplored(true);
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void option1ButtonAction() {
        Story story = main.myShip.getPlanet().getStory();
        eventOutcomeLabel.setText(story.getConclusion1());
        story.reward(option1Button.getText());
        storyEnd();
    }
    
    @FXML
    private void option2ButtonAction() {
        Story story = main.myShip.getPlanet().getStory();
        eventOutcomeLabel.setText(story.getConclusion2());
        story.reward(option2Button.getText());
        storyEnd();
    }
    
    private void storyEnd() {
        exitButton.setVisible(true);
        exitButton.setDisable(false);
        option1Button.setDisable(true);
        option2Button.setDisable(true);
    }
    /*Label that appears after action.
    private void setActionLabel(String action, boolean warning){
        actionLabel.setText(action);
        
        if (warning) {
            warningLabel.setText("Warning! Heat damage.");
            
            //Code for the text to fade.
            FadeTransition fader = createFader(warningLabel);
            SequentialTransition blinkThenFade = new SequentialTransition(fader);
            blinkThenFade.play();
            createFader(warningLabel);
        }
        
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
    }*/
    private void story(){
        
        Story story = main.getMyShip().getPlanet().getStory();
        option1Button.setText(story.getOption1());
        option2Button.setText(story.getOption2());
        eventExplanationLabel.setText(story.getStory());
        eventOutcomeLabel.setText("");
        eventImage.setImage(story.getImg());
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        exitButton.setVisible(false);
        exitButton.setDisable(true);
        story();
        
    }
}

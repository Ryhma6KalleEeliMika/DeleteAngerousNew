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
    private Label eventExplanationLabel, eventOutcomeLabel, gainLabel, lossLabel;
    
    @FXML
    private ImageView eventImage;
    
    @FXML   //Exit button after exploration event has concluded.
    private void exitButtonAction(){
        main.myShip.getPlanet().setExplored(true);
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML   //Choice 1 in the exploration event.
    private void option1ButtonAction() {
        Story story = main.myShip.getPlanet().getStory();
        storyEnd(story.reward(option1Button.getText(), story), story);
        eventOutcomeLabel.setText(story.getConclusion1());
    }
    
    @FXML   //Choice 2 in the exploration event.
    private void option2ButtonAction() {
        Story story = main.myShip.getPlanet().getStory();
        storyEnd(story.reward(option2Button.getText(), story), story);
        eventOutcomeLabel.setText(story.getConclusion2());
    }
    
    //After the choice has been made.
    private void storyEnd(String gainLoss, Story story) {
        eventImage.setImage(story.getImg());
        exitButton.setVisible(true);
        exitButton.setDisable(false);
        option1Button.setDisable(true);
        option2Button.setDisable(true);
        setGainLossLabel(gainLoss);
    }
    
    //Fading label of what happens when the random event is over. E.g. Warning! Hull damage
    private void setGainLossLabel(String text){
        
        //If the text is warning text. -> Red, negative. Warning! Hull damage
        if (text.length() > 2 && text.substring(0, 3).equals("War")) {
            lossLabel.setText(text);
            //Code for the text to fade.
            FadeTransition fader = createFader(lossLabel);
            SequentialTransition blinkThenFade = new SequentialTransition(fader);
            blinkThenFade.play();
            createFader(gainLabel);
        }
        //Blue text. Positive message. E.g. +50cr
        else {
            gainLabel.setText(text);
            //Code for the text to fade.
            FadeTransition fader = createFader(gainLabel);
            SequentialTransition blinkThenFade = new SequentialTransition(fader);
            blinkThenFade.play();
            createFader(gainLabel);
        }
    }
    
    //Fader method.
    private FadeTransition createFader(Node node) {
        FadeTransition fade = new FadeTransition(Duration.seconds(8), node);
        fade.setFromValue(1);
        fade.setToValue(0);
        return fade;
    }
    
    //Displaying the planets rng 'story'
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
        gainLabel.setText("");
        lossLabel.setText("");
        exitButton.setVisible(false);
        exitButton.setDisable(true);
        story();    
    }
}

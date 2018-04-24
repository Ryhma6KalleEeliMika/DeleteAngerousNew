package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.main;
import Objects.Engine;
import Objects.FuelCell;
import Objects.Hull;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Kalle
 */
public class ShopPopUpController implements Initializable {
    
    private int medFuelCellPrice = 200;
    private int largeFuelCellPrice = 400;
    
    private int reinforcedHullPrice = 200;
    private int militaryHullPrice = 400;
    
    private int advancedEnginePrice = 200;
    private int eliteEnginePrice = 400;
    
    private int fuelScoopPrice = 100;
    
    private final int fuelPrice = 1;
    private final int hullPrice = 2;
    
    //Tax rate of the current shop/planet
    private int tax = main.myShip.getPlanet().getTax();
    
    @FXML    
    private Button exitButton, actionButton, 
            mediumCellButton, largeCellButton, 
            reinforcedHullButton, militaryHullButton,
            advancedEngButton, eliteEngButton,
            fuelScoopButton, fuel1Button, fuel10Button,
            hull1Button, hull10Button;
    
    @FXML
    private Label actionLabel, moduleNameLabel, taxLabel, 
            priceLabel, priceColumnLabel, spec1Label, spec2Label,
            spec1, spec2;
    
    @FXML
    private ImageView moduleImage;
    
    @FXML   //Exit button
    private void exitButtonAction(){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML   //When pressing the Medium fuel cell button.
    private void mediumCellButtonAction() {
        if(main.myShip.getShipFuelCell().getName().equals("Medium")){
            setActionLabel("Module already installed.");
        }
        else if (main.myShip.getCredits() < medFuelCellPrice) {
            setActionLabel("Not enough credits.");
        }
        else {
            FuelCell medFuelCell = new FuelCell("Medium");
            main.myShip.setShipFuelCell(medFuelCell);
            main.myShip.loseCredits(medFuelCellPrice);
            setActionLabel("Medium fuel cell installed.");
        }
    }
    
    @FXML   //When pressing the Large fuel cell button
    private void largeCellButtonAction() {
        if(main.myShip.getShipFuelCell().getName().equals("Large")){
            setActionLabel("Module already installed.");
        }
        
        else if (main.myShip.getCredits() < largeFuelCellPrice) {
            setActionLabel("Not enough credits.");
        }
        
        else {
            FuelCell largeFuelCell = new FuelCell("Large");
            main.myShip.setShipFuelCell(largeFuelCell);
            main.myShip.loseCredits(largeFuelCellPrice);
            setActionLabel("Large fuel cell installed.");
        }
    }
    
    @FXML   //When pressing the Reinforced hull button
    private void reinforcedHullButtonAction() {
        if(main.myShip.getShipHull().getName().equals("Reinforced")){
            setActionLabel("Module already installed.");
        }
        else if (main.myShip.getCredits() < reinforcedHullPrice) {
            setActionLabel("Not enough credits.");
        }
        else {
            Hull reinforcedHull = new Hull("Reinforced");
            main.myShip.setShipHull(reinforcedHull);
            main.myShip.loseCredits(reinforcedHullPrice);
            setActionLabel("Reinforced alloys installed.");
        }
    }
    
    @FXML   //When pressing the Military hull button
    private void militaryHullButtonAction() {
        if(main.myShip.getShipHull().getName().equals("Military")){
            setActionLabel("Module already installed.");
        }
        else if (main.myShip.getCredits() < militaryHullPrice) {
            setActionLabel("Not enough credits.");
        }
        else {
            Hull militaryHull = new Hull("Military");
            main.myShip.setShipHull(militaryHull);
            main.myShip.loseCredits(militaryHullPrice);
            setActionLabel("Military grade alloys installed.");
        }
    }
        
    @FXML   //When pressing the Advanced engine button
    private void advancedEngineButtonAction() {
        if(main.myShip.getShipEngine().getName().equals("Advanced")){
            setActionLabel("Module already installed.");
        }
        else if (main.myShip.getCredits() < advancedEnginePrice) {
            setActionLabel("Not enough credits.");
        }
        else {
            Engine advancedEngine = new Engine("Advanced");
            main.myShip.setShipEngine(advancedEngine);
            main.myShip.loseCredits(advancedEnginePrice);
            setActionLabel("Advanced engine installed.");
        }
    }
    
    @FXML   //When pressing the Elite engine button
    private void eliteEngineButtonAction() {
        if(main.myShip.getShipEngine().getName().equals("Elite")){
            setActionLabel("Module already installed.");
        }
        else if (main.myShip.getCredits() < eliteEnginePrice) {
            setActionLabel("Not enough credits.");
        }
        else {
            Engine eliteEngine = new Engine("Elite");
            main.myShip.setShipEngine(eliteEngine);
            main.myShip.loseCredits(eliteEnginePrice);
            setActionLabel("Elite engine installed.");
        }
    }
    
    @FXML   //When pressing the fuel scoop button
    private void fuelScoopButtonAction() {
        if(main.myShip.getFuelScoopInstalled()){
            setActionLabel("Module already installed.");
        }
        else if (main.myShip.getCredits() < fuelScoopPrice) {
            setActionLabel("Not enough credits.");
        }
        else {
            main.myShip.setFuelScoopInstalled(true);
            main.myShip.loseCredits(fuelScoopPrice);
            setActionLabel("Fuel scoop installed.");
        }
    }

    @FXML   //When pressing the +1 fuel button
    private void fuel1ButtonAction() {
        if(main.myShip.getShipFuelCell().getFuel() == main.myShip.getShipFuelCell().getMaxFuel()){
            setActionLabel("Fuel cell already full.");
        }
        else if (main.myShip.getCredits() < fuelPrice) {
            setActionLabel("Not enough credits.");
        }
        else {
            main.myShip.getShipFuelCell().fuelGain(1);
            main.myShip.loseCredits(fuelPrice);
            setActionLabel("1 fuel refilled.");
        }
    }
        
    @FXML   //When pressing the +10 fuel button
    private void fuel10ButtonAction() {
        
        if(main.myShip.getShipFuelCell().getFuel() == main.myShip.getShipFuelCell().getMaxFuel()){
            setActionLabel("Fuel cell already full.");
        }
        
        else if(main.myShip.getShipFuelCell().getFuel() >= main.myShip.getShipFuelCell().getMaxFuel() - 9) {
            main.myShip.loseCredits(fuelPrice * (main.myShip.getShipFuelCell().getMaxFuel() - main.myShip.getShipFuelCell().getFuel()));
            main.myShip.getShipFuelCell().fuelGain(10);
            setActionLabel("fuel refilled.");
        }
    
        else if (main.myShip.getCredits() < (fuelPrice * 10)) {
            setActionLabel("Not enough credits.");
        }
        
        else {
            main.myShip.getShipFuelCell().fuelGain(10);
            main.myShip.loseCredits(fuelPrice * 10);
            setActionLabel("10 fuel refilled.");
        }
    }
    
    @FXML   //When pressing the +1 hull button
    private void hull1ButtonAction() {
        if(main.myShip.getShipHull().getHull() == main.myShip.getShipHull().getMaxHull()){
            setActionLabel("Hull is already full.");
        }
        else if (main.myShip.getCredits() < hullPrice) {
            setActionLabel("Not enough credits.");
        }
        else {
            main.myShip.getShipHull().hullGain(1);
            main.myShip.loseCredits(hullPrice);
            setActionLabel("1 hull repaired.");
        }
    }
        
    @FXML   //When pressing the +10 hull button
    private void hull10ButtonAction() {
        
        if(main.myShip.getShipHull().getHull() == main.myShip.getShipHull().getMaxHull()){
            setActionLabel("Hull already full.");
        }
        
        else if(main.myShip.getShipHull().getHull() >= main.myShip.getShipHull().getMaxHull() - 9) {
            main.myShip.loseCredits(hullPrice * (main.myShip.getShipHull().getMaxHull() - main.myShip.getShipHull().getHull()));
            main.myShip.getShipHull().hullGain(10);
            setActionLabel("hull refilled.");
        }
    
        else if (main.myShip.getCredits() < (hullPrice * 10)) {
            setActionLabel("Not enough credits.");
        }
        
        else {
            main.myShip.getShipHull().hullGain(10);
            main.myShip.loseCredits(hullPrice * 10);
            setActionLabel("10 hull refilled.");
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
        setActionLabel("");
        //setSpecs1Visible();
        taxLabel.setText(Integer.toString(tax) + "cr");
        
        //For getting the specs
        FuelCell f = main.myShip.getShipFuelCell();
        Hull h = main.myShip.getShipHull();
        Engine e = main.myShip.getShipEngine();
        
        //Adding taxes to the prices.
        this.fuelScoopPrice = fuelScoopPrice + tax;
        this.medFuelCellPrice = medFuelCellPrice + tax;
        this.largeFuelCellPrice = largeFuelCellPrice + tax;
        this.reinforcedHullPrice = reinforcedHullPrice + tax;
        this.militaryHullPrice = militaryHullPrice + tax;
        this.advancedEnginePrice = advancedEnginePrice + tax;
        this.eliteEnginePrice = eliteEnginePrice + tax;
        
        //Mouse hover action.
        mediumCellButton.hoverProperty().addListener(l->{ //Medium fuel cell button mouse hover.
            showPriceLabel();
            setSpecs1Visible();
            hideSpecs2();
            Image image = new Image("Images/Modules/Medium.png");
            moduleImage.setImage(image);
            moduleNameLabel.setText("Medium fuel cell");
            priceLabel.setText(Integer.toString(medFuelCellPrice));
            spec1Label.setText("Capacity");
            spec1.setText(Integer.toString(f.getMediumMaxFuel()));
        });
        largeCellButton.hoverProperty().addListener(l->{ //Large fuel cell button mouse hover.
            showPriceLabel();
            setSpecs1Visible();
            hideSpecs2();
            Image image = new Image("Images/Modules/Large.png");
            moduleImage.setImage(image);
            moduleNameLabel.setText("Large fuel cell");
            priceLabel.setText(Integer.toString(largeFuelCellPrice));
            spec1Label.setText("Capacity");
            spec1.setText(Integer.toString(f.getLargeMaxFuel()));
        });
        reinforcedHullButton.hoverProperty().addListener(l->{ //Reinforced hull button mouse hover.
            showPriceLabel();
            setSpecs1Visible();
            hideSpecs2();
            Image image = new Image("Images/Modules/Reinforced.png");
            moduleImage.setImage(image);
            moduleNameLabel.setText("Reinforced Alloys");
            priceLabel.setText(Integer.toString(reinforcedHullPrice));
            spec1Label.setText("Armor");
            spec1.setText(Integer.toString(h.getReinforcedArmor()));

        });
        militaryHullButton.hoverProperty().addListener(l->{ //Military hull button mouse hover.
            showPriceLabel();
            setSpecs1Visible();
            hideSpecs2();
            Image image = new Image("Images/Modules/Military.png");
            moduleImage.setImage(image);
            moduleNameLabel.setText("Military grade Alloys");
            priceLabel.setText(Integer.toString(militaryHullPrice));
            spec1Label.setText("Armor");
            spec1.setText(Integer.toString(h.getMilitaryArmor()));
        });
        advancedEngButton.hoverProperty().addListener(l->{ //Advanced engine button mouse hover.
            showPriceLabel();
            setSpecs1Visible();
            setSpecs2Visibile();
            Image image = new Image("Images/Modules/Advanced.png");
            moduleImage.setImage(image);
            moduleNameLabel.setText("Advanced engine");
            priceLabel.setText(Integer.toString(advancedEnginePrice));
            spec1Label.setText("Travel");
            spec1.setText(Integer.toString(e.getAdvancedEngTravel()));
            spec2Label.setText("Jump");
            spec2.setText(Integer.toString(e.getAdvancedEngJump()));
        });
        eliteEngButton.hoverProperty().addListener(l->{ //Elite engine button mouse hover.
            showPriceLabel();
            setSpecs1Visible();
            setSpecs2Visibile();
            Image image = new Image("Images/Modules/Elite.png");
            moduleImage.setImage(image);
            moduleNameLabel.setText("Elite engine");
            priceLabel.setText(Integer.toString(eliteEnginePrice));
            spec1Label.setText("Travel");
            spec1.setText(Integer.toString(e.getEliteEngineTravel()));
            spec2Label.setText("Jump");
            spec2.setText(Integer.toString(e.getEliteEngineJump()));
        });
        fuelScoopButton.hoverProperty().addListener(l->{ //Fuel scoop button mouse hover.
            showPriceLabel();
            moduleNameLabel.setText("Fuel scoop");
            Image image = new Image("Images/Modules/FuelScoop.png");
            moduleImage.setImage(image);
            priceLabel.setText(Integer.toString(fuelScoopPrice));
            hideSpecs1();
            hideSpecs2();
        });
        fuel1Button.hoverProperty().addListener(l->{ //Fuel 1 button mouse hover.
            showPriceLabel();
            moduleNameLabel.setText("Fuel + 1");
            Image image = new Image("Images/Modules/fuel1.png");
            moduleImage.setImage(image);
            priceLabel.setText(Integer.toString(fuelPrice));
            hideSpecs1();
            hideSpecs2();
        });
        fuel10Button.hoverProperty().addListener(l->{ //Fuel 10 button mouse hover.
            showPriceLabel();
            moduleNameLabel.setText("Fuel + 10");
            Image image = new Image("Images/Modules/fuel10.png");
            moduleImage.setImage(image);
            priceLabel.setText(Integer.toString(fuelPrice * 10));
            hideSpecs1();
            hideSpecs2();
        });
        hull1Button.hoverProperty().addListener(l->{ //Fuel 1 button mouse hover.
            showPriceLabel();
            moduleNameLabel.setText("Hull + 1");
            Image image = new Image("Images/Modules/hull1.png");
            moduleImage.setImage(image);
            priceLabel.setText(Integer.toString(hullPrice));
            hideSpecs1();
            hideSpecs2();
        });
        hull10Button.hoverProperty().addListener(l->{ //Fuel 10 button mouse hover.
            showPriceLabel();
            moduleNameLabel.setText("Hull + 10");
            Image image = new Image("Images/Modules/hull10.png");
            moduleImage.setImage(image);
            priceLabel.setText(Integer.toString(hullPrice * 10));
            hideSpecs1();
            hideSpecs2();
        });
    }
    
    //Sets the price label to be visible
    private void showPriceLabel(){
        priceColumnLabel.setVisible(true);
        priceColumnLabel.setText("Price");
    }
    
    //Sets the first specs column to be visible
    private void setSpecs1Visible(){
        spec1Label.setVisible(true);
        spec1.setVisible(true);
    }
    
    //Sets the second specs column to be visible
    private void setSpecs2Visibile(){
        spec2Label.setVisible(true);
        spec2.setVisible(true);
    }
    
    //Hides the first specs column
    private void hideSpecs1(){
        spec1Label.setVisible(false);
        spec1.setVisible(false);
    }
    
    //Hides the second specs column
    private void hideSpecs2(){
        spec2Label.setVisible(false);
        spec2.setVisible(false);
    }
}

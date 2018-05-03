package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.main;
import Objects.Star;
import Objects.Ship;
import Objects.Planet;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Kalle
 */
public class MainViewController implements Initializable {

    
    @FXML   //Center screen image and shipImage
    private ImageView mainImage, shipImage;
    
    @FXML   //BLue "jump successful" label, fuel ammount, ship name.
    private Label jumpLabel, warningLabel, starsScannedAmmount, planetsScannedAmmount ,shipNameLabel,
            wpnTypeLabel, fuelCellTypeLabel, hullTypeLabel, engineTypeLabel, fuelScoopLabel;
    
    @FXML
    public Label fuelLabel, hullLabel, creditsLabel;
    
    @FXML   //Fuel and Hull Progress Bar  
    private ProgressBar fuelProgressBar, hullProgressBar;
    
    @FXML   //Current star, current planet, galaxy map button 
    private Button currentStarButton, currentPlanetButton, gMBapButton, beaconButton;
    
    @FXML   //Star buttons
    private Button n1, n2, n3, n4, starMark;

    @FXML   //Planet buttons
    private Button p1, p2, p3, p4, p1Mark, p2Mark, p3Mark, p4Mark;
    
    @FXML
    private VBox moduleBox;
    
    //Is ship image updated?
    private boolean update = true;
    
    //Alien encounter emptyImage
    public static boolean alienEncounter = false;
    private static boolean openAlienEncounterPopUp = false;
    
    //Switches to the galaxy map view.
    @FXML
    private void gMapButtonAction(ActionEvent event) throws IOException {
        Parent gMap = FXMLLoader.load(getClass().getClassLoader().getResource("Controllers/GalaxyMap.fxml"));
        Scene gMapScene = new Scene(gMap);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(gMapScene);
        window.show();
    }
    
    //N1 - N4 buttons for jumping neighbouring star systems.
    @FXML
    private void n1ButtonAction(ActionEvent event) {
        if(!alienInterdiction()) {
            Star destinationStar = main.myShip.getStar().getStar1(); //Get the destination star
            setJumpLabel(main.myShip.starJump(destinationStar)); //Sets the jump label after trip E.G. "Jump successful"
        }
    }
    
    @FXML
    private void n2ButtonAction(ActionEvent event) {
        if(!alienInterdiction()) {
            Star destinationStar = main.myShip.getStar().getStar2();
            setJumpLabel(main.myShip.starJump(destinationStar));
        }
    }
    
    @FXML
    private void n3ButtonAction(ActionEvent event) {
        if(!alienInterdiction()) {
            Star destinationStar = main.myShip.getStar().getStar3();
            setJumpLabel(main.myShip.starJump(destinationStar));
        }
    }
    
    @FXML
    private void n4ButtonAction(ActionEvent event) {
        if(!alienInterdiction()) {
            Star destinationStar = main.myShip.getStar().getStar4();
            setJumpLabel(main.myShip.starJump(destinationStar));
        }
    }

    //Planet buttons P1 - P4.
    @FXML
    private void p1ButtonAction(ActionEvent event) {
        if(!interdiction()) {
            Planet destinationPlanet = main.myShip.getStar().getPlanet1(); //Get the destination planet.
            setJumpLabel(main.myShip.planetTravel(destinationPlanet)); //Sets the jump label after trip E.G. "Orbiting Terra"
        }
    }
    
    @FXML
    private void p2ButtonAction(ActionEvent event) {
        if(!interdiction()) {
            Planet destinationPlanet = main.myShip.getStar().getPlanet2();
            setJumpLabel(main.myShip.planetTravel(destinationPlanet));
        }
    }
    
    @FXML
    private void p3ButtonAction(ActionEvent event) {
        if(!interdiction()) {
            Planet destinationPlanet = main.myShip.getStar().getPlanet3();
            setJumpLabel(main.myShip.planetTravel(destinationPlanet));
        }
    }
    
    @FXML
    private void p4ButtonAction(ActionEvent event) {
        if(!interdiction()) {
            Planet destinationPlanet = main.myShip.getStar().getPlanet4();
            setJumpLabel(main.myShip.planetTravel(destinationPlanet));
        }
    }
    
    @FXML
    private void beaconButtonAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Controllers/BeaconPopUp.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT); //Removes the x-button and top bar.
        stage.initModality(Modality.APPLICATION_MODAL); //Makes the window so that it has to be closed before going back to the main view.
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML  //Opens the star pop up window.
    private void starButtonAction(ActionEvent event) throws IOException{
        if (main.getMyShip().getStar() != null) {
            setJumpLabel(main.myShip.starScanner()); //Prints the current planet name scanned message.
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Controllers/StarPopUp.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT); //Removes the x-button and top bar.
            stage.initModality(Modality.APPLICATION_MODAL); //Makes the window so that it has to be closed before going back to the main view.
            stage.setScene(new Scene(root1));
            stage.show();
        }
    }
    
    @FXML  //Opens the planet pop up window.
    private void planetButtonAction(ActionEvent event) {
        if (main.getMyShip().getPlanet() != null) {
            try {
                setJumpLabel(main.myShip.planetScanner()); //Prints the current planet name scanned message.
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Controllers/PlanetPopUp.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT); //Removes the x-button and top bar.
                stage.initModality(Modality.APPLICATION_MODAL); //Makes the window so that it has to be closed before going back to the main view.
                stage.setScene(new Scene(root1));
                stage.show();
            }
            catch (Exception e) {
            }
        }
    }
    
    //Random chance to be interdicted by another ship when traveling from planet to planet
    private boolean interdiction() {
        if(interdictRng()) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Controllers/PursuerPopUp.fxml")); 
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT); //Removes the x-button and top bar.
                stage.initModality(Modality.APPLICATION_MODAL); //Makes the window so that it has to be closed before going back to the main view.
                stage.setScene(new Scene(root1));
                stage.show();
                return true;
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }
        
    //Random chance to be interdicted by another ship when traveling from planet to planet
    private boolean alienInterdiction() {
        if(alienEncounterRng()) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Controllers/PursuerPopUp.fxml")); 
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT); //Removes the x-button and top bar.
                stage.initModality(Modality.APPLICATION_MODAL); //Makes the window so that it has to be closed before going back to the main view.
                stage.setScene(new Scene(root1));
                stage.show();
                return true;
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }
    
    
    //One in tenth chance to be interdict when travelling between planets.
    private boolean interdictRng() {
        if(ThreadLocalRandom.current().nextInt(1, 10 + 1) == 1) {
            return true;
        }
        return false;
    }
        
    //One in hundred chance to be interdict when travelling between stars.
    private boolean alienEncounterRng() {
        if(ThreadLocalRandom.current().nextInt(1, 100 + 1) == 1) {
            setAlienEncounter(true);
            return true;
        }
        return false;
    }
    
  
     @FXML   //Fuel meter/ammount
    private void setFuelAmmount() {
        Ship myShip = main.getMyShip();
        fuelLabel.setText(Integer.toString((int) myShip.getShipFuelCell().getFuel()));
        fuelProgressBar.setProgress(myShip.getShipFuelCell().getFuel()/ myShip.getShipFuelCell().getMaxFuel());
        if (myShip.getShipFuelCell().getFuel()>(myShip.getShipFuelCell().getMaxFuel()*0.25)){
            fuelProgressBar.setStyle("-fx-accent: DeepSkyBlue");
        }/*
        else if (myShip.getShipFuelCell().getFuel()<=(myShip.getShipFuelCell().getMaxFuel()*0.75)){
            fuelProgressBar.setStyle("-fx-accent: yellow");
        }
        else if (myShip.getShipFuelCell().getFuel()<=(myShip.getShipFuelCell().getMaxFuel()*0.50)){
            fuelProgressBar.setStyle("-fx-accent: orange");
        }*/
        else if (myShip.getShipFuelCell().getFuel() < (myShip.getShipFuelCell().getMaxFuel()*0.25)){ 
            fuelProgressBar.setStyle("-fx-accent: red");
        }
    }
    
     @FXML   //Hull ammount
    private void setHullAmmount() {
        Ship myShip = main.getMyShip();
        hullLabel.setText(Integer.toString((int) myShip.getShipHull().getHull()));
        hullProgressBar.setProgress(myShip.getShipHull().getHull()/myShip.getShipHull().getMaxHull());
        if (myShip.getShipHull().getHull()>(myShip.getShipHull().getMaxHull()*0.25)){
            hullProgressBar.setStyle("-fx-accent: DeepSkyBlue");
        }/*
        else if (myShip.getShipHull().getHull()<=(myShip.getShipHull().getMaxHull()*0.75)){
            hullProgressBar.setStyle("-fx-accent: yellow");
        }
        else if (myShip.getShipHull().getHull()<=(myShip.getShipHull().getMaxHull()*0.50)){
            hullProgressBar.setStyle("-fx-accent: orange");
        }*/
        else if (myShip.getShipHull().getHull() < (myShip.getShipHull().getMaxHull()*0.25)){
            hullProgressBar.setStyle("-fx-accent: red");
        }
    }
    
    //Updates the small checkmarks next to planet/star buttons if scanned.
    private void scannedCheckMark() {
        Star s = main.myShip.getStar();
        starMark.setVisible(s.isScanned());
        p1Mark.setVisible(s.getPlanet1().isScanned());
        p2Mark.setVisible(s.getPlanet2().isScanned());
        p3Mark.setVisible(s.getPlanet3().isScanned());
        p4Mark.setVisible(s.getPlanet4().isScanned());
    }
    
    private void starButtonsRefresh(Ship myShip, Star currentStar) {
        //Star buttons.
        currentStarButton.setText(currentStar.getName());
        n1.setText(currentStar.getN1());
        n2.setText(currentStar.getN2());
        n3.setText(currentStar.getN3());
        n4.setText(currentStar.getN4());
        if(currentStar.getStar2()!= null){
            n2.setVisible(true);
        }
        else {
            n2.setVisible(false);
        }
        if(currentStar.getStar3()!= null){
            n3.setVisible(true);
        }
        else {
            n3.setVisible(false);
        }
        if(currentStar.getStar4()!= null){
            n4.setVisible(true);
        }
        else {
            n4.setVisible(false);
        }
        if(myShip.getPlanet() != null){
           currentPlanetButton.setVisible(true); 
        }
        else {
            currentPlanetButton.setVisible(false);
        }
    }
    
    //Planet buttons refresh.
    private void planetButtonsRefresh(Ship myShip, Star currentStar) {
        
        //Button text update
        currentPlanetButton.setText(myShip.getPlanetName());
        p1.setText(currentStar.getPlanet1().getName());
        p2.setText(currentStar.getPlanet2().getName());
        p3.setText(currentStar.getPlanet3().getName());
        p4.setText(currentStar.getPlanet4().getName());
        
        //Button visibility update, If alien encounter is active -> planet buttons are disabled.
        if(currentStar.getPlanet1().getName()!= null){
            p1.setVisible(!isAlienEncounter());
        }
        else {
            p1.setVisible(false);
        }
        if(currentStar.getPlanet2().getName()!= null){
            p2.setVisible(!isAlienEncounter());
        }
        else {
            p2.setVisible(false);
        }
        if(currentStar.getPlanet3().getName()!= null){
            p3.setVisible(!isAlienEncounter());
        }
        else {
            p3.setVisible(false);
        }
        if(currentStar.getPlanet4().getName()!= null){
            p4.setVisible(!isAlienEncounter());
        }
        else {
            p4.setVisible(false);
        }

        //Button colors orange/blue update and image change.
        if (myShip.getPlanet() == currentStar.getPlanet1()) {
            p1.setStyle("-fx-background-color:DeepSkyBlue");
            mainImage.setImage(main.myShip.getStar().getStarImage1());
        }
        else {
            p1.setStyle("-fx-background-color:DarkOrange");
        }
        if (myShip.getPlanet() == currentStar.getPlanet2()) {
            p2.setStyle("-fx-background-color:DeepSkyBlue");
            mainImage.setImage(main.myShip.getStar().getStarImage2());
        }
        else {
            p2.setStyle("-fx-background-color:DarkOrange");
        }
        if (myShip.getPlanet() == currentStar.getPlanet3()) {
            p3.setStyle("-fx-background-color:DeepSkyBlue");
            mainImage.setImage(main.myShip.getStar().getStarImage3());
        }
        else {
            p3.setStyle("-fx-background-color:DarkOrange");
        }
        if (myShip.getPlanet() == currentStar.getPlanet4()) {
            p4.setStyle("-fx-background-color:DeepSkyBlue");
            mainImage.setImage(main.myShip.getStar().getStarImage4());
        }
        else {
            p4.setStyle("-fx-background-color:DarkOrange");
        }
    }
    
    @FXML //GUI refresh. Happens every tenth of a second.
    public void guiRefresh() {
        Ship myShip = main.getMyShip();
        Star currentStar = myShip.getStar();
        setFuelAmmount();
        setHullAmmount();
        
        //Images and ship name.
        if (isAlienEncounter()) {
            Image emptyImg = new Image("Images/Stars/Empty/Empty.png");
            mainImage.setImage(emptyImg); 
        }
        else {
            mainImage.setImage(currentStar.getStarImage());
        }
        
        shipNameLabel.setText(myShip.getName());
        if (update) {
            shipImage.setImage(main.getShipImage());
        }
        
        //Scanner update
        starsScannedAmmount.setText(Integer.toString(myShip.getStarsScanned()) + "/" + main.getMAXSTARS());
        planetsScannedAmmount.setText(Integer.toString(myShip.getPlanetsScanned()) + "/" + main.getMAXPLANETS()); 
        scannedCheckMark();
        
        //Updates the text in the star and planet buttons and their visibility.
        starButtonsRefresh(myShip, currentStar);
        planetButtonsRefresh(myShip, currentStar);
        
        //Updates ship modules
        wpnTypeLabel.setText(myShip.getShipWeapon().getName());
        fuelCellTypeLabel.setText(myShip.getShipFuelCell().getName());
        hullTypeLabel.setText(myShip.getShipHull().getName());
        engineTypeLabel.setText(myShip.getShipEngine().getName());
        if(myShip.getFuelScoopInstalled()){
            fuelScoopLabel.setDisable(false);
        }
        
        //Ship money.
        creditsLabel.setText(Integer.toString(myShip.getCredits()));
        
        //Distress beacon
        if (myShip.getShipFuelCell().getFuel() <= myShip.getShipEngine().getFuelUsageJump()) {
            beaconButton.setVisible(true);
        }
        else {
            beaconButton.setVisible(false);
        }
    }
    
    //Label that appears after jump attempt. "Jump succesful or something else."
    private void setJumpLabel(String jumpResult){
        jumpLabel.setText(jumpResult);
        
        if (main.myShip.getShipFuelCell().getFuel() == 0) {
            warningLabel.setText("Warning! Fuel depleted.");
            FadeTransition fader = createFader(warningLabel);
            SequentialTransition blinkThenFade = new SequentialTransition(fader);
            blinkThenFade.play();
            createFader(warningLabel);
        }
        else if (main.myShip.getShipFuelCell().getFuel() < 21) {
            warningLabel.setText("Warning! Fuel low.");
            FadeTransition fader = createFader(warningLabel);
            SequentialTransition blinkThenFade = new SequentialTransition(fader);
            blinkThenFade.play();
            createFader(warningLabel);
        }

        //Code for the text to fade.
        FadeTransition fader = createFader(jumpLabel);
        SequentialTransition blinkThenFade = new SequentialTransition(fader);
        blinkThenFade.play();
        createFader(jumpLabel);
    }
    
    //More code to fade the text.
    private FadeTransition createFader(Node node) {
        FadeTransition fade = new FadeTransition(Duration.seconds(4), node);
        fade.setFromValue(1);
        fade.setToValue(0);
        return fade;
    }
    
    //Mouse hover
    private void mouseHoverAction() {
        moduleBox.hoverProperty().addListener(l->{ //Allows ship image to update.
            this.update = true;
        });
        
        wpnTypeLabel.hoverProperty().addListener(l->{ //Weapon image. Stops ship image..
            shipImage.setImage(main.myShip.getShipWeapon().getWeaponImage());
            this.update = false;
        });
        
        fuelCellTypeLabel.hoverProperty().addListener(l->{ //Fuel cell image. Stops ship image..
            shipImage.setImage(main.myShip.getShipFuelCell().getFuelImage());
            this.update = false;
        });
        
        hullTypeLabel.hoverProperty().addListener(l->{ //Hull image. Stops ship image.
            shipImage.setImage(main.myShip.getShipHull().getHullImage());
            this.update = false;
        });
        
        engineTypeLabel.hoverProperty().addListener(l->{ //Engine image. Stops ship image.
            shipImage.setImage(main.myShip.getShipEngine().getEngineImage());
            this.update = false;
        });
        
        fuelScoopLabel.hoverProperty().addListener(l->{ //Engine image. Stops ship image.
            shipImage.setImage(main.myShip.getFuelScoopImage());
            this.update = false;
        });
    }
    
    //Code that runs first when the GUI starts.
    @Override
    public void initialize(URL url, ResourceBundle rb){
 
        //setJumpLabel("");   //Empty jump label "Jump successful"
        jumpLabel.setText("");
        warningLabel.setText("");   //Empty warning label "Warning!"

        mouseHoverAction();
        
        //Automatically updates the GUI every tenth of a second.
        Task task = new Task<Void>() {
        @Override
        public Void call() throws Exception {
          int i = 0;
           while (true) {
                final int finalI = i++;
                Platform.runLater ( () -> guiRefresh()); //Calls the guiRefreshMethod
                Thread.sleep (100);    //How often

             }
         }
       };
       Thread th = new Thread(task);
       th.setDaemon(true);
       th.start();
    }

    public static void setAlienEncounter(boolean emptyStarImg) {
        MainViewController.alienEncounter = emptyStarImg;
    }

    public static boolean isAlienEncounter() {
        return alienEncounter;
    }

    public static void setOpenAlienEncounterPopUp(boolean openAlienEncounterPopUp) {
        MainViewController.openAlienEncounterPopUp = openAlienEncounterPopUp;
    }

    public static boolean isOpenAlienEncounterPopUp() {
        return openAlienEncounterPopUp;
    }
}


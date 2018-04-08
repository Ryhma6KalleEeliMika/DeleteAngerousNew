/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Kalle
 */
public class main extends Application {
    
    //Global ship variable
    public static Ship myShip;
    
    @Override //Gui's first window.
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Star generation with the correct image paths. Star image, planetImages and Galaxy map image.
        Star Sol = new Star("Images/Stars/Sol/","Sol.png","Sol1.png","Sol2.png","Sol3.png",null, "Images/GalaxyMap/SolMap.png");
        Star Maxima = new Star("Images/Stars/Maxima/","Maxima.png","Maxima1.png","Maxima2.png", null,null, "Images/GalaxyMap/MaximaMap.png");
        Star Ales = new Star("Images/Stars/Ales/","Ales.png","Ales1.png", null, null,null, "Images/GalaxyMap/AlesMap.png");
        
        //Once the stars are generated are details are added later. Idnum, Name, N1name, N2name, N3name, N4name, N1starObject, N2starObject, N3starObject, N4starObject.
        Sol.setStarDetails(0, "Sol", "Maxima", "Ales", null, null, Maxima, Ales, null, null, Sol, "Kronos", "Terra", "Smagua", null);
        Maxima.setStarDetails(1, "Maxima", "Sol", "Ales", null, null, Sol, Ales, null, null, Maxima, "Veibos", "Clao", null, null);
        Ales.setStarDetails(2, "Ales", "Sol", "Maxima", null, null, Sol, Maxima, null, null, Ales, "Utreon", null, null, null);
        
        //Ship generation Starting star system name and star system object.
        Ship newShip = new Ship("Sol",Sol);
        setMyShip(newShip);
        
        //Gui starts here.
        launch(args);
    }

    public static void setMyShip(Ship newShip) {
        main.myShip = newShip;
    }

    public static Ship getMyShip() {
        return myShip;
    }
}
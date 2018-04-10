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
        Star Sol = new Star("Images/Stars/Sol/", "Sol.png","Sol1.png","Sol2.png","Sol3.png",null, "Images/GalaxyMap/SolMap.png");
        Star Maxima = new Star("Images/Stars/Maxima/", "Maxima.png","Maxima1.png","Maxima2.png", null,null, "Images/GalaxyMap/MaximaMap.png");
        Star Ales = new Star("Images/Stars/Ales/", "Ales.png", "Ales1.png", null, null,null, "Images/GalaxyMap/AlesMap.png");
        Star Atok = new Star("Images/Stars/Atok/", "Atok.png", "Atok1.png", "Atok2.png", "Atok3.png",null, "Images/GalaxyMap/AtokMap.png");
        Star Kriy = new Star("Images/Stars/Kriy/", "Kriy.png", "Kriy1.png", "Kriy2.png", "Kriy3.png", "Kriy4.png", "Images/GalaxyMap/KriyMap.png");
        Star Giol = new Star("Images/Stars/Giol/", "Giol.png", "Giol1.png", "Giol2.png", "Giol3.png", "Giol4.png", "Images/GalaxyMap/GiolMap.png");
        Star Tramois = new Star("Images/Stars/Tramois/", "Tramois.png", null, null, null, null, "Images/GalaxyMap/TramoisMap.png");
        Star Veprio = new Star("Images/Stars/Veprio/", "Veprio.png", "Veprio1.png", "Veprio2.png", "Veprio3.png", null, "Images/GalaxyMap/VeprioMap.png");
        Star Evrae = new Star("Images/Stars/Evrae/", "Evrae.png", "Evrae1.png", "Evrae2.png", null, null, "Images/GalaxyMap/EvraeMap.png");
        Star Azon = new Star("Images/Stars/Azon/", "Azon.png", "Azon1.png", "Azon2.png", "Azon3.png", "Azon4.png", "Images/GalaxyMap/AzonMap.png");
        Star Lah = new Star("Images/Stars/Lah/", "Lah.png", "Lah1.png", "Lah2.png", "Lah3.png", "Lah4.png", "Images/GalaxyMap/LahMap.png");
        
        //Once the stars are generated are details are added later. Id, Name, N1name, N2name, N3name, N4name, ParentStar, planet1, p1Type, planet2, p2Type, planet3, p3Type, planet4, p4Type.
        Sol.setStarDetails(0, "Sol", "Maxima", "Ales", null, null, Maxima, Ales, null, null, Sol, "Kronos","rock", "Terra", "terran", "Smagua", "gas",null, null);
        Maxima.setStarDetails(1, "Maxima", "Sol", "Ales", "Atok", null, Sol, Ales, Atok, null, Maxima, "Veibos", "rock", "Clao", "rock", null, null, null, null);
        Ales.setStarDetails(2, "Ales", "Sol", "Maxima", "Kriy", null, Sol, Maxima, Kriy, null, Ales, "Utreon", "gas", null, null, null, null, null, null);
        Atok.setStarDetails(3, "Atok", "Maxima", "Kriy", "Giol", "Tramois", Maxima, Kriy, Giol, Tramois, Atok, "Lounov", "rock", "Bosnera", "ring", "Detrone", "ice",null, null);
        Kriy.setStarDetails(4, "Kriy", "Ales", "Atok", "Giol", null, Ales, Atok, Giol, null, Kriy, "Emerth", "gas", "Ramara", "gas", "Datov", "ice", "Iulov", "ice");
        Giol.setStarDetails(5, "Giol", "Atok", "Kriy", "Veprio", "Evrae", Atok, Kriy, Veprio, Evrae, Giol, "Strelek", "rock", "Qonus", "terran", "Poftro", "gas", "Ieliv", "ice");
        Tramois.setStarDetails(6, "Tramois", "Atok", "Veprio", "Lah", "Stripruar", Atok, Veprio, Lah, null, Tramois, null, null, null, null, null, null, null, null);
        Veprio.setStarDetails(7, "Veprio", "Giol", "Tramois", "Strope", "Azon", Giol, Tramois, null, Azon, Veprio, "Proxia", "rock", "Skilia", "water", "Sloria", "ring", null, null);
        Evrae.setStarDetails(8, "Evrae", "Giol", "Azon", null, null, Giol, Azon, null, null, Evrae, "Steelar", "rock", "Crio", "terran", null, null, null, null);
        Azon.setStarDetails(9, "Azon", "Evrae", "Veprio", "Strope", "Koh", Evrae, Veprio, null, null, Azon, "Black hole", "black hole", "Giunope", "gas", "Duitera", "ring", "Spor", "rock");
        Lah.setStarDetails(10, "Lah", "Tramois", "Stripruar", "Adeotre", "Kuel", Tramois, null, null, null, Lah, "Beophus", "rock", "Glogua", "rock", "Stasie", "ice", null, null);
        
        //Ship generation Starting star system name and star system object.
        Ship newShip = new Ship("Sol", Sol);
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
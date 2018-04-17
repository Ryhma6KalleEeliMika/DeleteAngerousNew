/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.Map;
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
    
    //Global variables
    //Main ship
    public static Ship myShip;
    
    //Stars scanned list
    public static Map starsScanned, planetsScanned;
    
    //Chosen shipName
    public static String chosenShipName;
    
    //Starting star
    public static Star startingStar;
    
    public static Scene mainMenu;
    
    @Override //Gui's first window.
    public void start(Stage stage) throws Exception {
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent mainMenu = FXMLLoader.load(getClass().getResource("FXMLMainMenu.fxml"));
        Scene scene = new Scene(mainMenu);
        setMainMenu(scene);
        //stage.initStyle(StageStyle.TRANSPARENT); //Removes the x-button and top bar.
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Location list.
        Map<String, Boolean> starsScanned = new HashMap();
        setStarsScanned(starsScanned);
        
        Map<String, Boolean> planetsScanned = new HashMap();
        setPlanetsScanned(planetsScanned);
        
        //Star generation Id number and name.
        Star Sol = new Star(1, "Sol", true);
        Star Maxima = new Star(2, "Maxima", true);
        Star Ales = new Star(3, "Ales", false);
        Star Atok = new Star(4, "Atok", true);
        Star Kriy = new Star(5, "Kriy", false);
        Star Giol = new Star(6, "Giol", true);
        Star Tramois = new Star(7, "Tramois", false);
        Star Veprio = new Star(8, "Veprio", false);
        Star Evrae = new Star(9, "Evrae", true);
        Star Azon = new Star(10, "Azon", false);
        Star Lah = new Star(11, "Lah", false);
        Star Kuel = new Star(12, "Kuel", true);
        Star Ruan = new Star(13, "Ruan", false);
        Star Strope = new Star(14, "Strope", false);
        Star Stripruar = new Star(15, "Stripruar", false);
        Star Adeotre = new Star(16, "Adeotre", true);
        Star Bota = new Star(17, "Bota", false);
        Star Keleth = new Star(18, "Keleth", true);
        Star Saren = new Star(19, "Saren", false);
        Star Thiol = new Star(20, "Thiol", false);
        Star Kadi = new Star(21, "Kadi", true);
        Star Kro = new Star(22, "Kro", false);
        Star Xos = new Star(23, "Xos", true);
        Star Eura = new Star(24, "Eura", true);
        Star Koh = new Star(25, "Koh", true);
        Star Fleok = new Star(26, "Fleok", false);
        Star Avlian = new Star(27, "Avlian", false);
        Star Pheur = new Star(28, "Pheur", false);
        Star Ikum = new Star(29, "Ikum", false);
        Star Peode = new Star(30, "Peode", true);
        Star Oxuatri = new Star(31, "Oxuatri", false);
        Star Xaar = new Star(32, "Xaar", true);
        
        //Once the stars are generated, details are added later. Neighbouring stars and planets.
        //N1name, N2name, N3name, N4name, ParentStar, planet1, p1Type, planet2, p2Type, planet3, p3Type, planet4, p4Type.
        Sol.setStarDetails("Maxima", "Ales", null, null, Maxima, Ales, null, null, Sol, "Kronos","rock", "Terra", "terran", "Smagua", "gas",null, null);
        Maxima.setStarDetails("Sol", "Ales", "Atok", null, Sol, Ales, Atok, null, Maxima, "Veibos", "rock", "Clao", "rock", null, null, null, null);
        Ales.setStarDetails("Sol", "Maxima", "Kriy", null, Sol, Maxima, Kriy, null, Ales, "Utreon", "gas", null, null, null, null, null, null);
        Atok.setStarDetails("Maxima", "Kriy", "Giol", "Tramois", Maxima, Kriy, Giol, Tramois, Atok, "Lounov", "rock", "Bosnera", "ring", "Detrone", "ice",null, null);
        Kriy.setStarDetails("Ales", "Atok", "Giol", null, Ales, Atok, Giol, null, Kriy, "Emerth", "gas", "Ramara", "gas", "Datov", "ice", "Iulov", "ice");
        Giol.setStarDetails("Atok", "Kriy", "Veprio", "Evrae", Atok, Kriy, Veprio, Evrae, Giol, "Strelek", "rock", "Qonus", "terran", "Poftro", "gas", "Ieliv", "ice");
        Tramois.setStarDetails("Atok", "Veprio", "Lah", "Stripruar", Atok, Veprio, Lah, Stripruar, Tramois, null, null, null, null, null, null, null, null);
        Veprio.setStarDetails("Giol", "Tramois", "Strope", "Azon", Giol, Tramois, Strope, Azon, Veprio, "Proxia", "rock", "Skilia", "water", "Sloria", "ring", null, null);
        Evrae.setStarDetails("Giol", "Azon", null, null, Giol, Azon, null, null, Evrae, "Steelar", "rock", "Crio", "terran", null, null, null, null);
        Azon.setStarDetails("Evrae", "Veprio", "Strope", "Koh", Evrae, Veprio, Strope, Koh, Azon, "Boothill", "black hole", "Giunope", "gas", "Duitera", "ring", "Spor", "rock");
        Lah.setStarDetails("Tramois", "Stripruar", "Adeotre", "Kuel", Tramois, Stripruar, Adeotre, Kuel, Lah, "Beophus", "rock", "Glogua", "rock", "Stasie", "ice", null, null);
        Kuel.setStarDetails("Lah", "Ruan", null, null, Lah, Ruan, null, null, Kuel, "Praanus", "water", "Clapus", "rock", "Pelara", "gas", null, null);
        Ruan.setStarDetails("Kuel", null, null, null, Kuel, null, null, null, Ruan, "Foerus", "rock", "Blore", "rock", "Ailara", "ice", null, null);
        Strope.setStarDetails("Veprio", "Azon", "Stripruar", null, Veprio, Azon, Stripruar, null, Strope, "Geter", "rock", "Thorix", "gas", "Biluq", "ring", null, null);
        Stripruar.setStarDetails("Tramois", "Strope", "Lah", "Adeotre", Tramois, Strope, Lah, Adeotre, Stripruar, "Degroilite", "gas", null, null, null, null, null, null);
        Adeotre.setStarDetails("Stripruar", "Lah", "Keleth", "Bota", Stripruar, Lah, Keleth, Bota, Adeotre, "Oetha", "terran", "Eylaar", "terran", "Styke", "rock", null, null);
        Saren.setStarDetails("Bota", "Kadi", "Xos", "Kro", Bota, Kadi, Xos, Kro, Saren, null, null, null, null, null, null, null, null);
        Bota.setStarDetails("Adeotre", "Keleth", "Thiol", "Saren", Adeotre, Keleth, Thiol, Saren, Bota, "Rag", "rock", "Usnivobo", "gas", null, null, null, null);
        Thiol.setStarDetails("Bota", "Keleth", "Kadi", null, Bota, Keleth, Kadi, null, Thiol, null, null, null, null, null, null, null, null);
        Keleth.setStarDetails("Adeotre", "Bota", "Thiol", null, Adeotre, Bota, Thiol, null, Keleth, "Korvot", "rock", "Kalameet", "lava", "Kasmet", "gas", null, null);
        Kadi.setStarDetails("Saren", "Thiol", "Eura", null, Saren, Thiol, Eura, null, Kadi, "Ravinus", "lava", "Tenes", "terran", "Genur", "rock", "Vargon", "gas");
        Kro.setStarDetails("Saren", "Xos", "Koh", null, Saren, Xos, Koh, null, Kro, "Rubric", "lava", "Deus", "ring", "Talkris", "ice", null, null);
        Xos.setStarDetails("Saren", "Kro", "Eura", "Fleok", Saren, Kro, Eura, Fleok, Xos, "Sotha", "rock", "Braade", "rock", "Krona", "rock", "Krota", "rock");
        Eura.setStarDetails("Xos", "Kadi", "Avlian", null, Xos, Kadi, Avlian, null, Eura, "Elea", "terran", "Eria", "water", "Kolea", "ice", null, null);
        Koh.setStarDetails("Azon", "Kro", "Pheur", null, Azon, Kro, Pheur, null, Koh, "Yorma", "lava", "Donurus", "terran", null, null, null, null);
        Fleok.setStarDetails("Xos", "Avlian", "Ikum", "Pheur", Xos, Avlian, Ikum, Pheur, Fleok, "Yorius", "rock", "Andreus", "ring", "Akirius", "ice", null, null);       
        Avlian.setStarDetails("Eura", "Fleok", "Ikum", null, Eura, Fleok, Ikum, null, Avlian, "Arialus", "ice", null, null, null, null, null, null);
        Pheur.setStarDetails("Koh", "Fleok", "Peode", "Oxuatri", Koh, Fleok, Peode, Oxuatri, Pheur, "Dyno", "rock", "Nutor", "lava", null, null, null, null);
        Ikum.setStarDetails("Fleok", "Avlian", "Pheur", "Peode", Fleok, Avlian, Pheur, Peode, Ikum, "Hynos", "water", "Aaros", "terran", null, null, null, null);
        Peode.setStarDetails("Ikum", "Pheur", "Oxuatri", null, Ikum, Pheur, Oxuatri, null, Peode, "Kolas", "rock", "Kora", "rock", "Butarnus", "gas", null, null);
        Oxuatri.setStarDetails("Pheur", "Peode", "Xaar", null, Pheur, Peode, Xaar, null, Oxuatri, "Xanran", "ring", "Xemron", "gas", null, null, null, null);
        Xaar.setStarDetails("Oxuatri", null, null, null, Oxuatri, null, null, null, Xaar, "Ramor", "rock", null, null, null, null, null, null);
        
        setStartingStar(Sol);
        
        //Gui starts here.
        launch(args);
    }
    
    //Setters and getters......................................................................
    public static void setMyShip(Ship newShip) {
        main.myShip = newShip;
    }

    public static Ship getMyShip() {
        return myShip;
    }

    public static void setStarsScanned(Map starsScanned) {
        main.starsScanned = starsScanned;
    }

    public static Map getStarsScanned() {
        return starsScanned;
    }

    public static void setPlanetsScanned(Map planetsScanned) {
        main.planetsScanned = planetsScanned;
    }

    public static Map getPlanetsScanned() {
        return planetsScanned;
    }

    public static void setChosenShipName(String chosenShipName) {
        main.chosenShipName = chosenShipName;
    }

    public static String getChosenShipName() {
        return chosenShipName;
    }

    public static Star getStartingStar() {
        return startingStar;
    }

    public static void setStartingStar(Star startingStar) {
        main.startingStar = startingStar;
    }

    public static void setMainMenu(Scene mainMenu) {
        main.mainMenu = mainMenu;
    }

    public static Scene getMainMenu() {
        return mainMenu;
    }
}
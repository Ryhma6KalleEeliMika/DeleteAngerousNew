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
        
        //Star generation Id number and name.
        Star Sol = new Star(1, "Sol");
        Star Maxima = new Star(2, "Maxima");
        Star Ales = new Star(3, "Ales");
        Star Atok = new Star(4, "Atok");
        Star Kriy = new Star(5, "Kriy");
        Star Giol = new Star(6, "Giol");
        Star Tramois = new Star(7, "Tramois");
        Star Veprio = new Star(8, "Veprio");
        Star Evrae = new Star(9, "Evrae");
        Star Azon = new Star(10, "Azon");
        Star Lah = new Star(11, "Lah");
        Star Kuel = new Star(12, "Kuel");
        Star Ruan = new Star(13, "Ruan");
        Star Strope = new Star(14, "Strope");
        Star Stripruar = new Star(15, "Stripruar");
        Star Adeotre = new Star(16, "Adeotre");
        Star Bota = new Star(17, "Bota");
        Star Keleth = new Star(18, "Keleth");
        Star Saren = new Star(19, "Saren");
        Star Thiol = new Star(20, "Thiol");
        Star Kadi = new Star(21, "Kadi");
        Star Kro = new Star(22, "Kro");
        Star Xos = new Star(23, "Xos");
        Star Eura = new Star(24, "Eura");
        Star Koh = new Star(25, "Koh");
        Star Fleok = new Star(26, "Fleok");
        Star Avlian = new Star(27, "Avlian");
        Star Pheur = new Star(28, "Pheur");
        Star Ikum = new Star(29, "Ikum");
        Star Peode = new Star(30, "Peode");
        Star Oxuatri = new Star(31, "Oxuatri");
        Star Xaar = new Star(32, "Xaar");
        
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
        Azon.setStarDetails("Evrae", "Veprio", "Strope", "Koh", Evrae, Veprio, Strope, Koh, Azon, "Black hole", "black hole", "Giunope", "gas", "Duitera", "ring", "Spor", "rock");
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
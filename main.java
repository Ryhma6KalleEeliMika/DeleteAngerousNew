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
        Star Kuel = new Star("Images/Stars/Kuel/", "Kuel.png", "Kuel1.png", "Kuel2.png", "Kuel3.png", null, "Images/GalaxyMap/KuelMap.png");
        Star Ruan = new Star("Images/Stars/Ruan/", "Ruan.png", "Ruan1.png", "Ruan2.png", "Ruan3.png", null, "Images/GalaxyMap/RuanMap.png");
        Star Strope = new Star("Images/Stars/Strope/", "Strope.png", "Strope1.png", "Strope2.png", "Strope3.png", null, "Images/GalaxyMap/StropeMap.png");
        Star Stripruar = new Star("Images/Stars/Stripruar/", "Stripruar.png", "Stripruar1.png", null, null, null, "Images/GalaxyMap/StripruarMap.png");
        Star Adeotre = new Star("Images/Stars/Adeotre/", "Adeotre.png", "Adeotre1.png", "Adeotre2.png", "Adeotre3.png", null, "Images/GalaxyMap/AdeotreMap.png");
        Star Bota = new Star("Images/Stars/Bota/", "Bota.png", "Bota1.png", "Bota2.png", null, null, "Images/GalaxyMap/BotaMap.png");
        Star Keleth = new Star("Images/Stars/Keleth/", "Keleth.png", "Keleth1.png", "Keleth2.png", "Keleth3.png", null, "Images/GalaxyMap/KelethMap.png");
        Star Saren = new Star("Images/Stars/Saren/", "Saren.png", null, null, null, null, "Images/GalaxyMap/SarenMap.png");
        Star Thiol = new Star("Images/Stars/Thiol/", "Thiol.png", null, null, null, null, "Images/GalaxyMap/ThiolMap.png");
        Star Kadi = new Star("Images/Stars/Kadi/", "Kadi.png", "Kadi1.png", "Kadi2.png", "Kadi3.png", "Kadi4.png", "Images/GalaxyMap/KadiMap.png");
        Star Kro = new Star("Images/Stars/Kro/", "Kro.png", "Kro1.png", "Kro2.png", "Kro3.png", null, "Images/GalaxyMap/KroMap.png");
        Star Xos = new Star("Images/Stars/Xos/", "Xos.png", "Xos1.png", "Xos2.png", "Xos3.png", "Xos4.png", "Images/GalaxyMap/XosMap.png");
        Star Eura = new Star("Images/Stars/Eura/", "Eura.png", "Eura1.png", "Eura2.png", "Eura3.png", null, "Images/GalaxyMap/EuraMap.png");
        Star Koh = new Star("Images/Stars/Koh/", "Koh.png", "Koh1.png", "Koh2.png", null, null, "Images/GalaxyMap/KohMap.png");
        Star Fleok = new Star("Images/Stars/Fleok/", "Fleok.png", "Fleok1.png", "Fleok2.png", "Fleok3", null, "Images/GalaxyMap/FleokMap.png");
        Star Avlian = new Star("Images/Stars/Avlian/", "Avlian.png", "Avlian1.png", null, null, null, "Images/GalaxyMap/AvlianMap.png");
        Star Pheur = new Star("Images/Stars/Pheur/", "Pheur.png", "Pheur1.png", "Pheur2.png", null, null, "Images/GalaxyMap/PheurMap.png");
        Star Ikum = new Star("Images/Stars/Ikum/", "Ikum.png", "Ikum1.png", "Ikum2.png", null, null, "Images/GalaxyMap/IkumMap.png");
        Star Peode = new Star("Images/Stars/Peode/", "Peode.png", "Peode1.png", "Peode2.png", "Peode3.png", null, "Images/GalaxyMap/PeodeMap.png");
        Star Oxuatri = new Star("Images/Stars/Oxuatri/", "Oxuatri.png", "Oxuatri1.png", "Oxuatri2.png", null, null, "Images/GalaxyMap/OxuatriMap.png");
        Star Xaar = new Star("Images/Stars/Xaar/", "Xaar.png", "Xaar1.png", null, null, null, "Images/GalaxyMap/XaarMap.png");
        
        //Once the stars are generated are details are added later. Id, Name, N1name, N2name, N3name, N4name, ParentStar, planet1, p1Type, planet2, p2Type, planet3, p3Type, planet4, p4Type.
        Sol.setStarDetails(0, "Sol", "Maxima", "Ales", null, null, Maxima, Ales, null, null, Sol, "Kronos","rock", "Terra", "terran", "Smagua", "gas",null, null);
        Maxima.setStarDetails(1, "Maxima", "Sol", "Ales", "Atok", null, Sol, Ales, Atok, null, Maxima, "Veibos", "rock", "Clao", "rock", null, null, null, null);
        Ales.setStarDetails(2, "Ales", "Sol", "Maxima", "Kriy", null, Sol, Maxima, Kriy, null, Ales, "Utreon", "gas", null, null, null, null, null, null);
        Atok.setStarDetails(3, "Atok", "Maxima", "Kriy", "Giol", "Tramois", Maxima, Kriy, Giol, Tramois, Atok, "Lounov", "rock", "Bosnera", "ring", "Detrone", "ice",null, null);
        Kriy.setStarDetails(4, "Kriy", "Ales", "Atok", "Giol", null, Ales, Atok, Giol, null, Kriy, "Emerth", "gas", "Ramara", "gas", "Datov", "ice", "Iulov", "ice");
        Giol.setStarDetails(5, "Giol", "Atok", "Kriy", "Veprio", "Evrae", Atok, Kriy, Veprio, Evrae, Giol, "Strelek", "rock", "Qonus", "terran", "Poftro", "gas", "Ieliv", "ice");
        Tramois.setStarDetails(6, "Tramois", "Atok", "Veprio", "Lah", "Stripruar", Atok, Veprio, Lah, Stripruar, Tramois, null, null, null, null, null, null, null, null);
        Veprio.setStarDetails(7, "Veprio", "Giol", "Tramois", "Strope", "Azon", Giol, Tramois, Strope, Azon, Veprio, "Proxia", "rock", "Skilia", "water", "Sloria", "ring", null, null);
        Evrae.setStarDetails(8, "Evrae", "Giol", "Azon", null, null, Giol, Azon, null, null, Evrae, "Steelar", "rock", "Crio", "terran", null, null, null, null);
        Azon.setStarDetails(9, "Azon", "Evrae", "Veprio", "Strope", "Koh", Evrae, Veprio, Strope, Koh, Azon, "Black hole", "black hole", "Giunope", "gas", "Duitera", "ring", "Spor", "rock");
        Lah.setStarDetails(10, "Lah", "Tramois", "Stripruar", "Adeotre", "Kuel", Tramois, Stripruar, Adeotre, Kuel, Lah, "Beophus", "rock", "Glogua", "rock", "Stasie", "ice", null, null);
        Kuel.setStarDetails(11, "Kuel", "Lah", "Ruan", null, null, Lah, Ruan, null, null, Kuel, "Praanus", "water", "Clapus", "rock", "Pelara", "gas", null, null);
        Ruan.setStarDetails(12, "Ruan", "Kuel", null, null, null, Kuel, null, null, null, Ruan, "Foerus", "rock", "Blore", "rock", "Ailara", "ice", null, null);
        Strope.setStarDetails(13, "Strope", "Veprio", "Azon", "Stripruar", null, Veprio, Azon, Stripruar, null, Strope, "Geter", "rock", "Thorix", "gas", "Biluq", "ring", null, null);
        Stripruar.setStarDetails(14, "Stripruar", "Tramois", "Strope", "Lah", "Adeotre", Tramois, Strope, Lah, Adeotre, Stripruar, "Degroilite", "gas", null, null, null, null, null, null);
        Adeotre.setStarDetails(15, "Adeotre", "Stripruar", "Lah", "Keleth", "Bota", Stripruar, Lah, Keleth, Bota, Adeotre, "Oetha", "terran", "Eylaar", "terran", "Styke", "rock", null, null);
        Saren.setStarDetails(16, "Saren", "Bota", "Kadi", "Xos", "Kro", Bota, Kadi, Xos, Kro, Saren, null, null, null, null, null, null, null, null);
        Bota.setStarDetails(17, "Bota", "Adeotre", "Keleth", "Thiol", "Saren", Adeotre, Keleth, Thiol, Saren, Bota, "Rag", "rock", "Usnivobo", "gas", null, null, null, null);
        Thiol.setStarDetails(18, "Thiol", "Bota", "Keleth", "Kadi", null, Bota, Keleth, Kadi, null, Thiol, null, null, null, null, null, null, null, null);
        Keleth.setStarDetails(19, "Keleth", "Adeotre", "Bota", "Thiol", null, Adeotre, Bota, Thiol, null, Keleth, "Korvot", "rock", "Kalameet", "lava", "Kasmet", "gas", null, null);
        Kadi.setStarDetails(20, "Kadi", "Saren", "Thiol", "Eura", null, Saren, Thiol, Eura, null, Kadi, "Ravinus", "lava", "Tenes", "terran", "Genur", "rock", "Vargon", "gas");
        Kro.setStarDetails(21, "Kro", "Saren", "Xos", "Koh", null, Saren, Xos, Koh, null, Kro, "Rubric", "lava", "Deus", "ring", "Talkris", "ice", null, null);
        Xos.setStarDetails(22, "Xos", "Saren", "Kro", "Eura", "Fleok", Saren, Kro, Eura, Fleok, Xos, "Sotha", "rock", "Braade", "rock", "Krona", "rock", "Krota", "rock");
        Eura.setStarDetails(23, "Eura", "Xos", "Kadi", "Avlian", null, Xos, Kadi, Avlian, null, Eura, "Elea", "terran", "Eria", "water", "Kolea", "ice", null, null);
        Koh.setStarDetails(24, "Koh", "Azon", "Kro", "Pheur", null, Azon, Kro, Pheur, null, Koh, "Yorma", "lava", "Donurus", "terran", null, null, null, null);
        Fleok.setStarDetails(25, "Fleok", "Xos", "Avlian", "Ikum", "Pheur", Xos, Avlian, Ikum, Pheur, Fleok, "Yorius", "rock", "Andreus", "ring", "Akirius", "ice", null, null);       
        Avlian.setStarDetails(26, "Avlian", "Eura", "Fleok", "Ikum", null, Eura, Fleok, Ikum, null, Avlian, "Arialus", "ice", null, null, null, null, null, null);
        Pheur.setStarDetails(27, "Pheur", "Koh", "Fleok", "Peode", "Oxuatri", Koh, Fleok, Peode, Oxuatri, Pheur, "Dyno", "rock", "Nutor", "lava", null, null, null, null);
        Ikum.setStarDetails(28, "Ikum", "Fleok", "Avlian", "Pheur", "Peode", Fleok, Avlian, Pheur, Peode, Ikum, "Hynos", "water", "Aaros", "terran", null, null, null, null);
        Peode.setStarDetails(29, "Peode", "Ikum", "Pheur", "Oxuatri", null, Ikum, Pheur, Oxuatri, null, Peode, "Kolas", "rock", "Kora", "rock", "Butarnus", "gas", null, null);
        Oxuatri.setStarDetails(30, "Oxuatri", "Pheur", "Peode", "Xaar", null, Pheur, Peode, Xaar, null, Oxuatri, "Xanran", "ring", "Xemron", "gas", null, null, null, null);
        Xaar.setStarDetails(31, "Xaar", "Oxuatri", null, null, null, Oxuatri, null, null, null, Xaar, "Ramor", "rock", null, null, null, null, null, null);
        
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
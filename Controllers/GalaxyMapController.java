package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Objects.Star;
import Main.main;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kalle
 */
public class GalaxyMapController implements Initializable {
    
    @FXML
    private Button backButton;
    
    @FXML
    private Label locationLabel;
    
    @FXML
    private ImageView galaxyImage;
    
    @FXML
    private Button solScanned, maximaScanned, alesScanned, kriyScanned, atokScanned, giolScanned, evraeScanned,
            azonScanned, veprioScanned, tramoisScanned, stropeScanned, stripruarScanned, lahScanned, kuelScanned,
            ruanScanned, adeotreScanned, kelethScanned, botaScanned, thiolScanned, sarenScanned, kadiScanned,
            euraScanned, xosScanned, kroScanned, avlianScanned, fleokScanned, ikumScanned, kohScanned, pheurScanned,
            peodeScanned, oxuatriScanned, xaarScanned;
    
    @FXML //Button that takes you back to the main view.
    private void backButton(ActionEvent event) throws IOException {
        Parent normalView = FXMLLoader.load(getClass().getClassLoader().getResource("Controllers/MainView.fxml"));
        Scene normalScene = new Scene(normalView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(normalScene);
        window.show();
    }
    
    private void scanned(){
        HashMap s = main.starMap;
        HashMap p = main.planetMap;
        solScanned(s, p);
        maximaScanned(s, p);
        alesScanned(s, p);
        kriyScanned(s, p);
        atokScanned(s, p);
        giolScanned(s, p);
        evraeScanned(s, p);
        azonScanned(s, p);
        veprioScanned(s, p);
        tramoisScanned(s, p);
        stropeScanned(s, p);
        stripruarScanned(s, p);
        lahScanned(s, p);
        kuelScanned(s, p);
        ruanScanned(s, p);
        adeotreScanned(s, p);
        kelethScanned(s, p);
        botaScanned(s, p);
        thiolScanned(s, p);
        sarenScanned(s, p);
        kadiScanned(s, p);
        euraScanned(s, p);
        xosScanned(s, p);
        kroScanned(s, p);
        avlianScanned(s, p);
        fleokScanned(s, p);
        ikumScanned(s, p);
        kohScanned(s, p);
        pheurScanned(s, p);
        peodeScanned(s, p);
        oxuatriScanned(s, p);
        xaarScanned(s, p);
    }
    
    
    private void solScanned(HashMap s, HashMap p){
        solScanned.setVisible(s.get("Sol").equals(true) && p.get("Terra").equals(true) && p.get("Kronos").equals(true) && p.get("Smagua").equals(true));
    }
    private void maximaScanned(HashMap s, HashMap p){
        maximaScanned.setVisible(s.get("Maxima").equals(true) && p.get("Veibos").equals(true) && p.get("Clao").equals(true));
    }
    private void alesScanned(HashMap s, HashMap p){
        alesScanned.setVisible(s.get("Ales").equals(true) && p.get("Utreon").equals(true));
    }
    private void kriyScanned(HashMap s, HashMap p){
        kriyScanned.setVisible(s.get("Kriy").equals(true) && p.get("Emerth").equals(true) && p.get("Ramara").equals(true) && p.get("Datov").equals(true) && p.get("Iulov").equals(true));
    }
    private void atokScanned(HashMap s, HashMap p){
        atokScanned.setVisible(s.get("Atok").equals(true) && p.get("Lounov").equals(true) && p.get("Bosnera").equals(true) && p.get("Detrone").equals(true));
    }
    private void giolScanned(HashMap s, HashMap p){
        giolScanned.setVisible(s.get("Giol").equals(true) && p.get("Strelek").equals(true) && p.get("Qonus").equals(true) && p.get("Poftro").equals(true) && p.get("Ieliv").equals(true));
    }
    private void tramoisScanned(HashMap s, HashMap p){
        tramoisScanned.setVisible(s.get("Tramois").equals(true));
    }
    private void veprioScanned(HashMap s, HashMap p){
        veprioScanned.setVisible(s.get("Veprio").equals(true) && p.get("Proxia").equals(true) && p.get("Skilia").equals(true) && p.get("Sloria").equals(true));
    }
    private void evraeScanned(HashMap s, HashMap p){
        evraeScanned.setVisible(s.get("Evrae").equals(true) && p.get("Steelar").equals(true) && p.get("Crio").equals(true));
    }
    private void azonScanned(HashMap s, HashMap p){
        azonScanned.setVisible(s.get("Azon").equals(true) && p.get("Boothill").equals(true) && p.get("Giunope").equals(true) && p.get("Duitera").equals(true) && p.get("Spor").equals(true));
    }
    private void lahScanned(HashMap s, HashMap p){
        lahScanned.setVisible(s.get("Lah").equals(true) && p.get("Beophus").equals(true) && p.get("Glogua").equals(true) && p.get("Stasie").equals(true));
    }
    private void kuelScanned(HashMap s, HashMap p){
        kuelScanned.setVisible(s.get("Kuel").equals(true) && p.get("Praanus").equals(true) && p.get("Pelara").equals(true) && p.get("Clapus").equals(true));
    }
    private void ruanScanned(HashMap s, HashMap p){
        ruanScanned.setVisible(s.get("Ruan").equals(true) && p.get("Foerus").equals(true) && p.get("Blore").equals(true) && p.get("Ailara").equals(true));
    }
    private void stropeScanned(HashMap s, HashMap p){
        stropeScanned.setVisible(s.get("Strope").equals(true) && p.get("Geter").equals(true) && p.get("Thorix").equals(true) && p.get("Biluq").equals(true));
    }
    private void stripruarScanned(HashMap s, HashMap p){
        stripruarScanned.setVisible(s.get("Stripruar").equals(true) && p.get("Degroilite").equals(true));
    }
    private void adeotreScanned(HashMap s, HashMap p){
        adeotreScanned.setVisible(s.get("Adeotre").equals(true) && p.get("Oetha").equals(true) && p.get("Eylaar").equals(true) && p.get("Styke").equals(true));
    }
    private void sarenScanned(HashMap s, HashMap p){
        sarenScanned.setVisible(s.get("Saren").equals(true));
    }
    private void botaScanned(HashMap s, HashMap p){
        botaScanned.setVisible(s.get("Bota").equals(true) && p.get("Rag").equals(true) && p.get("Usnivobo").equals(true));
    }
    private void thiolScanned(HashMap s, HashMap p){
        thiolScanned.setVisible(s.get("Thiol").equals(true));
    }
    private void kelethScanned(HashMap s, HashMap p){
        kelethScanned.setVisible(s.get("Keleth").equals(true) && p.get("Korvot").equals(true) && p.get("Kalameet").equals(true) && p.get("Kasmet").equals(true));
    }
    private void kadiScanned(HashMap s, HashMap p){
        kadiScanned.setVisible(s.get("Kadi").equals(true) && p.get("Ravinus").equals(true) && p.get("Tenes").equals(true) && p.get("Genur").equals(true) && p.get("Vargon").equals(true));
    }
    private void kroScanned(HashMap s, HashMap p){
         kroScanned.setVisible(s.get("Kro").equals(true) && p.get("Rubric").equals(true) && p.get("Deus").equals(true) && p.get("Talkris").equals(true));
    }
    private void xosScanned(HashMap s, HashMap p){
        xosScanned.setVisible(s.get("Xos").equals(true) && p.get("Sotha").equals(true) && p.get("Braade").equals(true) && p.get("Krona").equals(true) && p.get("Krota").equals(true));
    }
    private void euraScanned(HashMap s, HashMap p){
        euraScanned.setVisible(s.get("Eura").equals(true) && p.get("Elea").equals(true) && p.get("Eria").equals(true) && p.get("Kolea").equals(true));
    }
    private void kohScanned(HashMap s, HashMap p){
        kohScanned.setVisible(s.get("Koh").equals(true) && p.get("Yorma").equals(true) && p.get("Donurus").equals(true));
    }
    private void fleokScanned(HashMap s, HashMap p){
        fleokScanned.setVisible(s.get("Fleok").equals(true) && p.get("Yorius").equals(true) && p.get("Andreus").equals(true) && p.get("Akirius").equals(true));
    }
    private void avlianScanned(HashMap s, HashMap p){
        avlianScanned.setVisible(s.get("Avlian").equals(true) && p.get("Arialus").equals(true));
    }
    private void pheurScanned(HashMap s, HashMap p){
        pheurScanned.setVisible(s.get("Pheur").equals(true) && p.get("Dyno").equals(true) && p.get("Nutor").equals(true));
    }
    private void ikumScanned(HashMap s, HashMap p){
        ikumScanned.setVisible(s.get("Ikum").equals(true) && p.get("Hynos").equals(true) && p.get("Aaros").equals(true));
    }
    private void peodeScanned(HashMap s, HashMap p){
        peodeScanned.setVisible(s.get("Peode").equals(true) && p.get("Kolas").equals(true) && p.get("Kora").equals(true) && p.get("Butarnus").equals(true));
    }
    private void oxuatriScanned(HashMap s, HashMap p){
        oxuatriScanned.setVisible(s.get("Oxuatri").equals(true) && p.get("Xanran").equals(true) && p.get("Xemron").equals(true));
    }
    private void xaarScanned(HashMap s, HashMap p){
            xaarScanned.setVisible(s.get("Xaar").equals(true) && p.get("Ramor").equals(true));
    }

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Galaxy map image update.
        Star currentStar = main.myShip.getStar();
        galaxyImage.setImage(currentStar.getGalaxyMapImage());
        
        //Location label update.
        locationLabel.setText(currentStar.getName());
        
        
        scanned();
        
    }
}

package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Objects.Star;
import Main.main;
import Sound.SoundEffects;
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
        SoundEffects.Sound("Button.wav");
        Parent normalView = FXMLLoader.load(getClass().getClassLoader().getResource("Controllers/MainView.fxml"));
        Scene normalScene = new Scene(normalView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(normalScene);
        window.show();
    }
    
    /**
     * Initializes the controller class.
     */
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
   
    //System scanner    
    private void solScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Sol").equals(true)) {
            solScanned.setVisible(true);
        }
        else {
            solScanned.setVisible(false);
        }
    }
    private void maximaScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Maxima").equals(true)) {
            maximaScanned.setVisible(true);
        }
        else {
            maximaScanned.setVisible(false);
        }
    }
    private void alesScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Ales").equals(true)) {
            alesScanned.setVisible(true);
        }
        else {
            alesScanned.setVisible(false);
        }
    }
    private void kriyScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Kriy").equals(true)) {
            kriyScanned.setVisible(true);
        }
        else {
            kriyScanned.setVisible(false);
        }
    }
    private void atokScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Atok").equals(true)) {
            atokScanned.setVisible(true);
        }
        else {
            atokScanned.setVisible(false);
        }
    }
    private void giolScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Giol").equals(true)) {
            giolScanned.setVisible(true);
        }
        else {
            giolScanned.setVisible(false);
        }
    }
    private void tramoisScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Tramois").equals(true)) {
            tramoisScanned.setVisible(true);
        }
        else {
            tramoisScanned.setVisible(false);
        }
    }
    private void veprioScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Veprio").equals(true)) {
            veprioScanned.setVisible(true);
        }
        else {
            veprioScanned.setVisible(false);
        }
    }
    private void evraeScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Evrae").equals(true)) {
            evraeScanned.setVisible(true);
        }
        else {
            evraeScanned.setVisible(false);
        }
    }
    private void azonScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Azon").equals(true)) {
            azonScanned.setVisible(true);
        }
        else {
            azonScanned.setVisible(false);
        }
    }
    private void lahScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Lah").equals(true)) {
            lahScanned.setVisible(true);
        }
        else {
            lahScanned.setVisible(false);
        }
    }
    private void kuelScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Kuel").equals(true)) {
            kuelScanned.setVisible(true);
        }
        else {
            kuelScanned.setVisible(false);
        }
    }
    private void ruanScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Ruan").equals(true)) {
            ruanScanned.setVisible(true);
        }
        else {
            ruanScanned.setVisible(false);
        }
    }
    private void stropeScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Strope").equals(true)) {
            stropeScanned.setVisible(true);
        }
        else {
            stropeScanned.setVisible(false);
        }
    }
    private void stripruarScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Stripruar").equals(true)) {
            stripruarScanned.setVisible(true);
        }
        else {
            stripruarScanned.setVisible(false);
        }
    }
    private void adeotreScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Adeotre").equals(true)) {
            adeotreScanned.setVisible(true);
        }
        else {
            adeotreScanned.setVisible(false);
        }
    }
    private void sarenScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Saren").equals(true)) {
            sarenScanned.setVisible(true);
        }
        else {
            sarenScanned.setVisible(false);
        }
    }
    private void botaScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Bota").equals(true)) {
            botaScanned.setVisible(true);
        }
        else {
            botaScanned.setVisible(false);
        }
    }
    private void thiolScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Thiol").equals(true)) {
            thiolScanned.setVisible(true);
        }
        else {
            thiolScanned.setVisible(false);
        }
    }
    private void kelethScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Keleth").equals(true)) {
            kelethScanned.setVisible(true);
        }
        else {
            kelethScanned.setVisible(false);
        }
    }
    private void kadiScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Kadi").equals(true)) {
            kadiScanned.setVisible(true);
        }
        else {
            kadiScanned.setVisible(false);
        }
    }
    private void kroScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Kro").equals(true)) {
            kroScanned.setVisible(true);
        }
        else {
            kroScanned.setVisible(false);
        }
    }
    private void xosScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Xos").equals(true)) {
            xosScanned.setVisible(true);
        }
        else {
            xosScanned.setVisible(false);
        }
    }
    private void euraScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Eura").equals(true)) {
            euraScanned.setVisible(true);
        }
        else {
            euraScanned.setVisible(false);
        }
    }
    private void kohScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Koh").equals(true)) {
            kohScanned.setVisible(true);
        }
        else {
            kohScanned.setVisible(false);
        }
    }
    private void fleokScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Fleok").equals(true)) {
            fleokScanned.setVisible(true);
        }
        else {
            fleokScanned.setVisible(false);
        }
    }
    private void avlianScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Avlian").equals(true)) {
            avlianScanned.setVisible(true);
        }
        else {
            avlianScanned.setVisible(false);
        }
    }
    private void pheurScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Pheur").equals(true)) {
            pheurScanned.setVisible(true);
        }
        else {
            pheurScanned.setVisible(false);
        }
    }
    private void ikumScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Ikum").equals(true)) {
            ikumScanned.setVisible(true);
        }
        else {
            ikumScanned.setVisible(false);
        }
    }
    private void peodeScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Peode").equals(true)) {
            peodeScanned.setVisible(true);
        }
        else {
            peodeScanned.setVisible(false);
        }
    }
    private void oxuatriScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Oxuatri").equals(true)) {
            oxuatriScanned.setVisible(true);
        }
        else {
            oxuatriScanned.setVisible(false);
        }
    }
    private void xaarScanned(HashMap s, HashMap p){
        if (main.systemMap.get("Xaar").equals(true)) {
            xaarScanned.setVisible(true);
        }
        else {
            xaarScanned.setVisible(false);
        }
    }

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

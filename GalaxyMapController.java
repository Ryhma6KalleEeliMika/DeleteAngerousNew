/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private ImageView galaxyImage;
    
    @FXML //Button that takes you back to the main view.
    private void backButton(ActionEvent event) throws IOException {
        Parent normalView = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene normalScene = new Scene(normalView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(normalScene);
        window.show();
    }

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Galaxy map image update.
        Star currentStar = main.myShip.getStar();
        galaxyImage.setImage(currentStar.getGalaxyMapImage());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiscalculia;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author FREDERIK
 */
public class FXMLHelperController implements Initializable {

    @FXML
    private Button backBtn;
    
    @FXML
    private Button btnAbout;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void act(ActionEvent event) throws IOException{
        
        Parent gdP = FXMLLoader.load(getClass().getResource("fxcalculia.fxml"));
        Scene gdS = new Scene(gdP);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        //window.setResizable(false);
        window.setScene(gdS);
        window.show();
    }
    
    @FXML
    private void btnAbt(ActionEvent event) throws IOException {
        
        Parent gdP = FXMLLoader.load(getClass().getResource("FXMLAbout.fxml"));
        Scene gdS = new Scene(gdP);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        //window.setResizable(false);
        window.setScene(gdS);
        window.show();
    }
}

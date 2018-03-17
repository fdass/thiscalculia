/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiscalculia;

import java.io.File;
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
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author FREDERIK
 */
public class FxcalculiaController implements Initializable {
    
    @FXML
    private static MediaPlayer mp;
    
    @FXML
    private Button helper;
    
    @FXML
    private ToggleButton tb;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Media menuMusic = new Media(new File("lucu.wav").toURI().toString());
        mp = new MediaPlayer(menuMusic);
        mp.play();
    }

    @FXML
    private void loadSecond(ActionEvent event) throws IOException {
        
        Parent gdP = FXMLLoader.load(getClass().getResource("GameDisplay.fxml"));
        Scene gdS = new Scene(gdP);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(gdS);
        window.show();
        mp.dispose();
        
    }
    
    @FXML
    private void loadHelp(ActionEvent event) throws IOException{
        Parent gdP = FXMLLoader.load(getClass().getResource("FXMLHelper.fxml"));
        Scene gdS = new Scene(gdP);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(gdS);
        window.show();
        mp.dispose();
    }
    
    @FXML
    private void musicController(ActionEvent e){
        if(tb.isSelected()){
            pause();
        }else{
            mainkan();
        }
    }
    
    private void mainkan(){
        mp.play();
    }
    
    private void pause(){
        mp.pause();
    }
}
    
    

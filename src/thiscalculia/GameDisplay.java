package thiscalculia;

import de.jensd.fx.glyphs.octicons.OctIcon;
import de.jensd.fx.glyphs.octicons.OctIconView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author FREDERIK
 */
public class GameDisplay implements Initializable {
    
    final private Random random = new Random();
    private static MediaPlayer mp;
    private int scoreContainer = 0;
    private int soalAcak = 0;
    private int y = 0;
    
    @FXML
    private ToggleButton tb;
    
    @FXML
    private Label score;
    
    @FXML
    private Label hiScore;
    
    @FXML
    private Label soal;
    
    @FXML
    Button[] btn = new Button[9];
    
    @FXML
    Button btn1 = new Button();
    
    @FXML
    Button btn2 = new Button();
    
    @FXML
    Button btn3 = new Button();
    
    @FXML
    Button btn4 = new Button();
    
    @FXML
    Button btn5 = new Button();
    
    @FXML
    Button btn6 = new Button();
    
    @FXML
    Button btn7 = new Button();
    
    @FXML
    Button btn8 = new Button();
    
    @FXML
    Button btn9 = new Button();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Media menuMusic = new Media(new File("lucu.wav").toURI().toString());
        mp = new MediaPlayer(menuMusic);
        mp.setAutoPlay(true);
       
       hiScore.setText(String.valueOf(HighScore.score));
       
       btn[0] = btn1;
       btn[1] = btn2;
       btn[2] = btn3;
       btn[3] = btn4;
       btn[4] = btn5;
       btn[5] = btn6;
       btn[6] = btn7;
       btn[7] = btn8;
       btn[8] = btn9;
       
       for (int x = 0; x < btn.length; x++) {
            int ran = random.nextInt(50) + 1;
            String str = String.valueOf(ran);
            btn[x].setText(str);
       }
    }    
    
    @FXML
    private void btnBack(ActionEvent event) throws IOException{
        
        Parent gdP = FXMLLoader.load(getClass().getResource("fxcalculia.fxml"));
        Scene gdS = new Scene(gdP);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        //window.setResizable(false);
        window.setScene(gdS);
        window.show();
        mp.dispose();
    }
    
    @FXML
    private void exitBtn(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void rnd(ActionEvent event) throws IOException{
       
       
       int a = Integer.parseInt(btn1.getText());
       int b = Integer.parseInt(btn2.getText());
       int c = Integer.parseInt(btn3.getText());
       int d = Integer.parseInt(btn4.getText());
       int e = Integer.parseInt(btn5.getText());
       int f = Integer.parseInt(btn6.getText());
       int g = Integer.parseInt(btn7.getText());
       int h = Integer.parseInt(btn8.getText());
       int i = Integer.parseInt(btn9.getText());
       
       if(soalAcak == 0){
           y = Biggest(a,b,c,d,e,f,g,h,i);
       }else{
           y = Smallest(a,b,c,d,e,f,g,h,i);
       }

       String text = ((Button) event.getSource()).getText();
       int nilai = Integer.parseInt(text);
       
       if(nilai != y){
           alertBox();
           Parent gdP = FXMLLoader.load(getClass().getResource("fxcalculia.fxml"));
           Scene gdS = new Scene(gdP);
        
           Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
           window.setScene(gdS);
           window.show();
           mp.dispose();
       }else{
           
           scoreContainer+=10;
           score.setText(String.valueOf(scoreContainer));
           HighScore.hs(scoreContainer);
           hiScore.setText(String.valueOf(HighScore.score));
           
           for (int x = 0; x < btn.length; x++) {
           int ran = random.nextInt(50)+1;
           String str = String.valueOf(ran);
           btn[x].setText(str);
           }
           
           soalAcak = random.nextInt(2);
           if(soalAcak == 1){
               soal.setText("CARI ANGKA TERKECIL!");
           }else{
               soal.setText("CARI ANGKA TERBESAR!");
           }

       }
    }
    
    @FXML
    private void musicController(ActionEvent e){
        if(tb.isSelected()){
            pause();
        }else{
            mainkan();
        }
    }
    
    private int Biggest(int a, int b, int c,
            int d, int e, int f, int g, int h, int i){
        
        int m = a;
        
        if(m < b)
            m = b;
        if(m < c)
            m = c;
        if(m < d)
            m = d;
        if(m < e)
            m = e;
        if(m < f)
            m = f;
        if(m < g)
            m = g;
        if(m < h)
            m = h;
        if(m < i)
            m = i;
        
        return m;
    }
    
    private int Smallest(int a, int b, int c,
            int d, int e, int f, int g, int h, int i){
        
        int m = a;
        
        if(m > b)
            m = b;
        if(m > c)
            m = c;
        if(m > d)
            m = d;
        if(m > e)
            m = e;
        if(m > f)
            m = f;
        if(m > g)
            m = g;
        if(m > h)
            m = h;
        if(m > i)
            m = i;
        
        return m;
    }
    
    private void alertBox(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Game Over!");
        alert.setContentText("Klik 'Mulai' untuk bermain lagi!");
        Optional<ButtonType> showAndWait = alert.showAndWait();
    }
    
    private void mainkan(){
        mp.play();
    }
    
    private void pause(){
        mp.pause();
    }
}

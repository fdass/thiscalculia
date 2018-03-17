/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiscalculia;

/**
 *
 * @author FREDERIK
 */
public class HighScore {
    public static int score = 0;
    
    public static void hs (int score) {
        if(score > HighScore.score){
            HighScore.score = score;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Lucas
 */
public class evaluationsDO {
    private int difficulty;
    private int quality;
    
    public void setDifficulty(int difficulty){
        this.difficulty=difficulty;
    }
    public int getDifficulty(){
        return difficulty;
    }
    
    public void setQuality(int quality){
        this.quality=quality;
    }
    public int getQuality(){
        return quality;
    }
}

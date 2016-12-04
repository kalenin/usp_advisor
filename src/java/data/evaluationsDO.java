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
    private int id;
    private int offering_id;
    private int student_id;
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
    
    public void setOffering_id(int offering_id){
        this.offering_id=offering_id;
    }
    public int getOffering_id(){
        return offering_id;
    }
    
    public void setStudent_id(int student_id){
        this.student_id=student_id;
    }
    public int getStudent_id(){
        return student_id;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}

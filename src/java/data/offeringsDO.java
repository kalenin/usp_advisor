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
public class offeringsDO {
    private int discipline_id;
    private String semester;
    private String schedule;
    
    public void setSemester(String semester){
        this.semester = semester;
    }
    public String getSemester(){
        return semester;
    }
    
    public void setDiscipline_id(int discipline_id){
        this.discipline_id=discipline_id;
    }
    public int getDiscipline_id(){
        return discipline_id;
    }
}

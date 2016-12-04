/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.data;

/**
 *
 * @author Vini
 */
public class professorsDO {
    private int id;
    private int offering_id;
    private String name;
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setOffering_id(int offering_id){
        this.offering_id=offering_id;
    }
    public int getOffering_id(){
        return offering_id;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}


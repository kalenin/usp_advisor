/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.transacoes;

import java.utils.*;
import java.data.*;
import java.util.*;

/**
 *
 * @author andrehamada
 */
public class evaluationsCO {
    public boolean incluir (evaluationsDO evaluation) throws Exception {
        
        //validacao das regras de negocio
        if(evaluation.getDifficulty() < 1 
                || evaluation.getDifficulty() > 5
                || evaluation.getQuality() < 1
                || evaluation.getQuality() >5 
                || evaluation.getOffering_id() == 0){
         return false;
        }
    
    Transacao tr = new Transacao();
    try {
        
        tr.begin();
            evaluationsDATA cdata = new evaluationsDATA();
            cdata.incluir(evaluation, tr);
        tr.commit();
        return true;
    } catch(Exception e){
        tr.rollback();
        System.out.println("erro ao incluir avaliacao");
        e.printStackTrace();
    }
    return false;
    }
    
    //incluir 
    public boolean atualizar(evaluationsDO evaluation) throws Exception {
        Transacao tr = new Transacao();
            try{
                //inserir validacoes de regras de negocio
               tr.begin();
                evaluationsDATA cdata = new evaluationsDATA();
                cdata.atualizar(evaluation, tr);
               tr.commit();
               return true;
            } catch (Exception e){
                tr.rollback();
                System.out.println("erro ao atualizar avaliacao");
                e.printStackTrace();
            }
            
            return false;
    }
    
    //atualizar
    
    public Vector pesquisar(int offering_id){
        if(offering_id == 0){
            return null;
        }
        
        Transacao tr = new Transacao();
        try{
            tr.beginReadOnly();
            evaluationsDATA cdata = evaluationsDATA();
            Vector v = cdata.pesquisarPorDifficulty_id
        }
    }
}



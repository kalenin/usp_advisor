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
    }//incluir 
    
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
    } //atualizar
    
    public evaluationsDO buscar(int idobj) throws Exception{
     Transacao tr = new Transacao();
	 try{
	   tr.beginReadOnly();
  	     evaluationsDATA cdata = new evaluationsDATA();
	     evaluationsDO c = cdata.buscar(idobj, tr);
	   tr.commit();
	   return c;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao buscar avaliacao");
	   e.printStackTrace();
	 }
	 return null;
    } // buscar
    
    public Vector pesquisarPorOffering_id(int offering_id){
        if(offering_id <= 0){
            return null;
        }
        
        Transacao tr = new Transacao();
        try{
            tr.beginReadOnly();
            evaluationsDATA cdata = new evaluationsDATA();
            Vector v = cdata.pesquisarPorOffering_id(offering_id, tr);
            tr.commit();
            return v;
        } catch (Exception e){
            System.out.println("erro ao pesquisar comentarios do oferecimento: " + offering_id);
            e.printStackTrace();
        }
        
        return null;
    }
    
   public Vector pesquisarPorStudent_id(int student_id){
       if(student_id <= 0){
           return null;
       }
       
       Transacao tr = new Transacao();
       try{
           tr.beginReadOnly();
           evaluationsDATA cdata = new evaluationsDATA();
           Vector v = cdata.pesquisarPorStudent_id(student_id, tr);
            tr.commit();
            return v;
       } catch (Exception e){
           System.out.println("erro ao pesquisar");
           e.printStackTrace();
       }
       return null;
   }
   
   public Vector pesquisarPorDifficulty(int difficulty){
       if(difficulty <= 0 || difficulty > 5){
           return null;
       }
       
       Transacao tr = new Transacao();
       try{
           tr.beginReadOnly();
           evaluationsDATA cdata = new evaluationsDATA();
           Vector v = cdata.pesquisarPorDifficulty(difficulty, tr);
           tr.commit();
           return v;
       } catch (Exception e){
           System.out.println("Erro ao pesquisar dificuldade");
           e.printStackTrace();
       }
       
       return null;
   }
   
   public Vector pesquisarPorQuality(int quality){
       
       if(quality <= 0 || quality > 5){
           return null;
       }
       
       Transacao tr = new Transacao();
       try{
           tr.beginReadOnly();
            evaluationsDATA cdata = new evaluationsDATA();
            Vector v = cdata.pesquisarPorQuality(quality, tr);
            tr.commit();
            return v;
       } catch (Exception e){
           System.out.println("erro ao pesquisar qualidade");
           e.printStackTrace();
       }
       
       return null;
   }
}



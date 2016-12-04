/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.transacoes;

/**
 *
 * @author Vini
 */

import java.utils.*;
import java.data.*;
import java.util.*;


public class professorsCO {

    public boolean incluir (professorsDO professor) throws Exception{

     // validacao das regras de negocio
     if ( (isEmpty(professor.getName())) || ( professor.getOffering_id() == 0))  {
       return false;
     }

     // efetuando a transacao
     Transacao tr = new Transacao();
     try {

       tr.begin();
         professorsDATA pdata = new professorsDATA();
         pdata.incluir(professor, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao incluir " + professor.getName());
         e.printStackTrace();
     }
     return false;
  } // incluir

  public boolean atualizar(professorsDO professor) throws Exception {
     Transacao tr = new Transacao();
	 try{
	   // inserir validacoes de regras de negocio
	   tr.begin();
  	     professorsDATA pdata = new professorsDATA();
	     pdata.atualizar(professor, tr);
	   tr.commit();
	   return true;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao atualizar" + professor.getName());
	   e.printStackTrace();
	 }
	 return false;
  } // atualizar

  public professorsDO buscar(int idobj) throws Exception{
     Transacao tr = new Transacao();
	 try{
	   tr.beginReadOnly();
  	     professorsDATA pdata = new professorsDATA();
	     professorsDO p = pdata.buscar(idobj, tr);
	   tr.commit();
	   return p;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao buscar" + idobj);
	   e.printStackTrace();
	 }
	 return null;
  } // buscar

  public Vector pesquisar(int offering_id) {
     if ( offering_id <= 0 )
        return null;

     Transacao tr = new Transacao();
     try {
	     tr.beginReadOnly();
           professorsDATA pdata = new professorsDATA();
           Vector v = pdata.pesquisarPorOffering_id(offering_id, tr);
		 tr.commit();
		 return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar " + offering_id);
         e.printStackTrace();
     }
     return null;
  } // pesquisar

  private boolean isEmpty(String s) {
     if (null == s)
       return true;
     if (s.length() == 0)
       return true;
     return false;
  }

  public static void main(String[] args) {
      professorsCO p = new professorsCO();
      professorsDO professor = new professorsDO();
      try {
	    professor = p.buscar(6);
		System.out.println(professor.getName());
      } catch(Exception e) {
          e.printStackTrace();
      }
  } // main
} // Contato
    

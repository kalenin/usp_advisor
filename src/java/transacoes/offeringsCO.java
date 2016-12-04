package java.transacoes;

import java.utils.*;
import java.data.offeringsDO;
import java.data.offeringsDATA;
import java.util.*;

public class offeringsCO {
 
  public boolean incluir (offeringsDO offerings) throws Exception{

     // validacao das regras de negocio
     if ( (isEmpty(offerings.getSemester())) || (offerings.getDiscipline_id()==0) ) {
       return false;
     }

     // efetuando a transacao
     Transacao tr = new Transacao();
     try {

       tr.begin();
         offeringsDATA cdata = new offeringsDATA();
         cdata.incluir(offerings, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao incluir " + offerings.getDiscipline_id());
         e.printStackTrace();
     }
     return false;
  } // incluir

  public boolean atualizar(offeringsDO offerings) throws Exception {
     Transacao tr = new Transacao();
	 try{
	   // inserir validacoes de regras de negocio
	   tr.begin();
  	     offeringsDATA cdata = new offeringsDATA();
	     cdata.atualizar(offerings, tr);
	   tr.commit();
	   return true;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao atualizar" + offerings.getDiscipline_id());
	   e.printStackTrace();
	 }
	 return false;
  } // atualizar

  public offeringsDO buscar(int idobj) throws Exception{
     Transacao tr = new Transacao();
	 try{
	   tr.beginReadOnly();
  	     offeringsDATA cdata = new offeringsDATA();
	     offeringsDO c = cdata.buscar(idobj, tr);
	   tr.commit();
	   return c;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao buscar" + idobj);
	   e.printStackTrace();
	 }
	 return null;
  } // buscar

  public Vector pesquisar(String discipline_id) {
     if ( isEmpty(discipline_id) )
        return null;

     Transacao tr = new Transacao();
     try {
	     tr.beginReadOnly();
           offeringsDATA cdata = new offeringsDATA();
           Vector v = cdata.pesquisarPorDiscipline_id(discipline_id, tr);
		 tr.commit();
		 return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar " + discipline_id);
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
      offeringsCO c = new offeringsCO();
      offeringsDO offerings = new offeringsDO();
      try {
	    offerings = c.buscar(6);
		System.out.println(offerings.getDiscipline_id());
      } catch(Exception e) {
          e.printStackTrace();
      }
  } // main
  
}

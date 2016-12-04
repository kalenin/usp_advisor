package java.transacoes;

import java.utils.*;
import java.data.*;
import java.util.*;
/**
 *
 * @author MininuPalo
 */
public class disciplinesCO {

  public boolean incluir (disciplinesDO discipline) throws Exception{

     // validacao das regras de negocio
     if ( (isEmpty(discipline.getName())) || ( isEmpty(discipline.getCode())) ) {
       return false;
     }

     // efetuando a transacao
     Transacao tr = new Transacao();
     try {

       tr.begin();
         disciplinesDATA cdata = new disciplinesDATA();
         cdata.incluir(discipline, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao incluir " + discipline.getCode());
         e.printStackTrace();
     }
     return false;
  } // incluir

  public boolean atualizar(disciplinesDO discipline) throws Exception {
     Transacao tr = new Transacao();
	 try{
	   // inserir validacoes de regras de negocio
	   tr.begin();
  	     disciplinesDATA cdata = new disciplinesDATA();
	     cdata.atualizar(discipline, tr);
	   tr.commit();
	   return true;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao atualizar" + discipline.getCode());
	   e.printStackTrace();
	 }
	 return false;
  } // atualizar

  public disciplinesDO buscar(int idobj) throws Exception{
     Transacao tr = new Transacao();
	 try{
	   tr.beginReadOnly();
  	     disciplinesDATA cdata = new disciplinesDATA();
	     disciplinesDO c = cdata.buscar(idobj, tr);
	   tr.commit();
	   return c;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao buscar" + idobj);
	   e.printStackTrace();
	 }
	 return null;
  } // buscar

  public Vector pesquisar(String code) {
     if ( isEmpty(code) )
        return null;

     Transacao tr = new Transacao();
     try {
	     tr.beginReadOnly();
           disciplinesDATA cdata = new disciplinesDATA();
           Vector v = cdata.pesquisarPorCode(code, tr);
		 tr.commit();
		 return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar " + code);
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
      disciplinesCO c = new disciplinesCO();
      disciplinesDO discipline = new disciplinesDO();
      try {
	    discipline = c.buscar(6);
		System.out.println(discipline.getName());
      } catch(Exception e) {
          e.printStackTrace();
      }
  } // main
} // Contato

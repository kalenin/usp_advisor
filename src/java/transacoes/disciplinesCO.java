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

  public disciplinesDO pesquisarPorCode(String code) {
     if ( isEmpty(code) )
        return null;

     Transacao tr = new Transacao();
     try {
	tr.beginReadOnly();
          disciplinesDATA cdata = new disciplinesDATA();
          disciplinesDO d = cdata.pesquisarPorCode(code, tr);
        tr.commit();
        return d;
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

} // Contato

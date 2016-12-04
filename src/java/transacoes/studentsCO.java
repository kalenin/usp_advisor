

/**
 *
 * @author Lucas
 */
package java.transacoes;

import java.utils.*;
import java.data.*;
import java.util.*;

public class studentsCO {
    
    public boolean incluir (studentsDO student) throws Exception{

     // validacao das regras de negocio
     if ( (isEmpty(student.getName())) || ( isEmpty(student.getNum_usp())) ) {
       return false;
     }

     // efetuando a transacao
     Transacao tr = new Transacao();
     try {

       tr.begin();
         studentsDATA cdata = new studentsDATA();
         cdata.incluir(student, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao incluir aluno: " + student.getNum_usp());
         e.printStackTrace();
     }
     return false;
  } // incluir
    
    public boolean atualizar(studentsDO student) throws Exception {
     Transacao tr = new Transacao();
	 try{
	   // inserir validacoes de regras de negocio
	   tr.begin();
  	     studentsDATA cdata = new studentsDATA();
	     cdata.atualizar(student, tr);
	   tr.commit();
	   return true;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao atualizar aluno: " + student.getNum_usp());
	   e.printStackTrace();
	 }
	 return false;
  }// atualizar
    
    public studentsDO buscar(int idobj) throws Exception{
     Transacao tr = new Transacao();
	 try{
	   tr.beginReadOnly();
  	     studentsDATA cdata = new studentsDATA();
	     studentsDO c = cdata.buscar(idobj, tr);
	   tr.commit();
	   return c;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao buscar comentario: " + idobj);
	   e.printStackTrace();
	 }
	 return null;
    } // buscar
    
    private boolean isEmpty(String s) {
     if (null == s)
       return true;
     if (s.length() == 0)
       return true;
     return false;
    }
}

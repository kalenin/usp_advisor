
package java.transacoes;

import java.utils.*;
import java.data.*;
import java.util.*;

/**
 *
 * @author Lucas
 */
public class commentsCO {
    public boolean incluir (commentsDO comment) throws Exception{

     // validacao das regras de negocio
     if (isEmpty(comment.getComment())||comment.getOffering_id()==0) {
       return false;
     }

     // efetuando a transacao
     Transacao tr = new Transacao();
     try {

       tr.begin();
         commentsDATA cdata = new commentsDATA();
         cdata.incluir(comment, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao incluir comentario: " + comment.getId());
         e.printStackTrace();
     }
     return false;
    } // incluir
    
    public boolean atualizar(commentsDO comment) throws Exception {
     Transacao tr = new Transacao();
	 try{
	   // inserir validacoes de regras de negocio
	   tr.begin();
  	     commentsDATA cdata = new commentsDATA();
	     cdata.atualizar(comment, tr);
	   tr.commit();
	   return true;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao atualizar comentario: " + comment.getId());
	   e.printStackTrace();
	 }
	 return false;
  }// atualizar
    
    public commentsDO buscar(int idobj) throws Exception{
     Transacao tr = new Transacao();
	 try{
	   tr.beginReadOnly();
  	     commentsDATA cdata = new commentsDATA();
	     commentsDO c = cdata.buscar(idobj, tr);
	   tr.commit();
	   return c;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao buscar comentario: " + idobj);
	   e.printStackTrace();
	 }
	 return null;
    } // buscar
    
    public Vector pesquisar(int offering_id) {
     if ( offering_id==0 )
        return null;

     Transacao tr = new Transacao();
     try {
	   tr.beginReadOnly();
           commentsDATA cdata = new commentsDATA();
           Vector v = cdata.pesquisarPorOffering_id(offering_id, tr);
		 tr.commit();
		 return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar comentarios do oferecimento: " + offering_id);
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
}

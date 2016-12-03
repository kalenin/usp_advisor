
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.data;

/**
 *
 * @author w
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.utils.Transacao;

public class evaluationsDATA {
    
   public void incluir (evaluationsDO evaluation, Transacao tr) throws Exception {
       Connection con = tr.obterConexao ();
       String sql = "INSERT INTO evaluations (offering_id, student_id, difficulty, quality) values (?, ?, ?, ?)";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setInt(1, evaluation.getOffering_id());
       ps.setInt(2, evaluation.getStudent_id());
       ps.setInt(3, evaluation.getDifficulty());
       ps.setInt(4, evaluation.getQuality());
       int result = ps.executeUpdate();
   }
   
    public void excluir(disciplinesDO discipline, Transacao tr) throws Exception {
        excluir(discipline.getId(), tr);
     } 
    
    public void excluir (int idobj, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "delete from disciplines where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idobj);
        int result = ps.executeUpdate();
    } // excluir 
    
   public Vector pesquisarPorDifficulty(int difficulty, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select of.semester, di.code, of.id FROM evaluations ev INNER JOIN  offerings of ON of.id = ev.offering_id INNER JOIN disciplines di ON di.id = of.discipline_id WHERE ev.difficulty = ? GROUP BY of.id;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, difficulty);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector evaluation = new Vector();
        while (rs.next()) {
           evaluationsDO d = new evaluationsDO();
           d.setOffering_id (rs.getInt("offering_id"));
           d.setStudent_id (rs.getInt("student_id"));
           d.setDifficulty(rs.getInt("difficulty"));
           d.setQuality(rs.getInt("quality"));
           evaluation.add(d);
        }
        return evaluation;
     } // pesquisarPorDificulty

   public Vector pesquisarPorQuality(int quality, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select of.semester, di.code, of.id FROM evaluations ev INNER JOIN  offerings of ON of.id = ev.offering_id INNER JOIN disciplines di ON di.id = of.discipline_id WHERE ev.quality = ? GROUP BY of.id;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, quality);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector evaluation = new Vector();
        while (rs.next()) {
           evaluationsDO d = new evaluationsDO();
           d.setOffering_id (rs.getInt("offering_id"));
           d.setStudent_id (rs.getInt("student_id"));
           d.setDifficulty(rs.getInt("difficulty"));
           d.setQuality(rs.getInt("quality"));
           evaluation.add(d);
        }
        return evaluation;
     } // pesquisarPorQuality
    }
    

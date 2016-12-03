
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.data;

import java.sql.*;
import java.util.*;
import java.utils.Transacao;
/**
 *
 * @author Vini
 */
public class ProfessorsData {
    
    public void incluir(ProfessorsDo professor, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "insert into professors (name, offering_id) values (?, ?)";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, professor.getName());
     ps.setInt(2, professor.getOffering_id());
     int result = ps.executeUpdate();
  }
    
    public void excluir(DisciplinesDo discipline, Transacao tr) throws Exception {
        excluir(discipline.getId(), tr);
     } 
    
    public void excluir (int idobj, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "delete from disciplines where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idobj);
        int result = ps.executeUpdate();
    } // excluir 
    
    public void atualizar(ProfessorsDo professor, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "update professors set name=?, offering_id=? where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, professor.getName());
        ps.setInt(2, professor.getOffering_id());
        ps.setInt(3, professor.getId());
        int result = ps.executeUpdate();
     } // atualizar

    public ProfessorsDo buscar(int idobj, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from offering_professor where  id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idobj);
        ResultSet rs = ps.executeQuery();
        rs.next();
        ProfessorsDo professor = new ProfessorsDo();
        professor.setId (rs.getInt("id"));
        professor.setName (rs.getString("name"));
        professor.setOffering_id (rs.getInt("offering_id"));
        return professor;
     } // buscar
    
    public Vector pesquisarPorNome(String name, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from offering_professor like name '?'";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector professor = new Vector();
        while (rs.next()) {
           ProfessorsDo d = new ProfessorsDo();
           d.setName (rs.getString("name"));
           d.setOffering_id(rs.getInt("offering_id"));
           System.out.println(" got " + d.getName());
           professor.add(d);
        }
        return professor;
     } // pesquisarPorNome
}

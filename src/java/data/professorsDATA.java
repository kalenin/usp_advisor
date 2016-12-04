
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;
import java.util.*;
import utils.Transacao;
/**
 *
 * @author Vini
 */
public class professorsDATA {
    
    public void incluir(professorsDO professor, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "insert into professors (name, offering_id) values (?, ?)";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, professor.getName());
     ps.setInt(2, professor.getOffering_id());
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
    
    public void atualizar(professorsDO professor, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "update professors set name=?, offering_id=? where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, professor.getName());
        ps.setInt(2, professor.getOffering_id());
        ps.setInt(3, professor.getId());
        int result = ps.executeUpdate();
     } // atualizar

    public professorsDO buscar(int idobj, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from offering_professor where  id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idobj);
        ResultSet rs = ps.executeQuery();
        rs.next();
        professorsDO professor = new professorsDO();
        professor.setId (rs.getInt("id"));
        professor.setName (rs.getString("name"));
        professor.setOffering_id (rs.getInt("offering_id"));
        return professor;
     } // buscar
    
    public Vector pesquisarPorOffering_id(int offering_id, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from offering_professor where offering_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, offering_id);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector professors = new Vector();
        while (rs.next()) {
           professorsDO d = new professorsDO();
           d.setId (rs.getInt("id"));
           d.setName (rs.getString("name"));
           d.setOffering_id (rs.getInt("offering_id"));
//           System.out.println(" got " + d.getId());
           professors.add(d);
        }
        return professors;
     } // pesquisarPorOffering_id
    
    public Vector pesquisarPorNome(String name, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from offering_professor like name '?'";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector professor = new Vector();
        while (rs.next()) {
           professorsDO d = new professorsDO();
           d.setName (rs.getString("name"));
           d.setOffering_id(rs.getInt("offering_id"));
           System.out.println(" got " + d.getName());
           professor.add(d);
        }
        return professor;
     } // pesquisarPorNome
}

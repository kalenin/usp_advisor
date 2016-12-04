/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import utils.Transacao;

/**
 *
 * @author kalenin
 */
public class disciplinesDATA {
  
    public void incluir(disciplinesDO discipline, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "INSERT INTO disciplines (code, name, description) values (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, discipline.getCode());
        ps.setString(2, discipline.getName());     
        ps.setString(3, discipline.getDescription());

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
    
    
    public void atualizar(disciplinesDO discipline, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "update disciplines set code=?, name=?, description=? where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, discipline.getCode());
        ps.setString(2, discipline.getName());     
        ps.setString(3, discipline.getDescription());
        ps.setInt(4, discipline.getId());
        int result = ps.executeUpdate();
     } // atualizar

    public disciplinesDO buscar(int idobj, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from disciplines where  id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idobj);
        ResultSet rs = ps.executeQuery();
        rs.next();
        disciplinesDO discipline = new disciplinesDO();
        discipline.setId (rs.getInt("id"));
        discipline.setCode (rs.getString("code"));
        discipline.setName (rs.getString("name"));
        discipline.setDescription (rs.getString("description"));
        return discipline;
     } // buscar
    
    public Vector pesquisarPorCode(String code, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from disciplines where code like '?'";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, code);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector disciplines = new Vector();
        while (rs.next()) {
           disciplinesDO d = new disciplinesDO();
           d.setId (rs.getInt("id"));
           d.setCode (rs.getString("code"));
           System.out.println(" got " + d.getCode());
           d.setName(rs.getString("name"));
           disciplines.add(d);
        }
        return disciplines;
     } // pesquisarPorCode
}
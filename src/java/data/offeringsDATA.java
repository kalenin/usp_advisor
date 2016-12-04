package java.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.utils.Transacao;

public class offeringsDATA {
  
    public void incluir(offeringsDO offerings, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "INSERT INTO offerings (discipline_id, semester) values (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, offerings.getDiscipline_id());
        ps.setString(2, offerings.getSemester());    
        
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
    
    public void atualizar(offeringsDO offerings, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "update offerings set discipline_id=?, semester=? where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, offerings.getDiscipline_id());
        ps.setString(2, offerings.getSemester());     
        ps.setInt(4, offerings.getId());
        int result = ps.executeUpdate();
     } // atualizar

    public offeringsDO buscar(int idobj, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from offerings where  id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idobj);
        ResultSet rs = ps.executeQuery();
        rs.next();
        offeringsDO offerings = new offeringsDO();
        offerings.setId (rs.getInt("id"));
        offerings.setSemester (rs.getString("semester"));
        offerings.setDiscipline_id (rs.getInt("Discipline_id"));
        return offerings;
     } // buscar
    
    public Vector pesquisarPorDiscipline_id(int discipline_id, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from offerings where code == '?'";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, discipline_id);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector offerings = new Vector();
        while (rs.next()) {
           offeringsDO d = new offeringsDO();
           d.setId (rs.getInt("id"));
           d.setDiscipline_id(rs.getInt("discipline_id"));
           System.out.println(" got " + d.getDiscipline_id());
           d.setDiscipline_id(rs.getInt("discipline_id"));
           offerings.add(d);
        }
        return offerings;
     } // pesquisarPorDiscipline_id
    
        public Vector pesquisarPorSemester(String semester, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from offerings where code == '?'";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, semester);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector offerings = new Vector();
        while (rs.next()) {
           offeringsDO d = new offeringsDO();
           d.setId (rs.getInt("id"));
           d.setSemester (rs.getString("semester"));
           System.out.println(" got " + d.getSemester());
           d.setSemester(rs.getString("semester"));
           offerings.add(d);
        }
        return offerings;
     } // pesquisarPorSemester
}

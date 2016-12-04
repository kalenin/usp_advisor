package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import utils.Transacao;
/**
 *
 * @author Lucas
 */
public class studentsDATA {
    
    public void incluir(studentsDO student, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "INSERT INTO students (num_usp, entry_year, name, email, password_hash) values (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, student.getNum_usp());
        ps.setInt(2, student.getEntry_year());     
        ps.setString(3, student.getName());
        ps.setString(4, student.getEmail());
        ps.setString(5, student.getPassword_hash());

        int result = ps.executeUpdate();
    }
    
    public void excluir(studentsDO student, Transacao tr) throws Exception {
        excluir(student.getId(), tr);
    } 
    
    public void excluir (int idobj, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "delete from students where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idobj);
        int result = ps.executeUpdate();
    } // excluir 
    
    public void atualizar(studentsDO student, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "update students set num_usp=?, entry_year=?, name=?, email=?, password_hash=? where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, student.getNum_usp());
        ps.setInt(2, student.getEntry_year());     
        ps.setString(3, student.getName());
        ps.setString(4, student.getEmail());
        ps.setString(5, student.getPassword_hash());
        ps.setInt(6, student.getId());
        int result = ps.executeUpdate();
    } // atualizar
    
    public studentsDO buscar(int idobj, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from students where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idobj);
        ResultSet rs = ps.executeQuery();
        rs.next();
        studentsDO student = new studentsDO();
        student.setId (rs.getInt("id"));
        student.setNum_usp (rs.getString("num_usp"));
        student.setEntry_year (rs.getInt("entry_year"));
        student.setName (rs.getString("name"));
        student.setPassword_hash(rs.getString("pasword_hash"));
        return student;
     } // buscar
    
    public Vector pesquisarPorNum_usp(String num_usp, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from students where num_usp = '?'";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, num_usp);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector students = new Vector();
        while (rs.next()) {
           studentsDO d = new studentsDO();
           d.setId(rs.getInt("id"));
           d.setNum_usp(rs.getString("num_usp"));
           d.setEntry_year(rs.getInt("entry_year"));
           d.setName(rs.getString("name"));
           d.setEmail(rs.getString("email"));
           d.setPassword_hash(rs.getString("password_hash"));
//         System.out.println(" got " + d.getNum_usp());
           students.add(d);
        }
        return students;
     } // pesquisarPorCode
}

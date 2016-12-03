package java.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.utils.Transacao;
/**
 *
 * @author Lucas
 */
public class StudentsData {
    
    public void incluir(StudentsDo student, Transacao tr) throws Exception {
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
    
    public void excluir(StudentsDo student, Transacao tr) throws Exception {
        excluir(student.getId(), tr);
    } 
    
    public void excluir (int idobj, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "delete from students where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idobj);
        int result = ps.executeUpdate();
    } // excluir 
    
    public void atualizar(StudentsDo student, Transacao tr) throws Exception {
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
    
    public StudentsDo buscar(int idobj, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from students where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idobj);
        ResultSet rs = ps.executeQuery();
        rs.next();
        StudentsDo student = new StudentsDo();
        student.setId (rs.getInt("id"));
        student.setNum_usp (rs.getString("num_usp"));
        student.setEntry_year (rs.getInt("entry_year"));
        student.setName (rs.getString("name"));
        student.setPassword_hash(rs.getString("pasword_hash"));
        return student;
     } // buscar
    
    public Vector pesquisarPorNome(String name, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from students where name like '?'";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector students = new Vector();
        while (rs.next()) {
           StudentsDo d = new StudentsDo();
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

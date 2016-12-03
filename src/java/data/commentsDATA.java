
package java.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import utils.Transacao;
/**
 *
 * @author Lucas
 */
public class commentsDATA {
    public void incluir(commentsDO comment, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "INSERT INTO comments (offering_id, student_id, comment) values (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, comment.getOffering_id());
        ps.setInt(2, comment.getStudent_id());     
        ps.setString(3, comment.getComment());

        int result = ps.executeUpdate();
    }
    
    public void excluir(commentsDO comment, Transacao tr) throws Exception {
        excluir(comment.getId(), tr);
    } 
    public void excluir (int idobj, Transacao tr) throws Exception {
    } // excluir 
    
    public void atualizar(commentsDO comment, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "update comments set offering_id=?, student_id=?, comment=? where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, comment.getOffering_id());
        ps.setInt(2, comment.getStudent_id());     
        ps.setString(3, comment.getComment());
        ps.setInt(4, comment.getId());
        int result = ps.executeUpdate();
    } // atualizar
    
    public commentsDO buscar(int idobj, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from comments where  id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idobj);
        ResultSet rs = ps.executeQuery();
        rs.next();
        commentsDO comment = new commentsDO();
        comment.setId (rs.getInt("id"));
        comment.setOffering_id (rs.getInt("offering_id"));
        comment.setStudent_id (rs.getInt("student_id"));
        comment.setComment (rs.getString("comment"));
        return comment;
    } // buscar
    
    public Vector pesquisarPorOffering_id(String offering_id, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from comments where offering_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, offering_id);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector comments = new Vector();
        while (rs.next()) {
           commentsDO d = new commentsDO();
           d.setId (rs.getInt("id"));
           d.setOffering_id (rs.getInt("offering_id"));
           d.setStudent_id (rs.getInt("student_id"));
           d.setComment (rs.getString("comment"));
           System.out.println(" got " + d.getId());
           comments.add(d);
        }
        return comments;
     } // pesquisarPorOffering_id
        
    public Vector pesquisarPorStudent_id(String student_id, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from comments where student_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, student_id);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector comments = new Vector();
        while (rs.next()) {
           commentsDO d = new commentsDO();
           d.setId (rs.getInt("id"));
           d.setOffering_id (rs.getInt("offering_id"));
           d.setStudent_id (rs.getInt("student_id"));
           d.setComment (rs.getString("comment"));
           System.out.println(" got " + d.getId());
           comments.add(d);
        }
        return comments;
    } // pesquisarPorOffering_id
}

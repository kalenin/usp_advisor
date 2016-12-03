
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
}

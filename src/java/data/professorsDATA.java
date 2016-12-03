/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.data;

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
     String sql = "insert into Agenda (nome, telefone) values (?, ?)";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, professor.getName());
     ps.setInt(2, professor.getOffering_id());
     int result = ps.executeUpdate();
  }
}

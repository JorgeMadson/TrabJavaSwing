/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabJava.DAO;

import TrabJava.Cliente;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class ClienteDAO extends Cliente implements Serializable {

    static ResultSet rs = null;
    static Connection con = null;
    static Statement st = null;

    public static boolean inserirCliente(Cliente c) {
        PreparedStatement st = null;
        try {
            //Conexao com o banco:
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_proj" ,"root", "root");
            
            st = con.prepareStatement("insert into tb_cliente (idCliente,nomeCliente,sobrenomeCliente,telefoneCliente) "
                    + "values (null, ?, ?, ?)");
            st.setString(1, c.getNome());
            st.setString(2, c.getSobrenome());
            st.setInt(3, c.getTelefone());
            int rowsAffected = st.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                }
            }
        }

    }

    public static boolean atualizarCliente(Cliente c) {
 PreparedStatement st = null;
        try {
            //Conexao com o banco:
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_proj" ,"root", "root");
            
            st = con.prepareStatement("update tb_cliente set nomeCliente=?,sobrenomeCliente=?,telefoneCliente=? where idCliente=? ");
            st.setString(1, c.getNome());
            st.setString(2, c.getSobrenome());
            st.setInt(3, c.getTelefone());
            st.setInt(4, c.getId());
          
            
            int rowsAffected = st.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                }
            }
        }        
    }

    public static boolean removerCliente(Cliente c) {
        return false;
    }

    public static Cliente buscarPorId(int id) {
        return null;
    }

    public static List<Cliente> buscarTodos() {
        return null;
    }

}

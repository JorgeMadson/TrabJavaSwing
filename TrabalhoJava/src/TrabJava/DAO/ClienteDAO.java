/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabJava.DAO;

import TrabJava.Cliente;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class ClienteDAO extends Cliente implements Serializable {

    ResultSet  rs  = null;
    
    public static boolean inserirCliente(Cliente c) {
        return false;
    }

    public static boolean atualizarCliente(Cliente c) {
        return false;
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

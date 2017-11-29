/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabJava.DAO;

import TrabJava.Pedido;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class PedidoDAO extends Pedido implements Serializable{
    
    public static boolean inserirPedido(Pedido c) {
        return false;
    }

    public static boolean atualizarPedido(Pedido c) {
        return false;
    }

    public static boolean removerPedido(Pedido c) {
        return false;
    }

    public static Pedido buscarPorId(int id) {
        return null;
    }

    public static List<Pedido> buscarTodos() {
        return null;
    }
}

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
    
        boolean inserirPedido(Pedido c) {
        return false;
    }

    boolean atualizarPedido(Pedido c) {
        return false;
    }

    boolean removerPedido(Pedido c) {
        return false;
    }

    Pedido buscarPorId(int id) {
        return null;
    }

    List<Pedido> buscarTodos() {
        return null;
    }
}

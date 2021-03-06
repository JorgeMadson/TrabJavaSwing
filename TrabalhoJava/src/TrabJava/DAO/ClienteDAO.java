/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabJava.DAO;

import TrabJava.Cliente;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Classe abstrata pois nenhum objeto é instanciado nela
public abstract class ClienteDAO extends Cliente implements Serializable {

    static ResultSet rs = null;
    static Connection con = null;

    public static boolean inserirCliente(Cliente c) {
        PreparedStatement st = null;
        try {
            //Conexao com o banco:
            con = DAOGeral.getConexaoMySQL();

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
            con = DAOGeral.getConexaoMySQL();

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
    /*//Esse método da erro pq o banco está em safe mode e só deixa excluir por id
    public static boolean removerCliente(Cliente c) {
        PreparedStatement st = null;
        try {
            //Conexao com o banco:
            con = DAOGeral.getConexaoMySQL();

            st = con.prepareStatement("delete from tb_cliente where nomeCliente=? and sobrenomeCliente=? and telefoneCliente=?");
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
    */

    //Este segundo método recebe apenas o ID como parâmetro
    public static boolean removerCliente(int idCliente) {
        PreparedStatement st = null;
        try {
            //Conexao com o banco:
            con = DAOGeral.getConexaoMySQL();

            st = con.prepareStatement("delete from tb_cliente where idCliente=? ");
            st.setInt(1, idCliente);

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

    public static Cliente buscarPorId(int id) {
        PreparedStatement st = null;
        try {
            //Conexao com o banco:
            con = DAOGeral.getConexaoMySQL();
            st = con.prepareStatement("select * from tb_cliente " + "where idCliente = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            
            Cliente resposta = new Cliente();
            while (rs.next()) {
                resposta.setId(rs.getInt("idCliente"));
                resposta.setNome(rs.getString("nomeCliente"));
                resposta.setSobrenome(rs.getString("sobrenomeCliente"));
                resposta.setTelefone(rs.getInt("telefoneCliente"));
            }
            return resposta;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                }
            }
        }
    }
    //buscarPorNomes
    public static Cliente buscarPorNomes(String nomes) {
        PreparedStatement st = null;
        try {
            //Conexao com o banco:
            con = DAOGeral.getConexaoMySQL();
            st = con.prepareStatement("select * from tb_cliente " + "where nomeCliente = ? or sobrenomeCliente = ?");
            st.setString(1, nomes);
            st.setString(2, nomes);
            rs = st.executeQuery();
            
            Cliente resposta = new Cliente();
            while (rs.next()) {
                resposta.setId(rs.getInt("idCliente"));
                resposta.setNome(rs.getString("nomeCliente"));
                resposta.setSobrenome(rs.getString("sobrenomeCliente"));
                resposta.setTelefone(rs.getInt("telefoneCliente"));
            }
            return resposta;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    public static ArrayList<Cliente> buscarTodos() {
                PreparedStatement st = null;
        try {
            //Conexao com o banco:
            con = DAOGeral.getConexaoMySQL();
            st = con.prepareStatement("select * from tb_cliente ");
            rs = st.executeQuery();
            
            ArrayList<Cliente> resposta = new ArrayList<Cliente>();
            Cliente c;
            while (rs.next()) {
                c = new Cliente(rs.getString("nomeCliente"),rs.getString("sobrenomeCliente"),rs.getInt("telefoneCliente"));
                c.setId(rs.getInt("idCliente"));
                resposta.add(c);
            }
            return resposta;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

}

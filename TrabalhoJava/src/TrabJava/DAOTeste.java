//Nome do nosso pacote //                
package TrabJava;

//Classes necessárias para uso de Banco de dados //
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

//Início da classe de conexão//
public class DAOTeste {

    public static String status = "Sem conexão...";

//Método Construtor da Classe//
    public DAOTeste() {

    }

//Método de Conexão//
    public static Connection getConexaoMySQL() {

        Connection connection = null;          //atributo do tipo Connection

        try {

// Carregando o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

// Configurando a nossa conexão com um banco de dados//
            String serverName = "localhost";    //caminho do servidor do BD

            String mydatabase = "teste";        //nome do seu banco de dados

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";        //nome de um usuário de seu BD      

            String password = "root";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);

            //Testa sua conexão//  
            if (connection != null) {

                status = ("STATUS: Conectado com sucesso!");

            } else {

                status = ("STATUS: Não foi possivel realizar conexão");

            }

            return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado
            e.printStackTrace();
            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) { //Não conseguindo se conectar ao banco
            e.printStackTrace();
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }

    }

    //Método que retorna o status da sua conexão//
    public static String statusConection() {

        return status;

    }

    //Método que fecha sua conexão//
    public static boolean FecharConexao() {

        try {

            DAOTeste.getConexaoMySQL().close();

            return true;

        } catch (SQLException e) {

            return false;

        }

    }

    //Método que reinicia sua conexão//
    public static java.sql.Connection ReiniciarConexao() {

        FecharConexao();

        return DAOTeste.getConexaoMySQL();

    }

    public static void main(String[] args) {
        getConexaoMySQL();
        System.out.println(statusConection());
    }
}

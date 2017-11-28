package TrabJava.DAO;

//Classes necessárias para uso de Banco de dados //
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Início da classe de conexão//
public class DAOGeral {

    public static String status = "Sem conexão...";
    private static Connection conn = null;  //atributo do tipo Connection
    private static final String dbName = "db_proj"; //Nome do Banco de Dados

    //Método Construtor da Classe//
    public DAOGeral() {

    }

    //Método de Conexão//
    public static Connection getConexaoMySQL() {

        try {

            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

// Configurando a nossa conexão com um banco de dados//
            String serverName = "localhost";    //caminho do servidor do BD

            String url = "jdbc:mysql://" + serverName + "/" + dbName;

            String username = "root";        //nome de um usuário de seu BD      

            String password = "root";      //sua senha de acesso

            conn = DriverManager.getConnection(url, username, password);

            //Testa sua conexão//  
            if (conn != null) {

                status = ("STATUS: Conectado com sucesso!");

            } else {

                status = ("STATUS: Não foi possivel realizar conexão");

            }

            return conn;

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
    public static boolean fecharConexao() {

        try {
            DAOGeral.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    //Método que reinicia sua conexão//
    public static java.sql.Connection ReiniciarConexao() {

        fecharConexao();

        return DAOGeral.getConexaoMySQL();

    }

    //Método para criar o banco
    public static boolean criarBanco() {
        try {
            
            //Usuário e senha estão escritos na string de conexão:
            conn = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=root");
            Statement s = conn.createStatement();
            String execUptString = "CREATE DATABASE " + dbName;
            s.executeUpdate(execUptString);
            status = "STATUS: Banco de dados criado";
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            //fecharConexao();

            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception ex) {
                }
            }
            /* //Fechando ResultStatement
        if (rs != null) { try { rs.close() } catch (Exception ex) { } }
        if (pst != null) { try { st.close() } catch (Exception ex) { } }
             */

        }
    }

    //Método para criar tabelas
    public static Connection criarTabelas() {

        //Criando tabela de clientes;
        String tabelaCliente = "CREATE TABLE tb_cliente( "
                + "idCliente INT(64) NOT NULL AUTO_INCREMENT PRIMARY KEY , "
                + "nomeCliente VARCHAR(100),"
                + "sobrenomeCliente VARCHAR(100),"
                + "telefoneCliente INT,";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(tabelaCliente);
            System.out.println("Tabela criada!");
            return conn;
        } catch (SQLException e) {
            return conn;
        } finally {
            fecharConexao();
        }
    }

    //Main para executar a criação do banco e tabelas
    public static void main(String[] args) {
        //getConexaoMySQL();
        criarBanco();
        criarTabelas();
        System.out.println(statusConection());
        fecharConexao();
    }
}

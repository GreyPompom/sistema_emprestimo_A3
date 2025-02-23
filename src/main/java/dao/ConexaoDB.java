
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    public static Connection getConexao() {
        Connection connection = null; 
        try {
           
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            
            // Configurar a conexão
            String server = "localhost"; // Caminho do MySQL
            String database = "db_emprestimos"; // Nome do banco de dados
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root"; // Usuário do banco de dados
            String password = "Morango358017#"; // Senha do banco de dados

            // Estabelecer a conexão
            connection = DriverManager.getConnection(url, user, password);

            // Testar a conexão
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }

            return connection;

        } catch (ClassNotFoundException e) { // Exceção para driver não encontrado
            System.out.println("O driver não foi encontrado. " + e.getMessage());
            return null;

        } catch (SQLException e) { // Exceção para erro de conexão com o banco
            System.out.println("Não foi possível conectar...");
            return null;
        }
    }
}
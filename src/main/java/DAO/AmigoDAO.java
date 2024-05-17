
package DAO;

import model.Amigo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class AmigoDAO {
     public static ArrayList<Amigo> MinhaLista = new ArrayList<>();

    public AmigoDAO() {
    }
     
     //esse metodo serve para pegar o maior e ultimo id cadastrado no banco

    public int pegaMaiorID() throws SQLException {
        int maior = 0;
        try {
            try (Statement stmt = this.getConexao().createStatement()) {
                ResultSet res = stmt.executeQuery("SELECT MAX(id_amigo) id_amigo FROM amigos");
                res.next();
                maior = res.getInt("id_amigo");
            }
        } catch (SQLException ex) {
        }
        return maior;
    }
    
    public Connection getConexao() {
        Connection connection = null;  //inst�ncia da conex�o
        try {
            // Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            // Configurar a conex�o
            String server = "localhost"; //caminho do MySQL
            String database = "db_emprestimos";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "Morango358017#";
            connection = DriverManager.getConnection(url, user, password);
            // Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }

            return connection;

        } catch (ClassNotFoundException e) {  //excessao driver do mysql connector nao encontrado, baixar o mesmo no google, mysqlconnector for java
            System.out.println("O driver nao foi encontrado. " + e.getMessage());
            return null;

        } catch (SQLException e) { //erro de coneção com o banco 
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }
    
    
     public ArrayList getMinhaLista() {
        MinhaLista.clear();
        //imporatnte limpar a lista antes de dar um get pq caso tenhamos dado um 
        //insert/update novo no banco atualizamos ela certinho
        try {
            //tenta pegar a lista
              System.out.println("Entrou aqui");
            Statement conecaozinha = this.getConexao().createStatement();
            ResultSet resposta = conecaozinha.executeQuery("SELECT * FROM amigos");
            while (resposta.next()) {
                int id = resposta.getInt("id_amigo");
                String nome = resposta.getString("nome");
                String telefone = resposta.getString("telefone");

                Amigo objeto = new Amigo(id, nome, telefone);
                MinhaLista.add(objeto);
            }

            conecaozinha.close();
        } catch (SQLException ex) {
            //caso de erro
        }
        return MinhaLista;
    }
     public boolean InserirAmigoBD(Amigo objeto) {
        String sql = "INSERT INTO amigos(id_amigo, nome, telefone) VALUES(?,?,?)";
        try {
            try (PreparedStatement stmt = this.getConexao().prepareStatement(sql)) {
                stmt.setInt(1, objeto.getId());
                stmt.setString(2, objeto.getNome());
                stmt.setString(3, objeto.getTelefone());
                stmt.execute();
            }
            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
     
      public boolean DeletaAmigoBD(int id) {
        try (Statement stmt = this.getConexao().createStatement()) {
            stmt.executeUpdate("DELETE FROM amigos WHERE id_amigo = " + id);
            stmt.close();
        } catch (SQLException erro) {
        }
        return true;
    }
    
    public boolean AtualizarAmigo(Amigo objeto) {
        String sintaxe = "UPDATE amigos set nome = ? ,marca = ?  WHERE id = ?";

        try (PreparedStatement stmt = this.getConexao().prepareStatement(sintaxe)) {
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getTelefone());
            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
    
     public Amigo carregaAmigo(int id) {
        Amigo objeto = new Amigo(); //cria o objeto
        objeto.setId(id); //seta o id recebido por parametro para o objeto
        //executa nossa query
        try (Statement stmt = this.getConexao().createStatement()) {
            //executa nossa query
            ResultSet resposta = stmt.executeQuery("SELECT * FROM amigos WHERE id_amigo = " + id);
            resposta.next();
            objeto.setNome(resposta.getString("nome"));
            objeto.setTelefone(resposta.getString("telefone"));

        } catch (SQLException erro) {
        }
        return objeto;
    }
}


package dao;

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
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (Statement stmt = conexao.createStatement()) {
                    ResultSet res = stmt.executeQuery("SELECT MAX(id_amigo) id_amigo FROM amigos");
                    res.next();
                    maior = res.getInt("id_amigo");
                }
            }
        } catch (SQLException ex) {
        }
        return maior;
    }

    public ArrayList getMinhaLista() {
        MinhaLista.clear();
        //imporatnte limpar a lista antes de dar um get pq caso tenhamos dado um 
        //insert/update novo no banco atualizamos ela certinho
        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                Statement conecaozinha = conexao.createStatement();
                ResultSet resposta = conecaozinha.executeQuery("SELECT * FROM amigos");
                while (resposta.next()) {
                    int id = resposta.getInt("id_amigo");
                    String nome = resposta.getString("nome");
                    String telefone = resposta.getString("telefone");

                    Amigo objeto = new Amigo(id, nome, telefone);
                    MinhaLista.add(objeto);
                }
                conecaozinha.close();
            }

        } catch (SQLException ex) {
            //caso de erro
        }
        return MinhaLista;
    }

    public boolean InserirAmigoBD(Amigo objeto) {
        String sql = "INSERT INTO amigos(nome, telefone) VALUES(?, ?)";
        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setString(1, objeto.getNome());
                    stmt.setString(2, objeto.getTelefone());
                    stmt.execute();
                }
                return true;
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return false;
    }

    public boolean DeletaAmigoBD(int id) {
        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (Statement stmt = conexao.createStatement()) {
                    stmt.executeUpdate("DELETE FROM amigos WHERE id_amigo = " + id);
                    stmt.close();
                }
            }
        } catch (SQLException erro) {
        }
        return true;
    }

    public boolean AtualizarAmigo(Amigo objeto) {
        String sintaxe = "UPDATE amigos SET nome = ?, telefone = ? WHERE id_amigo = ?";
        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (PreparedStatement stmt = conexao.prepareStatement(sintaxe)) {
                    stmt.setString(1, objeto.getNome());
                    stmt.setString(2, objeto.getTelefone());
                    stmt.setInt(3, objeto.getId());
                    int linhasAfetadas = stmt.executeUpdate();
                    return linhasAfetadas > 0;
                }
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return false;
    }

    public Amigo carregaAmigo(int id) {
        Amigo objeto = new Amigo(); //cria o objeto
        objeto.setId(id); //seta o id recebido por parametro para o objeto
        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (Statement stmt = conexao.createStatement()) {
                    //executa nossa query
                    ResultSet resposta = stmt.executeQuery("SELECT * FROM amigos WHERE id_amigo = " + id);
                    resposta.next();
                    objeto.setNome(resposta.getString("nome"));
                    objeto.setTelefone(resposta.getString("telefone"));
                }
            }
        } catch (SQLException erro) {
              throw new RuntimeException(erro);
        }
        return objeto;
    }
}

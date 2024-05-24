package dao;

import model.Ferramenta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FerramentaDAO {

    public static ArrayList<Ferramenta> MinhaLista = new ArrayList<>();

    public FerramentaDAO() {

    }
    //esse metodo serve para pegar o maior e ultimo id cadastrado no banco

    public int pegaMaiorID() throws SQLException {
        int maior = 0;
        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (Statement stmt = conexao.createStatement()) {
                    ResultSet res = stmt.executeQuery("SELECT MAX(id_ferramenta) id_ferramenta FROM ferramentas");
                    res.next();
                    maior = res.getInt("id_ferramenta");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maior;

    }

    public ArrayList getMinhaLista() {
        MinhaLista.clear();
        //imporatnte limpar a lista antes de dar um get pq caso tenhamos dado um 
        //insert/update novo no banco atualizamos ela certinho
        try {
            //tenta pegar a lista
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {

                Statement conecaozinha = conexao.createStatement();
                ResultSet resposta = conecaozinha.executeQuery("SELECT * FROM ferramentas");
                while (resposta.next()) {
                    int id = resposta.getInt("id_ferramenta");
                    String nome = resposta.getString("nome");
                    String marca = resposta.getString("marca");
                    double custo = resposta.getDouble("custo_aquisicao");
                    boolean status = resposta.getBoolean("status");

                    Ferramenta objeto = new Ferramenta(id, nome, marca, custo, status);
                    MinhaLista.add(objeto);
                }
                conecaozinha.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return MinhaLista;
    }

    //esse carinha aqui insere uma nova ferramenta no banco
    public boolean inserirFerramentaBD(Ferramenta objeto) {
        String sql = "INSERT INTO ferramentas(id_ferramenta,nome,marca,custo_aquisicao, status) VALUES(?,?,?,?,?)";
        try {
            System.out.println(objeto.getCusto());
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(1, objeto.getId());
                    stmt.setString(2, objeto.getNome());
                    stmt.setString(3, objeto.getMarca());
                    stmt.setDouble(4, objeto.getCusto());
                    stmt.setBoolean(5, false);
                    stmt.execute();
                }
            }
            return true;
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    //como o nome já diz ele serve para deleta, precisa passar apena os id.
    public boolean deletaFerramentaBD(int id) {
        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (Statement stmt = conexao.createStatement()) {
                    stmt.executeUpdate("DELETE FROM ferramentas WHERE id_ferramenta = " + id);
                    stmt.close();
                }
            }
        } catch (SQLException erro) {
        }
        return true;
    }

    //atualiza ferramenta, passar obejto com as infos atualizadas.
    public boolean atualizarFerramenta(Ferramenta objeto) {
        String sql = "UPDATE ferramentas SET nome = ?, marca = ?, custo_aquisicao = ?, status = ? WHERE id_ferramenta = ?";
        try {
            // Obtendo a conexão do banco de dados
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                // Preparando o comando SQL com os parâmetros
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setString(1, objeto.getNome());
                    stmt.setString(2, objeto.getMarca());
                    stmt.setDouble(3, objeto.getCusto());
                    stmt.setBoolean(4, objeto.isStatus());
                    stmt.setInt(5, objeto.getId());

                    // Executando a atualização e verificando o número de linhas afetadas
                    int linhasAfetadas = stmt.executeUpdate();
                    return linhasAfetadas > 0;
                }
            } else {
                return false; // Conexão falhou
            }
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao atualizar ferramenta: " + erro.getMessage(), erro);
        }
    }

    public Ferramenta carregaFerramenta(int id) {
        Ferramenta objeto = new Ferramenta(); //cria o objeto
        objeto.setId(id); //seta o id recebido por parametro para o objeto
        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (Statement stmt = conexao.createStatement()) {
                    //executa nossa query
                    ResultSet resposta = stmt.executeQuery("SELECT * FROM ferramentas WHERE id_ferramenta = " + id);
                    resposta.next();
                    objeto.setNome(resposta.getString("nome"));
                    objeto.setMarca(resposta.getString("marca"));
                    objeto.setCusto(resposta.getDouble("custo_aquisicao"));

                }
            }
        } //executa nossa query
        catch (SQLException erro) {
        }
        return objeto;
    }
}

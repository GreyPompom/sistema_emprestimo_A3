
package DAO;

import Model.Ferramenta;
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
            try (Statement stmt = this.getConexao().createStatement()) {
                ResultSet res = stmt.executeQuery("SELECT MAX(id_ferramenta) id_ferramenta FROM tb_ferramentas");
                res.next();
                maior = res.getInt("id_ferramenta");
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
            String password = "Senha";
            connection = DriverManager.getConnection(url, user, password);
            // Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: N�O CONECTADO!");
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
        } catch (SQLException ex) {
            //caso de erro
        }
        return MinhaLista;
    }

    //esse carinha aqui inseri uma nova ferramenta no banco
    public boolean InserirFerramentaBD(Ferramenta objeto) {
        String sql = "INSERT INTO ferramentas(id_ferramenta,nome,marca,custo_aquisicao, status) VALUES(?,?,?,?)";
        try {
            System.out.println(objeto.getCusto());
            try (PreparedStatement stmt = this.getConexao().prepareStatement(sql)) {
                stmt.setInt(1, objeto.getId());
                stmt.setString(2, objeto.getNome());
                stmt.setString(3, objeto.getMarca());
                stmt.setDouble(4, objeto.getCusto());
                stmt.setBoolean(0, false);
                stmt.execute();
            }
            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    //como o nome já diz ele serve para deleta, precisa passar apena os id.
    public boolean DeletaFerramentaBD(int id) {
        try (Statement stmt = this.getConexao().createStatement()) {
            stmt.executeUpdate("DELETE FROM ferramentas WHERE id_ferramenta = " + id);
            stmt.close();
        } catch (SQLException erro) {
        }
        return true;
    }

    //atualiza ferramenta, passar obejto com as infos atualizadas.
    public boolean AtualizarFerramenta(Ferramenta objeto) {
        String sintaxe = "UPDATE ferramentas set nome = ? ,marca =? , custo_aquisicao  WHERE id = ?";

        try (PreparedStatement stmt = this.getConexao().prepareStatement(sintaxe)) {
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getMarca());
            stmt.setDouble(4, objeto.getCusto());
            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public Ferramenta carregaAluno(int id) {
        Ferramenta objeto = new Ferramenta(); //cria o objeto
        objeto.setId(id); //seta o id recebido por parametro para o objeto
        
        //executa nossa query
        
        try (Statement stmt = this.getConexao().createStatement()) {
            //executa nossa query
            ResultSet resposta = stmt.executeQuery("SELECT * FROM ferramentas WHERE id_ferramenta = " + id);
            resposta.next();
            objeto.setNome(resposta.getString("nome"));
            objeto.setMarca(resposta.getString("marca"));
            objeto.setCusto(resposta.getDouble("custo_aquisicao"));

        } catch (SQLException erro) {
        }
        return objeto;
    }
}

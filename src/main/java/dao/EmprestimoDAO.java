package dao;

import model.Emprestimo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Enumo.StatusEmprestimo;
import model.Ferramenta;

public class EmprestimoDAO {

    private static final EmprestimoDAO instance = new EmprestimoDAO();

    public EmprestimoDAO() {
    }

    public static EmprestimoDAO getInstance() {
        return instance;
    }

    public boolean salvarEmprestimo(Emprestimo emprestimo) {
        Connection conexaozinha = null;
        PreparedStatement pstmtEmprestimo = null;
        PreparedStatement pstmtFerramentasEmprestadas = null;
        PreparedStatement pstmtFerramentas = null;
        ResultSet generatedKeys = null;

        try {
            conexaozinha = ConexaoDB.getConexao();

            // Iniciar transação
            conexaozinha.setAutoCommit(false);

            // Insira o empréstimo na tabela 'emprestimos'
            String sqlEmprestimo = "INSERT INTO emprestimos (id_amigo, data_emprestimo, data_devolucao, status) VALUES (?, ?, ?, ?)";
            pstmtEmprestimo = conexaozinha.prepareStatement(sqlEmprestimo, Statement.RETURN_GENERATED_KEYS);
            pstmtEmprestimo.setInt(1, emprestimo.getIdAmigo());
            pstmtEmprestimo.setDate(2, emprestimo.getDataInicial());
            pstmtEmprestimo.setDate(3, emprestimo.getDataDevolucao());
            pstmtEmprestimo.setInt(4, StatusEmprestimo.ABERTO.ordinal() + 1); // Status inicial como ABERTO

            int affectedRows = pstmtEmprestimo.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao inserir o empréstimo, nenhuma linha afetada.");
            }

            // Obter o ID do empréstimo inserido
            generatedKeys = pstmtEmprestimo.getGeneratedKeys();
            int idEmprestimo = 0;
            if (generatedKeys.next()) {
                idEmprestimo = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Falha ao inserir o empréstimo, ID não obtido.");
            }

            String sqlFerramentasEmprestadas = "INSERT INTO ferramentas_emprestadas (id_emprestimo, id_ferramenta) VALUES (?, ?)";
            pstmtFerramentasEmprestadas = conexaozinha.prepareStatement(sqlFerramentasEmprestadas);

            for (Ferramenta ferramenta : emprestimo.getFerramentasSelecionadas()) {
                pstmtFerramentasEmprestadas.setInt(1, idEmprestimo);
                pstmtFerramentasEmprestadas.setInt(2, ferramenta.getId());
                pstmtFerramentasEmprestadas.addBatch();
            }

            pstmtFerramentasEmprestadas.executeBatch();

            String sqlAtualizaFerramenta = "UPDATE ferramentas SET status = ? WHERE id_ferramenta = ?";
            pstmtFerramentas = conexaozinha.prepareStatement(sqlAtualizaFerramenta);

            for (Ferramenta ferramenta : emprestimo.getFerramentasSelecionadas()) {
                
                pstmtFerramentas.setBoolean(1, false); // Supondo que 'false' significa que a ferramenta não está disponível
                System.out.print(ferramenta.getId());
                pstmtFerramentas.setInt(2, ferramenta.getId());
                pstmtFerramentas.addBatch();
            }
            pstmtFerramentas.executeBatch();

            conexaozinha.commit();
            return true;

        } 
        catch (SQLException e) {
            e.printStackTrace();
            if (conexaozinha != null) {
                try {
                    conexaozinha.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;

        } 
        finally {
            // Fechar recursos
            try {
                if (generatedKeys != null) {
                    generatedKeys.close();
                }
                if (pstmtEmprestimo != null) {
                    pstmtEmprestimo.close();
                }
                if (pstmtFerramentasEmprestadas != null) {
                    pstmtFerramentasEmprestadas.close();
                }
                if (pstmtFerramentas != null) {
                    pstmtFerramentas.close();
                }
                if (conexaozinha != null) {
                    conexaozinha.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean atualizarEmprestimo(Emprestimo emprestimo) {
        String sql = "UPDATE emprestimos SET  id_amigo = ?, data_inicial = ?, data_devolucao = ? WHERE id_emprestimo = ?";
        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(2, emprestimo.getIdAmigo());
                    stmt.setDate(3, emprestimo.getDataInicial());
                    stmt.setDate(5, emprestimo.getDataDevolucao());
                    stmt.setInt(6, emprestimo.getIdEmprestimo());
                    stmt.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return false;
    }

    public boolean deletarEmprestimo(int idEmprestimo) {
        String sql = "DELETE FROM emprestimos WHERE id_emprestimo = ?";
        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(1, idEmprestimo);
                    stmt.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return false;
    }

    public ArrayList<Emprestimo> listarEmprestimos() {
        ArrayList<Emprestimo> lista = new ArrayList<>();
        String sql = "SELECT * FROM emprestimos";
        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        Emprestimo emprestimo = new Emprestimo();
                        emprestimo.setIdEmprestimo(rs.getInt("id_emprestimo"));
                        emprestimo.setIdAmigo(rs.getInt("id_amigo"));
                        emprestimo.setDataInicial(rs.getDate("data_inicial"));
                        emprestimo.setDataDevolucao(rs.getDate("data_devolucao"));
                        lista.add(emprestimo);
                    }
                }
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return lista;
    }
}

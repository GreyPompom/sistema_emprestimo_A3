package dao;

import model.Emprestimo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmprestimoDAO {
    
    private static final EmprestimoDAO instance = new EmprestimoDAO();

    private EmprestimoDAO() {
    }

    public static EmprestimoDAO getInstance() {
        return instance;
    }

    public boolean inserirEmprestimo(Emprestimo emprestimo) {
        String sql = "INSERT INTO emprestimos ( id_amigo, data_inicial, data_devolucao) VALUES ( ?, ?, ?)";
        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(2, emprestimo.getIdAmigo());
                    stmt.setDate(3, emprestimo.getDataEmprestimo());
                    stmt.setDate(5, emprestimo.getDataDevolucao());
                    stmt.execute();
                    return true;
                }
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return false;
    }

    public boolean atualizarEmprestimo(Emprestimo emprestimo) {
        String sql = "UPDATE emprestimos SET  id_amigo = ?, data_inicial = ?, data_devolucao = ? WHERE id_emprestimo = ?";
        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(2, emprestimo.getIdAmigo());
                    stmt.setDate(3, emprestimo.getDataEmprestimo());
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
                try (Statement stmt = conexao.createStatement();
                     ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        Emprestimo emprestimo = new Emprestimo();
                        emprestimo.setIdEmprestimo(rs.getInt("id_emprestimo"));
                        emprestimo.setIdAmigo(rs.getInt("id_amigo"));
                        emprestimo.setDataEmprestimo(rs.getDate("data_inicial"));
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

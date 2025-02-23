package dao;

import dao.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Amigo;
import model.Emprestimo;
import model.Enumo.StatusEmprestimo;

public class RelatorioDAO {

    public int totalFerramentasEmprestadas() {
        String sql = "SELECT COUNT(*) AS totalFerramentasEmprestadas FROM ferramentas_emprestadas";
        try (Connection conexao = ConexaoDB.getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("totalFerramentasEmprestadas");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public int totalEmprestimosAbertos() {
        String sql = "SELECT COUNT(*) AS totalEmprestimosAbertos FROM emprestimos WHERE status = 1";
        try (Connection conexao = ConexaoDB.getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("totalEmprestimosAbertos");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public int totalAmigosEmprestimosAbertos() {
        String sql = "SELECT COUNT(DISTINCT id_amigo) AS totalAmigosEmprestimosAbertos FROM emprestimos WHERE status = 1";
        try (Connection conexao = ConexaoDB.getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("totalAmigosEmprestimosAbertos");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public int totalEmprestimosPendentes() {
        String sql = "SELECT COUNT(*) AS totalEmprestimosPendentes FROM emprestimos WHERE status = 3";
        try (Connection conexao = ConexaoDB.getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("totalEmprestimosPendentes");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public ArrayList<Emprestimo> relatorioEmprestimosAtivos() {
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM emprestimos WHERE status = 1";
        try (Connection conexao = ConexaoDB.getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setIdEmprestimo(rs.getInt("id_emprestimo"));
                emprestimo.setIdAmigo(rs.getInt("id_amigo"));
                emprestimo.setDataInicial(rs.getDate("data_emprestimo"));
                emprestimo.setDataDevolucao(rs.getDate("data_devolucao"));
                emprestimo.setStatus(StatusEmprestimo.fromCodigo(rs.getInt("status")));
                emprestimos.add(emprestimo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return emprestimos;
    }
    
    public ArrayList<Emprestimo> relatorioEmprestimosNaoDevolvidos() {
    ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    String sql = "SELECT * FROM emprestimos WHERE status = 3";
    try (Connection conexao = ConexaoDB.getConexao();
         PreparedStatement stmt = conexao.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setIdEmprestimo(rs.getInt("id_emprestimo"));
            emprestimo.setIdAmigo(rs.getInt("id_amigo"));
            emprestimo.setDataInicial(rs.getDate("data_emprestimo"));
            emprestimo.setDataDevolucao(rs.getDate("data_devolucao"));
            emprestimo.setStatus(StatusEmprestimo.fromCodigo(rs.getInt("status")));
            emprestimos.add(emprestimo);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return emprestimos;
}
    public int relatorioQuemFezMaisEmprestimos() {
    int id_amigo =0;
    String sql = "SELECT id_amigo, COUNT(*) AS totalEmprestimos FROM emprestimos GROUP BY id_amigo ORDER BY totalEmprestimos DESC";
    try (Connection conexao = ConexaoDB.getConexao();
         PreparedStatement stmt = conexao.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
           
           id_amigo =  rs.getInt("id_amigo");
           
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return id_amigo;
}
    

}

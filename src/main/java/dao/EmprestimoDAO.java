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

        } catch (SQLException e) {
            e.printStackTrace();
            if (conexaozinha != null) {
                try {
                    conexaozinha.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;

        } finally {
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
        String sql = "UPDATE emprestimos SET  id_amigo = ?, data_emprestimo = ?, data_devolucao = ?, status =? WHERE id_emprestimo = ?";
        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(1, emprestimo.getIdAmigo());
                    stmt.setDate(2, emprestimo.getDataInicial());
                    stmt.setDate(3, emprestimo.getDataDevolucao());
                    System.out.println(emprestimo.getStatus().getCodigo());
                    stmt.setInt(4, emprestimo.getStatus().getCodigo());
                    stmt.setInt(5, emprestimo.getIdEmprestimo());
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
        String sqlDeleteEmprestimo = "DELETE FROM emprestimos WHERE id_emprestimo = ?";
        String sqlDeleteFerramentas = "DELETE FROM ferramentas_emprestadas WHERE id_emprestimo = ?";
        boolean sucesso = false;

        try (Connection conexao = ConexaoDB.getConexao(); PreparedStatement stmtDeleteEmprestimo = conexao.prepareStatement(sqlDeleteEmprestimo); PreparedStatement stmtDeleteFerramentas = conexao.prepareStatement(sqlDeleteFerramentas)) {

            // Inicia a transação
            conexao.setAutoCommit(false);

            // Deleta as ferramentas associadas ao empréstimo
            stmtDeleteFerramentas.setInt(1, idEmprestimo);
            stmtDeleteFerramentas.executeUpdate();

            // Deleta o empréstimo
            stmtDeleteEmprestimo.setInt(1, idEmprestimo);
            int linhasAfetadas = stmtDeleteEmprestimo.executeUpdate();
            if (linhasAfetadas > 0) {
                // Se pelo menos uma linha foi excluída, confirma a transação
                conexao.commit();
                sucesso = true;
            }
        } catch (SQLException erro) {
            // Em caso de erro, faz rollback para desfazer qualquer alteração na transação
            throw new RuntimeException(erro);
        }

        return sucesso;
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
                        emprestimo.setDataInicial(rs.getDate("data_emprestimo"));
                        emprestimo.setDataDevolucao(rs.getDate("data_devolucao"));
                        int statusInt = rs.getInt("status");
                        StatusEmprestimo status;
                        switch (statusInt) {
                            case 1:
                                status = StatusEmprestimo.ABERTO;
                                break;
                            case 2:
                                status = StatusEmprestimo.FECHADO;
                                break;
                            case 3:
                                status = StatusEmprestimo.EM_ATRASO;
                                break;
                            default:
                                // Trate o caso de valor inválido, se necessário
                                status = StatusEmprestimo.ABERTO; // Ou outro valor padrão
                                break;
                        }
                        emprestimo.setStatus(status);
                        lista.add(emprestimo);
                    }
                }
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return lista;
    }

    public int qtdFerremantas(int id) {
        int qtd = 0;
        String sql = "Select count(*) from ferramentas_emprestadas where id_emprestimo = ? ";

        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(1, id);
                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            qtd = rs.getInt(1);
                        }
                    }
                }
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return qtd;
    }

    public Emprestimo carregaEmprestimo(int id) {
        System.out.print("ENtrou para pegar os dados");
        Emprestimo objeto = new Emprestimo(); //cria o objeto
        objeto.setIdEmprestimo(id); //seta o id recebido por parametro para o objeto
        try {
            Connection conexao = ConexaoDB.getConexao();
            if (conexao != null) {
                try (Statement stmt = conexao.createStatement()) {
                    //executa nossa query
                    ResultSet resposta = stmt.executeQuery("SELECT * FROM Emprestimos WHERE id_emprestimo = " + id);
                    resposta.next();
                    objeto.setIdAmigo(resposta.getInt("id_amigo"));
                    objeto.setDataInicial(resposta.getDate("data_emprestimo"));
                    objeto.setDataDevolucao(resposta.getDate("data_devolucao"));
                    int statusInt = resposta.getInt("status");
                    StatusEmprestimo status;
                    switch (statusInt) {
                        case 1:
                            status = StatusEmprestimo.ABERTO;
                            break;
                        case 2:
                            status = StatusEmprestimo.FECHADO;
                            break;
                        case 3:
                            status = StatusEmprestimo.EM_ATRASO;
                            break;
                        default:
                            // Trate o caso de valor inválido, se necessário
                            status = StatusEmprestimo.ABERTO; // Ou outro valor padrão
                            break;
                    }

                    objeto.setStatus(status);

                    // Obtém as ferramentas emprestadas para um determinado empréstimo
                    ResultSet resultado = stmt.executeQuery("SELECT * FROM ferramentas_emprestadas WHERE id_emprestimo = " + id);
                    ArrayList<Ferramenta> ferramentasLista = new ArrayList<>();
                    while (resultado.next()) {
                        int idFerramenta = resultado.getInt("id_ferramenta");

                        // Use um novo Statement para a segunda consulta
                        Statement ferramentaStmt = conexao.createStatement();
                        ResultSet ferramentaRs = ferramentaStmt.executeQuery("SELECT * FROM ferramentas WHERE id_ferramenta = " + idFerramenta);

                        if (ferramentaRs.next()) {
                            Ferramenta ferramenta = new Ferramenta();
                            ferramenta.setId(ferramentaRs.getInt("id_ferramenta"));
                            ferramenta.setNome(ferramentaRs.getString("nome"));
                            ferramenta.setMarca(ferramentaRs.getString("marca"));
                            ferramenta.setCusto(ferramentaRs.getDouble("custo_aquisicao"));
                            ferramenta.setStatus(ferramentaRs.getBoolean("status"));
                            ferramentasLista.add(ferramenta);
                        }
                        ferramentaRs.close();
                        ferramentaStmt.close();
                    }
                    resultado.close();
                    objeto.setFerramentasSelecionadas(ferramentasLista);

                }
            }
        } //executa nossa query
        catch (SQLException erro) {
        }
        return objeto;
    }

    public ArrayList<Ferramenta> pegaFerramentasEmprestimo(int idEmprestimo) {
        ArrayList<Ferramenta> ferramentasLista = new ArrayList<>();
        String sqlFerramentasEmprestadas = "SELECT id_ferramenta FROM ferramentas_emprestadas WHERE id_emprestimo = ?";
        String sqlFerramenta = "SELECT * FROM ferramentas WHERE id_ferramenta = ?";

        try (Connection conexao = ConexaoDB.getConexao(); PreparedStatement stmtFerramentasEmprestadas = conexao.prepareStatement(sqlFerramentasEmprestadas); PreparedStatement stmtFerramenta = conexao.prepareStatement(sqlFerramenta)) {

            stmtFerramentasEmprestadas.setInt(1, idEmprestimo);
            try (ResultSet resultado = stmtFerramentasEmprestadas.executeQuery()) {
                while (resultado.next()) {
                    int idFerramenta = resultado.getInt("id_ferramenta");
                    stmtFerramenta.setInt(1, idFerramenta);

                    try (ResultSet ferramentaRs = stmtFerramenta.executeQuery()) {
                        if (ferramentaRs.next()) {
                            Ferramenta ferramenta = new Ferramenta();
                            ferramenta.setId(ferramentaRs.getInt("id_ferramenta"));
                            ferramenta.setNome(ferramentaRs.getString("nome"));
                            ferramenta.setMarca(ferramentaRs.getString("marca"));
                            ferramenta.setCusto(ferramentaRs.getDouble("custo_aquisicao"));
                            ferramenta.setStatus(ferramentaRs.getBoolean("status"));
                            ferramentasLista.add(ferramenta);
                        }
                    }
                }
            }

        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao recuperar ferramentas do empréstimo: " + erro.getMessage(), erro);
        }

        return ferramentasLista;
    }

    public boolean deletarEmprestimoAmigo(int id_amigo) {
        String sqlSelectEmprestimos = "SELECT id_emprestimo FROM emprestimos WHERE id_amigo = ?";
        String sqlDeleteEmprestimos = "DELETE FROM emprestimos WHERE id_amigo = ?";
        String sqlDeleteFerramentasEmprestadas = "DELETE FROM ferramentas_emprestadas WHERE id_emprestimo = ?";
        String sqlUpdateFerramentas = "UPDATE ferramentas SET status = true WHERE id_ferramenta IN (SELECT id_ferramenta FROM ferramentas_emprestadas WHERE id_emprestimo = ?)";
        boolean sucesso = false;
        Connection conexao = ConexaoDB.getConexao();

        try (
                PreparedStatement stmtSelectEmprestimos = conexao.prepareStatement(sqlSelectEmprestimos); PreparedStatement stmtDeleteEmprestimos = conexao.prepareStatement(sqlDeleteEmprestimos); PreparedStatement stmtDeleteFerramentasEmprestadas = conexao.prepareStatement(sqlDeleteFerramentasEmprestadas); PreparedStatement stmtUpdateFerramentas = conexao.prepareStatement(sqlUpdateFerramentas)) {

            // Inicia a transação
            conexao.setAutoCommit(false);

            // Busca todos os empréstimos do amigo
            stmtSelectEmprestimos.setInt(1, id_amigo);
            ResultSet rsEmprestimos = stmtSelectEmprestimos.executeQuery();
            int idEmprestimo = 0;
            // Itera sobre cada empréstimo
            while (rsEmprestimos.next()) {
                idEmprestimo = rsEmprestimos.getInt("id_emprestimo");

                // Deleta as ferramentas_emprestadas associadas a este empréstimo
                stmtDeleteFerramentasEmprestadas.setInt(1, idEmprestimo);
                stmtDeleteFerramentasEmprestadas.executeUpdate();
                // Atualiza o status das ferramentas associadas para verdadeiro
                stmtUpdateFerramentas.setInt(1, idEmprestimo);
                stmtUpdateFerramentas.executeUpdate();
            }

            // Deleta os empréstimos do amigo
            stmtDeleteEmprestimos.setInt(1, id_amigo);
            int linhasAfetadas = stmtDeleteEmprestimos.executeUpdate();
            if (linhasAfetadas > 0) {
                // Se pelo menos uma linha foi excluída, confirma a transação
                conexao.commit();
                sucesso = true;
            } else {
                conexao.rollback();
            }
        } catch (SQLException erro) {
            // Em caso de erro, faz rollback para desfazer qualquer alteração na transação
            try {
                if (conexao != null) {
                    conexao.rollback();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            throw new RuntimeException(erro);
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return sucesso;
    }

}

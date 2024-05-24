package model;


import dao.EmprestimoDAO;
import java.sql.Date;
import java.time.LocalDate;
import model.Amigo;
import model.Ferramenta;

public class Emprestimo {
    private Integer idEmprestimo;
    private Integer idAmigo;
    private Date  dataInicial;
    private Date  dataDevolucao;
    private Amigo amigo;
    private Ferramenta ferramenta;

    private static final EmprestimoDAO DAO = EmprestimoDAO.getInstance();
  
    public Emprestimo() {
        this.idEmprestimo = null;
        this.idAmigo = null;
        this.dataInicial = null;
        this.dataDevolucao = null;
        this.amigo = new Amigo();
        this.ferramenta = new Ferramenta();
    }

    public Emprestimo( Integer idAmigo, Date dataInicial) {
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
    }

    public Emprestimo( Integer idAmigo, Date dataInicial,
    Date dataDevolucao) {
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo(Integer id, Integer idAmigo, Date  dataInicial, 
    Date  dataDevolucao) {
        this.idEmprestimo = id;
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo(Integer id, Integer idAmigo, Date  dataInicial, 
    Date  dataDevolucao, Amigo amigo, Ferramenta ferramenta) {
        this.idEmprestimo = id;
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataDevolucao = dataDevolucao;
        this.amigo = amigo;
        this.ferramenta = ferramenta;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    public Date getDataEmprestimo() {
        return dataInicial;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataInicial = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    
}

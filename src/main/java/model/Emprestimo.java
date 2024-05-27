package model;


import dao.EmprestimoDAO;
import java.awt.List;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Amigo;
import model.Ferramenta;
import model.Enumo.StatusEmprestimo;
import com.toedter.calendar.JDateChooser;


public class Emprestimo {
    private Integer idEmprestimo;
    private Integer idAmigo;
    private Date  dataInicial;
    private Date  dataDevolucao;
    private StatusEmprestimo status;
    private Amigo amigo;
    private Ferramenta ferramenta;
    private ArrayList<Ferramenta> ferramentasSelecionadas;
    private final EmprestimoDAO dao;
  


    // Construtor padrão
    public Emprestimo() {
        this.ferramentasSelecionadas = new ArrayList<>();
        this.dao = new EmprestimoDAO();
    }

    // Construtor com parâmetros
    public Emprestimo( Integer idAmigo, Date dataInicial, Date dataDevolucao, StatusEmprestimo status, ArrayList<Ferramenta> ferramentasSelecionadas){
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.ferramentasSelecionadas = ferramentasSelecionadas != null ? ferramentasSelecionadas : new ArrayList<>();
        this.dao = null;
    }
    public Emprestimo( Integer idAmigo, Date dataInicial, Date dataDevolucao, ArrayList<Ferramenta> ferramentasSelecionadas){
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataDevolucao = dataDevolucao;
        this.ferramentasSelecionadas = ferramentasSelecionadas != null ? ferramentasSelecionadas : new ArrayList<>();
        this.dao = null;
    }
    public Emprestimo(Integer idEmprestimo, Integer idAmigo, Date dataInicial, Date dataDevolucao, StatusEmprestimo status){
        this.idEmprestimo = idEmprestimo;
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.dao = null;
    }
    
    public Emprestimo(Integer idEmprestimo, Integer idAmigo, Date dataInicial, Date dataDevolucao, StatusEmprestimo status, Amigo amigo, ArrayList<Ferramenta> ferramentasSelecionadas) {
        this.idEmprestimo = idEmprestimo;
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.amigo = amigo;
        this.ferramentasSelecionadas = ferramentasSelecionadas != null ? ferramentasSelecionadas : new ArrayList<>();
        this.dao = null;
    }


    // Getters and setters

    public Integer getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Integer getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(Integer idAmigo) {
        this.idAmigo = idAmigo;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public void setStatus(StatusEmprestimo status) {
        this.status = status;
    }

    public Amigo getAmigo() {
        return amigo;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }

   
    
    public ArrayList<Ferramenta> getFerramentasSelecionadas() {
        return ferramentasSelecionadas;
    }

    public void setFerramentasSelecionadas(ArrayList<Ferramenta> ferramentasSelecionadas) {
        this.ferramentasSelecionadas = ferramentasSelecionadas;
    }

    // Adiciona uma ferramenta à lista de ferramentas selecionadas
    public void adicionarFerramenta(Ferramenta ferramenta) {
        if (ferramentasSelecionadas == null) {
            ferramentasSelecionadas = new ArrayList<>();
        }
        ferramentasSelecionadas.add(ferramenta);
    }

    // Remove uma ferramenta da lista de ferramentas selecionadas
    public void removerFerramenta(Ferramenta ferramenta) {
        if (ferramentasSelecionadas != null) {
            ferramentasSelecionadas.remove(ferramenta);
        }
    }
    
    public boolean inserirEmprestimo(int idAmigo, ArrayList<Ferramenta> ferramentasSelecionadas,Date dataDevolucao, Date dataInicial ){
        
        Emprestimo objeto = new Emprestimo(idAmigo, dataInicial, dataDevolucao, ferramentasSelecionadas );
        dao.salvarEmprestimo(objeto);
        return true;
    }

}

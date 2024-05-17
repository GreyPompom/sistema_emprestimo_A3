
package model;

import dao.FerramentaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ferramenta {
    private int id;
    private String nome;
    private String marca;
    private double custo;
    private boolean status;
    private final FerramentaDAO dao;
    
    
    
    
    public Ferramenta() {
     this.dao = new FerramentaDAO(); 
     
    
    }

     public Ferramenta(int id, String nome, String Marca, double Custo) {
        this.id =id;
        this.nome = nome;
        this.marca = Marca;
        this.custo = Custo;
        this.dao = new FerramentaDAO(); // inicializado uma ferramenta no banco
        this.status = false;
    }
     
    public Ferramenta(int id, String nome, String marca, double custo, boolean status) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.status = status;
         this.dao = new FerramentaDAO(); // inicializado uma ferramenta no banco
         
         
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
     
    //METODOS CONTROLLERS//
    // retorna o maior ID da nossa base de dados
        public int maiorID() throws SQLException{
        return dao.pegaMaiorID();
    } 
        
     public ArrayList pegarLista() {
        //retorna a lista de ferramentas cadastradas no banco
        return dao.getMinhaLista();
        
    }
     public boolean InsertFerramenta(String nome, String Marca, double Custo) throws SQLException {
          System.out.println(Custo);
          System.out.println("CAHAMOU");
        int idM = this.maiorID() + 1;
        System.out.println(idM);
        Ferramenta objeto = new Ferramenta(idM, nome, Marca,Custo);
//        AlunoDAO.MinhaLista.add(objeto);
        dao.InserirFerramentaBD(objeto);
        return true;

    }

    public boolean UpdateFerramentaBD(String nome, int id, String marca, boolean status, double custo) {
        Ferramenta objeto = new Ferramenta( id,nome,  marca,  custo,  status);
        dao.AtualizarFerramenta(objeto);
        return true;
    }
    
    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

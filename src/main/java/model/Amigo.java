package model;
import dao.AmigoDAO;
import java.util.ArrayList;
import java.sql.SQLException;

public class Amigo {
    private int id;
    private String nome;
    private String telefone;
     private final AmigoDAO dao;
    public Amigo() {
        this.dao = new AmigoDAO();
    }

    public Amigo(String nome, String telefone) {
         this.dao = new AmigoDAO();
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public Amigo(int id, String nome, String telefone) {
        this.dao = new AmigoDAO();
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    //METODOS CONTROLLERS//
    // retorna o maior ID da nossa base de dados
        public int maiorID() throws SQLException{
        return dao.pegaMaiorID();
    } 
    public ArrayList pegarLista(){
        return dao.getMinhaLista();
    }
    
    public boolean InsertAmigo(String nome, String telefone)throws SQLException{
        int id = this.maiorID()+1;
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.InserirAmigoBD(objeto);
        return true;
    }
    public boolean UpdateAmigoBD(String nome, int id, String telefone) {
    Amigo objeto = new Amigo( id,nome, telefone);
    dao.AtualizarAmigo(objeto);
    return true;
    }
    
    public boolean DeleteAmigoBD(int id) {
    dao.DeletaAmigoBD(id);
    return true;
    }
       
}
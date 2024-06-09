
package model;

import dao.RelatorioDAO;
import java.util.ArrayList;
import model.Amigo;

public class Relatorio {
   

    private RelatorioDAO relatorioDAO;
    private Amigo amigoModel = new Amigo();

    public Relatorio() {
        this.relatorioDAO = new RelatorioDAO();
    }

    public int getTotalFerramentasEmprestadas() {
        return relatorioDAO.totalFerramentasEmprestadas();
    }

    public int getTotalEmprestimosAbertos() {
        return relatorioDAO.totalEmprestimosAbertos();
    }

    public int getTotalAmigosEmprestimosAbertos() {
        return relatorioDAO.totalAmigosEmprestimosAbertos();
    }

    public int getTotalEmprestimosPendentes() {
        return relatorioDAO.totalEmprestimosPendentes();
    }
    
    public ArrayList pegarListaAbertos(){
        return relatorioDAO.relatorioEmprestimosAtivos();
    } 
    public ArrayList pegarListaPendentes(){
        return relatorioDAO.relatorioEmprestimosAtivos();
    }
    public Amigo pegarListaAmigos(){
        
        return amigoModel.pegaAmigo( relatorioDAO.relatorioQuemFezMaisEmprestimos());
    }
    
}
package model;

import java.util.ArrayList;
import dao.AlunoDAO;

public class Aluno extends Pessoa {

    private String curso;
    private int fase;
// Construtor de Objeto Vazio

    public Aluno() {
        this(0, "", 0, "", 0);
    }
// Construtor com parâmetro

    public Aluno(int id, String nome, int idade, String curso, int fase ) {
        super(id, nome, idade);
        this.curso = curso;
        this.fase = fase;
    }
// Métodos GET e SET

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;

    }

    @Override
    public String toString() {
        return super.toString() + "curso=" + curso
                + ", fase=" + fase;
    }

    /* ABAIXO OS MÉTODOS PARA USO JUNTO COM O DAO SIMULANDO
A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS. */
// Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaLista() {
        return AlunoDAO.getMinhaLista();
    }
    // Cadastra novo aluno
    public boolean insertAlunoBD(String nome, int idade, String curso, int fase){
        int id = this.maiorID() + 1;
        Aluno objeto = new Aluno(id, nome, idade, curso, fase);
        getMinhaLista().add(objeto);
        return true;
    }
// Deleta um aluno específico pelo seu campo ID

    public boolean deleteAlunoBD(int id) {
        int indice = this.procuraIndice(id);
        getMinhaLista().remove(indice);
        return true;
    }
    // Edita um aluno específico pelo seu campo ID

    public boolean updateAlunoBD(int id, String nome, int idade, String curso, int fase) {
        Aluno objeto = new Aluno(id, nome, idade, curso, fase);
        int indice = this.procuraIndice(id);
        getMinhaLista().set(indice, objeto);
        return true;
    }
// procura o INDICE de objeto da minhaLista que
// contem o ID enviado.

    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < AlunoDAO.minhaLista.size(); i++) {
            if (AlunoDAO.minhaLista.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }
// carrega dados de um aluno específico pelo seu ID

    public Aluno carregaAluno(int id) {
        int indice = this.procuraIndice(id);
        return AlunoDAO.getMinhaLista().get(indice);
    }
// retorna o maior ID da nossa base de dados

    public int maiorID() {
        return AlunoDAO.maiorID();
    }
}

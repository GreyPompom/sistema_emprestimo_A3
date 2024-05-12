package model;

public class Ferramenta {
    private int id;
    private String nome;
    private String marca;
    private double custo;
    private boolean status;
    
    public Ferramenta() {
    this(0, "", "", 0.0, false);
    
    }

    public Ferramenta(int id, String nome, String marca, double custo, boolean status) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.status = status;
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
    
}

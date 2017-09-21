package br.senai.sp.informatica.sidvet.model;

public class Pet {

    private Long petID;
    private String nome;
    private double tamanho;
    private int idade;
    private String alergia;
    private Cliente cliente;
    private Raca raca;
    private SexoDog  sexoDog;

    public Pet(){

    }

    public Pet(Long petID, String nome, double tamanho, int idade, String alergia, Cliente cliente, Raca raca, SexoDog sexoDog) {
        this.petID = petID;
        this.nome = nome;
        this.tamanho = tamanho;
        this.idade = idade;
        this.alergia = alergia;
        this.cliente = cliente;
        this.raca = raca;
        this.sexoDog = sexoDog;
    }

    public Long getPetID() {
        return petID;
    }

    public void setPetID(Long petID) {
        this.petID = petID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public SexoDog getSexoDog() {
        return sexoDog;
    }

    public void setSexoDog(SexoDog sexoDog) {
        this.sexoDog = sexoDog;
    }
}

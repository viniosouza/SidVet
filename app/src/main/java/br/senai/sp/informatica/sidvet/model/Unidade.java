package br.senai.sp.informatica.sidvet.model;

import org.parceler.Parcel;

@Parcel
public class Unidade {

    private Long unidadeID;
    private String nome;
    private int cep;
    private String cnpj;
    private Funcionario funcionario;
    private int num;

    public Unidade() {

    }

    public Unidade(Long unidadeID, String nome, int cep, String cnpj, Funcionario funcionario, int num) {
        this.unidadeID = unidadeID;
        this.nome = nome;
        this.cep = cep;
        this.cnpj = cnpj;
        this.funcionario = funcionario;
        this.num = num;
    }

    public Long getUnidadeID() {
        return unidadeID;
    }

    public void setUnidadeID(Long unidadeID) {
        this.unidadeID = unidadeID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

package br.senai.sp.informatica.sidvet.model;

import org.parceler.Parcel;

import java.util.Calendar;

@Parcel
public class Cliente {
    private Long clienteID;
    private String nome;
    private String cpf;
    private Calendar dtNasc;
    private Sexo sexo;
    private String cep;
    private Unidade unidade;
    private int num;
    private Login login;

    public Cliente(){

    }

    public Cliente(Long clienteID, String nome, String cpf, Calendar dtNasc, Sexo sexo, String cep, Unidade unidade, int num, Login login) {
        this.clienteID = clienteID;
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
        this.cep = cep;
        this.unidade = unidade;
        this.num = num;
        this.login = login;
    }

    public Long getClienteID() {
        return clienteID;
    }

    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Calendar dtNasc) {
        this.dtNasc = dtNasc;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}

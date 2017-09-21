package br.senai.sp.informatica.sidvet.model;

import org.parceler.Parcel;

import java.util.Calendar;
@Parcel
public class Funcionario {

    private Long funcionarioID;
    private String nome;
    private Calendar dtNasc;
    private Sexo sexo;
    private Cargo cargo;
    private Login login;
    private Unidade unidade;

    public Funcionario() {
    }

    public Funcionario(Long funcionarioID, String nome, Calendar dtNasc, Sexo sexo, Cargo cargo, Login login, Unidade unidade) {
        this.funcionarioID = funcionarioID;
        this.nome = nome;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
        this.cargo = cargo;
        this.login = login;
        this.unidade = unidade;
    }

    public Long getFuncionarioID() {
        return funcionarioID;
    }

    public void setFuncionarioID(Long funcionarioID) {
        this.funcionarioID = funcionarioID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
}

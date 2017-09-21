package br.senai.sp.informatica.sidvet.model;


import org.parceler.Parcel;

import java.math.BigDecimal;
@Parcel
public class Cargo {

    private Long cargoID;
    private String nome;
    private BigDecimal salario;

    public Cargo() {
    }

    public Cargo(Long cargoID, String nome, BigDecimal salario) {
        this.cargoID = cargoID;
        this.nome = nome;
        this.salario = salario;
    }

    public Long getCargoID() {
        return cargoID;
    }

    public void setCargoID(Long cargoID) {
        this.cargoID = cargoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}

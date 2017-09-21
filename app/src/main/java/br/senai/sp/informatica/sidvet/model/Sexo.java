package br.senai.sp.informatica.sidvet.model;

import org.parceler.Parcel;


public enum Sexo {

    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private String sexo;

    Sexo(String sexo){
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return this.sexo;
    }
}

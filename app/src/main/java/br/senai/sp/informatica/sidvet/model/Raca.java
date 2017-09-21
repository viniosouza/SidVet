package br.senai.sp.informatica.sidvet.model;

import org.parceler.Parcel;

@Parcel
public class Raca {

    private String nome;

    public Raca() {

    }

    public Raca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

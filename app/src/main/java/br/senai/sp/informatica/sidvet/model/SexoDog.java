package br.senai.sp.informatica.sidvet.model;

import org.parceler.Parcel;

public enum SexoDog {

    MACHO("Macho"),
    FEMEA("Femea");

    private String sexoDog;

    SexoDog(String sexoDog){
        this.sexoDog = sexoDog;
    }

    @Override
    public String toString() {
        return this.sexoDog;
    }
}

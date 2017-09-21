package br.senai.sp.informatica.sidvet.model;

import org.parceler.Parcel;

/**
 * Created by Tecnico_Tarde on 19/06/2017.
 */
@Parcel
public class Login {
    private Long loginId;
    private String email;
    private String senha;


    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

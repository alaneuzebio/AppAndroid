package br.metodista.nowaitapp;

import java.util.Date;

/**
 * Created by root on 18/04/16.
 */
public class Cadastro {

    private Long _id;
    private String nome;
    private String email;
    private String cpf;
    private String senhaCad;

    public Long get_id() {
        return _id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenhaCad() {return senhaCad; }
    public void setSenhaCad(String senhaCad) { this.senhaCad = senhaCad; }



}
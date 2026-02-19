package br.com.library.models;

import java.time.LocalDateTime;

public class Cliente {

    private int id;
    private String nomeCompleto;
    private String email;
    private LocalDateTime deletadoEm;

    public Cliente (int id, String nomeCompleto, String email) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }

    public Cliente (String nomeCompleto, String email) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

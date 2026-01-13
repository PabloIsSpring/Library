package main.java.br.com.library.models;

import java.time.LocalDate;

public class Autor {

    private int id;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String genero;

    public Autor (String nomeCompleto, LocalDate dataNascimento, String naturalidade, String genero) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.naturalidade = naturalidade;
        this.genero = genero;
    }

    public Autor (int id, String nomeCompleto, LocalDate dataNascimento, String naturalidade, String genero) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.naturalidade = naturalidade;
        this.genero = genero;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public String getNaturalidade() {
        return this.naturalidade;
    }

    public String getGenero () {
        return this.genero;
    }

    public int getId () {
        return this.id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public void setNomeCompleto (String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setDataNascimento (LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNaturalidade (String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public void setGenero (String genero) {
        this.genero = genero;
    }
}

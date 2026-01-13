package main.java.br.com.library.models;

import java.time.LocalDate;

public class Livro {

    private int id;
    private String titulo;
    private int idAutor;
    private LocalDate dataPublicacao;
    private String generoLiterario;
    private int qtdPaginas;
    private boolean emprestado;

    public Livro (int id, String titulo, int idAutor, LocalDate dataPublicacao, String generoLiterario,
                  int qtdPaginas, boolean emprestado) {
        this.id = id;
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.generoLiterario = generoLiterario;
        this.qtdPaginas = qtdPaginas;
        this.emprestado = emprestado;
    }

    public Livro (String titulo, int idAutor, LocalDate dataPublicacao, String generoLiterario, int qtdPaginas,
                  boolean emprestado) {
        this.titulo = titulo;
        this.idAutor = idAutor;
        this.dataPublicacao = dataPublicacao;
        this.generoLiterario = generoLiterario;
        this.qtdPaginas = qtdPaginas;
        this.emprestado = emprestado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getGeneroLiterario() {
        return generoLiterario;
    }

    public void setGeneroLiterario(String generoLiterario) {
        this.generoLiterario = generoLiterario;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
}

package main.java.br.com.library.models;

public class Emprestimo {

    private int id;
    private int idCLiente;
    private int idLivro;

    public Emprestimo (int idCliente, int idLivro) {
        this.idCLiente = idCliente;
        this.idLivro = idLivro;
    }

    public Emprestimo (int id, int idCliente, int idLivro) {
        this.id = id;
        this.idCLiente = idCliente;
        this.idLivro = idLivro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCLiente() {
        return idCLiente;
    }

    public void setIdCLiente(int idCLiente) {
        this.idCLiente = idCLiente;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }
}

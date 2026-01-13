package main.java.br.com.library.models;

import java.util.List;

public class Cliente {

    private int id;
    private String nomeCompleto;
    List<Emprestimo> emprestimos;
    private String email;

    public Cliente (int id, String nomeCompleto, List<Emprestimo> emprestimos, String email) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.emprestimos = emprestimos;
        this.email = email;
    }

    public Cliente (String nomeCompleto, List<Emprestimo> emprestimos, String email) {
        this.nomeCompleto = nomeCompleto;
        this.emprestimos = emprestimos;
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

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

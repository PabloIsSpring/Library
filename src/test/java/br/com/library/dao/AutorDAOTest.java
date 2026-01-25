package br.com.library.dao;

import main.java.br.com.library.models.Autor;

import java.time.LocalDate;

public class AutorDAOTest {

    public static void main(String[] args) {
        AutorDAO autDAO = new AutorDAO();

        Autor autor = new Autor("Jean Paul Sarte", LocalDate.of(1905, 06, 01),
                "Frances", "Homem");

        if(autDAO.saveEntity(autor)) {
            System.out.println("Salvo");
        } else {
            System.out.println("Error");
        }
    }
}

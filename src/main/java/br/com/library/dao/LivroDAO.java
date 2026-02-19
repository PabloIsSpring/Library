package br.com.library.dao;

import br.com.library.models.Livro;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroDAO extends GenericDAO<Livro>{

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO livros (titulo, id_autor, data_publicacao, genero_literario, emprestado) " +
                "VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected String getDeleteQuery() {
        return "UPDATE livros SET deletado_em = NOW() " +
                "WHERE id = ?";
    }

    @Override
    protected String getFindByIdQuery() {
        return "SELECT titulo, id_autor, data_publicacao, genero_literario, emprestado " +
                "FROM livros WHERE id = ?";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE livros SET titulo = ?, id_autor = ?, data_publicacao = ?, genero_literario = ?, emprestado = ? " +
                "WHERE id = ?";
    }

    @Override
    protected void setParametersToUpdate(PreparedStatement stmt, Livro livro) throws SQLException {
        stmt.setString(1, livro.getTitulo());
        stmt.setInt(2, livro.getIdAutor());
        stmt.setDate(3, Date.valueOf(livro.getDataPublicacao()));
        stmt.setString(4, livro.getGeneroLiterario());
        stmt.setBoolean(5, livro.isEmprestado());
        stmt.setInt(6, livro.getId());

    }

    @Override
    protected void setParametersToSave(PreparedStatement stmt, Livro livro) throws SQLException {
        stmt.setString(1, livro.getTitulo());
        stmt.setInt(2, livro.getIdAutor());
        stmt.setDate(3, Date.valueOf(livro.getDataPublicacao()));
        stmt.setString(4, livro.getGeneroLiterario());
        stmt.setBoolean(5, livro.isEmprestado());
    }

    @Override
    protected void setParametersToDelete(PreparedStatement stmt, int id) throws SQLException {
        stmt.setInt(1, id);
    }

    @Override
    protected Livro getEntityFromResult(ResultSet rs) throws SQLException {
        Livro livro = new Livro(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getInt("id_autor"),
                rs.getDate("data_publicacao").toLocalDate(),
                rs.getString("genero_literario"),
                rs.getBoolean("emprestado")
        );

        return livro;
    }
}

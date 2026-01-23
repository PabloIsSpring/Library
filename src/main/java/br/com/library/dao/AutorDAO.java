package main.java.br.com.library.dao;

import main.java.br.com.library.models.Autor;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutorDAO extends GenericDAO <Autor> {

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO autores (nome_completo, data_nascimento, naturalidade, genero) VALUES (?, ?, ?, ?)";
    }

    @Override
    protected String getDeleteQuery() {
        return "UPDATE autores SET deletado_em = NOW() WHERE id = ?";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE autores SET nome_completo = ?, data_nascimento = ?, naturalidade = ?, genero = ?" +
                " WHERE id = ?";
    }

    @Override
    protected String getFindByIdQuery() {
        return "SELECT id, nome_completo, data_nascimento, naturalidade, genero" +
                " FROM autores" +
                " WHERE id = ?";
    }

    @Override
    protected void setParametersToSave(PreparedStatement stmt, Autor autor) throws SQLException {
        stmt.setString(1, autor.getNomeCompleto());
        stmt.setDate(2, Date.valueOf(autor.getDataNascimento()));
        stmt.setString(3, autor.getNaturalidade());
        stmt.setString(4, autor.getGenero());
    }

    @Override
    protected void setParametersToUpdate(PreparedStatement stmt, Autor autor) throws SQLException {
        stmt.setString(1, autor.getNomeCompleto());
        stmt.setDate(2, Date.valueOf(autor.getDataNascimento()));
        stmt.setString(3, autor.getNaturalidade());
        stmt.setString(4, autor.getGenero());
        stmt.setInt(5, autor.getId());
    }

    @Override
    protected void setParametersToDelete(PreparedStatement stmt, int id) throws SQLException {
        stmt.setInt(1, id);
    }

    @Override
    protected Autor getEntityFromResult(ResultSet rs) throws SQLException {
        Autor autor = new Autor(rs.getInt("id"),
                                rs.getString("nome_completo"),
                                rs.getDate("data_nascimento").toLocalDate(),
                                rs.getString("naturalidade"),
                                rs.getString("genero"));

        return autor;
    }
}
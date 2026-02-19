package br.com.library.dao;

import br.com.library.models.Emprestimo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmprestimoDAO extends GenericDAO<Emprestimo>{
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO emprestimos (id_livro, id_cliente) VALUES (?, ?) ";
    }

    @Override
    protected String getDeleteQuery() {
        return "UPDATE emprestimos SET deletado_em = NOW() " +
               "WHERE id = ?";
    }

    @Override
    protected String getFindByIdQuery() {
        return "SELECT id, id_cliente, id_livro FROM emprestimos WHERE id = ? ";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE emprestimos SET id_cliente = ?, id_livro = ? WHERE id = ? ";
    }

    @Override
    protected void setParametersToSave(PreparedStatement stmt, Emprestimo emprestimo) throws SQLException {
        stmt.setInt(1, emprestimo.getIdLivro());
        stmt.setInt(2, emprestimo.getIdCLiente());
    }

    @Override
    protected void setParametersToUpdate(PreparedStatement stmt, Emprestimo emprestimo) throws SQLException {
        stmt.setInt(1, emprestimo.getIdCLiente());
        stmt.setInt(1, emprestimo.getIdLivro());
        stmt.setInt(1, emprestimo.getId());
    }

    @Override
    protected void setParametersToDelete(PreparedStatement stmt, int id) throws SQLException {
        stmt.setInt(1, id);
    }

    @Override
    protected Emprestimo getEntityFromResult(ResultSet rs) throws SQLException {
        Emprestimo emprestimo = new Emprestimo(rs.getInt("id"), rs.getInt("id_cliente"),
                                               rs.getInt("id_livro"));

        return emprestimo;
    }
}

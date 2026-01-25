package br.com.library.dao;

import main.java.br.com.library.models.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO extends GenericDAO<Cliente>{
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO clientes (nome_completo, email) VALUES (?, ?)";
    }

    @Override
    protected String getDeleteQuery() {
        return "UPDATE clientes SET deletado_em = NOW()" +
                " WHERE id = ?";
    }

    @Override
    protected String getFindByIdQuery() {
        return "SELECT id, nome_completo, email FROM clientes WHERE id = ?";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE clientes SET nome_completo = ?, email = ?" +
                " WHERE id = ?";
    }

    @Override
    protected void setParametersToSave(PreparedStatement stmt, Cliente cliente) throws SQLException {
        stmt.setString(1, cliente.getNomeCompleto());
        stmt.setString(2, cliente.getEmail());
    }

    @Override
    protected void setParametersToUpdate(PreparedStatement stmt, Cliente cliente) throws SQLException {
        stmt.setString(1, cliente.getNomeCompleto());
        stmt.setString(2, cliente.getEmail());
        stmt.setInt(3, cliente.getId());
    }

    @Override
    protected void setParametersToDelete(PreparedStatement stmt, int id) throws SQLException {
        stmt.setInt(1, id);
    }

    @Override
    protected Cliente getEntityFromResult(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente(rs.getInt("id"),
                                      rs.getString("nome_completo"),
                                      rs.getString("email"));

        return cliente;
    }
}

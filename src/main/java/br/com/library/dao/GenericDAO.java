package main.java.br.com.library.dao;

import main.java.br.com.library.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class GenericDAO <T>{

    protected abstract String getInsertQuery ();
    protected abstract String getSelectQuery ();
    protected abstract String getDeleteQuery ();
    protected abstract String getFindById ();

    protected abstract void setParametersToSave(PreparedStatement stmt, T entity) throws SQLException;
    protected abstract void setParametersToUpdate(PreparedStatement stmt, T entity) throws SQLException;

    protected abstract T getEntityFromResult (ResultSet rs) throws SQLException;

    public boolean saveEntity (T entity) {
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(getInsertQuery())) {

            setParametersToSave(stmt, entity);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar entidade no banco", e);
        }
    }

    public boolean deleteEntity (T entity) throws SQLException {
        return true;
    }

    public T getEntityById (int id) throws SQLException {
        return null;
    }
}

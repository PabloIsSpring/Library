package br.com.library.dao;

import br.com.library.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public abstract class GenericDAO <T>{

    protected abstract String getInsertQuery ();
    protected abstract String getDeleteQuery ();
    protected abstract String getFindByIdQuery ();
    protected abstract String getUpdateQuery();

    protected abstract void setParametersToSave(PreparedStatement stmt, T entity) throws SQLException;
    protected abstract void setParametersToUpdate(PreparedStatement stmt, T entity) throws SQLException;
    protected abstract void setParametersToDelete(PreparedStatement stmt, int id) throws SQLException;

    protected abstract T getEntityFromResult (ResultSet rs) throws SQLException;

    public boolean saveEntity (T entity){
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(getInsertQuery())) {

            setParametersToSave(stmt, entity);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar entidade no banco", e);
        }
    }

    public boolean deleteEntity (int id) {
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(getDeleteQuery())) {

            setParametersToDelete(stmt, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar entidade ", e);
        }
    }

    public boolean updateEntity (T entity) {
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(getUpdateQuery())) {

            setParametersToUpdate(stmt, entity);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar entidade", e);
        }
    }

    public Optional<T> getEntityById (int id) {
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(getFindByIdQuery())){

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    return Optional.of(getEntityFromResult(rs));
                }
                return Optional.empty();
            }


        } catch (SQLException e) {
            throw new RuntimeException("Falha ao buscar entidade",e);
        }
    }
}

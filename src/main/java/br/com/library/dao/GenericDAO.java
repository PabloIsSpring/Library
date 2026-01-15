package main.java.br.com.library.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class GenericDAO <T>{

    protected abstract String getInsertQuery ();

    protected abstract String getSelectQuery ();

    protected abstract String getDeleteQuery ();

    protected abstract void setParameters(PreparedStatement stmt, T entity) throws SQLException;

    protected abstract T getEntityFromResult (ResultSet rs) throws SQLException;

    public void saveEntity (T entity) {
        String sql = getSelectQuery();

    }
}

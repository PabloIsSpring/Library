package main.java.br.com.library.db;

import java.sql.*;

public class DatabaseConnection {

    private static final String URL = DatabaseConfig.getDbURL();
    private static final String PASSWORD = DatabaseConfig.getDbPassword();
    private static final String USER = DatabaseConfig.getDbUser();

    public static Connection getConnection () {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro na conexao com banco de dados");
        }
    }

    public static void closeConnection (Connection conn) {
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement (PreparedStatement stmt) {
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet (ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

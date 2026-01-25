package br.com.library.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

    private static final Properties props = new Properties ();

    static {
        try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            props.load(input);

            if(input == null) {
                throw new RuntimeException("application.properties nao encontrado");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException ("Erro ao carregar o application.properties");
        }
    }

    public static String getDbURL(){
        return props.getProperty("db.url");
    }

    public static String getDbPassword(){
        return props.getProperty("db.password");
    }

    public static String getDbUser(){
        return props.getProperty("db.user");
    }

}

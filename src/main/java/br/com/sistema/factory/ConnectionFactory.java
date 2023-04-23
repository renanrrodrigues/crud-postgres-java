package br.com.sistema.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "t00r";
    private static final String DATABASE_URL = "jdbc:postgresql://172.17.0.2:5432/sistema";

    public static Connection createConnectionToPostgreSQL() throws Exception {

        Class.forName("org.postgresql.Driver");

        return (Connection) DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }

    public static void main(String[] args) throws Exception {

        Connection conn = createConnectionToPostgreSQL();

        if (conn != null) {
            System.out.println("Connection successfully closed!");
            conn.close();
        }
    }
}

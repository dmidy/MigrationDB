package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private String JDBC_URL = "jdbc:postgresql://localhost:5432/pgdb";
    private String USERNAME = "postgres";
    private String PASSWORD = "12344321";
    private static Database instance;

    private Database(){

    }
    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
        public static void main(String[] args) {
                try {
                        Connection connection = Database.getInstance().getConnection();
                        System.out.println("Success!");
                }  catch (SQLException e) {
                System.out.println("Failed.");
                }
        }
}

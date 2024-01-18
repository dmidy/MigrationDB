package org.example.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlScriptExecutor {

    public static String readSqlScript(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
    }

    static void executeSqlScript(Connection connection, String sqlScript) {
        String[] queries = sqlScript.split(";");

        try {
            connection.setAutoCommit(false);

            for (String query : queries) {
                if (!query.trim().isEmpty()) {
                    try (PreparedStatement statement = connection.prepareStatement(query)) {
                        statement.execute();
                    } catch (SQLException e) {
                        connection.rollback();
                        e.printStackTrace();
                        return;
                    }
                }
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
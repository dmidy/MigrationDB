package org.example.services;

import org.example.db.Database;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseInitService {
    static void migrateDatabase() {
        try {

            Flyway flyway = Flyway.configure()
                    .dataSource("jdbc:postgresql://localhost:5432/pgdb", "postgres", "12344321")
                    .baselineOnMigrate(true)
                    .locations("classpath:db.migration")
                    .load();
            flyway.migrate();
        } catch (FlywayException e) {
            System.out.println("Flyway migration failed.");
            throw e;
        }
    }

    public static void main(String[] args) {
        try (Connection connection = Database.getInstance().getConnection()) {
            migrateDatabase();
            System.out.println("Database migration completed successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to migrate database.");
        }
    }
}

package com.mycompany.bd2025;

import com.mycompany.bd25.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseTest {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println(" Database connected successfully.");
            } else {
                System.out.println("Connection object is null or closed.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
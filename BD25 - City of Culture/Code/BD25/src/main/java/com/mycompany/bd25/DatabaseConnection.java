package com.mycompany.bd25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This helps connect the program to the database.
public class DatabaseConnection {

    // Update these details to match the local database.
    private static final String URL = "jdbc:mysql://localhost:3306/bd25events2_0";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Used to connect to the database.
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            System.out.println("Connected to the database successfully!");

            // Querying the database and testing
            String strSelect = "SELECT * FROM `bd25events2.0`";
            System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

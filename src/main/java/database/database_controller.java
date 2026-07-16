package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database_controller {

    // Database URL
    private static final String URL = "jdbc:mysql://localhost:3306/employee";

    // Database Username
    private static final String USERNAME = "root";

    // Database Password
    private static final String PASSWORD = "anand";

    // Method to establish connection
    public static Connection getConnection() {

        Connection connection = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("✅ Database Connected Successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL Driver Not Found!");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("❌ Database Connection Failed!");
            e.printStackTrace();
        }

        return connection;
    }

    // Method to close connection
    public static void closeConnection(Connection connection) {

        if (connection != null) {

            try {
                connection.close();
                System.out.println("✅ Database Connection Closed.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
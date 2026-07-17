package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database_controller {

    private static final String URL =
            "jdbc:mysql://localhost:3306/employee";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "anand";

    private database_controller() {
        // Prevent object creation
    }

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection =
                    DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Database Connected Successfully");

            return connection;

        } catch (ClassNotFoundException e) {

            throw new RuntimeException("MySQL Driver Not Found", e);

        } catch (SQLException e) {

            throw new RuntimeException("Unable to Connect Database", e);
        }
    }

    public static void closeConnection(Connection connection) {

        if (connection != null) {

            try {
                connection.close();
                System.out.println("Connection Closed");

            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }
}
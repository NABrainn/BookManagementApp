package app.bookmanagement.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection con = null;

    static {
        String url = "jdbc:sqlite:src/main/resources/app/bookmanagement/books.db";
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static Connection getConnection() {
        return con;
    }
}

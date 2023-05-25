package database;

import java.sql.*;

public class DatabaseConnector {
    private Connection conn;
    private final String url = "jdbc:mysql://localhost:3306/gym?characterEncoding=utf-8&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "liyu422321";

    public DatabaseConnector() throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() {
        return conn;
    }

}

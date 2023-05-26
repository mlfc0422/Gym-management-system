package Common;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector implements AutoCloseable {
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
    @Override
    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}


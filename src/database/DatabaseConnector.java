package database;

import java.sql.*;

public class DatabaseConnector {
    private Connection conn;

    public DatabaseConnector(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public void performQuery(String query) throws SQLException {
        // 执行数据库查询操作
        // 使用 conn 进行查询操作
    }

    public void performUpdate(String update) throws SQLException {
        // 执行数据库更新操作
        // 使用 conn 进行更新操作
    }
}

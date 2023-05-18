package database;

import java.sql.*;

public class DatabaseConnector {
    private Connection conn;

    public DatabaseConnector(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }
    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public ResultSet performQuery(String query) throws SQLException {
        // 执行数据库查询操作
        // 使用 conn 进行查询操作
        PreparedStatement statement = null;
        ResultSet resultSet = null;

            statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery();
            return resultSet;
            // 处理查询结果
    }

    public void performUpdate(String update) throws SQLException {
        // 执行数据库更新操作
        // 使用 conn 进行更新操作
    }
}

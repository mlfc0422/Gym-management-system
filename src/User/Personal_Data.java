package User;
import java.sql.*;
import database.DatabaseConnector;

public class Personal_Data {
    private final String url = "jdbc:mysql://localhost:3306/gym?characterEncoding=utf-8&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "liyu422321";
    public void personal_data() throws SQLException {
        DatabaseConnector dc = new DatabaseConnector(url, username, password);
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = dc.getConnection();
            String query = "Select * From customer where cus_id = 1001";
            resultSet = dc.performQuery(query);
            while (resultSet.next()) {
                // 从结果集中获取数据并进行处理
                String name = resultSet.getString("cus_name");
                int age = resultSet.getInt("vip_lvl");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }
        } catch (SQLException e) {
            System.out.println("查询个人信息出错：" + e.getMessage());
        } finally {
            // 关闭 ResultSet
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // 关闭 Connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

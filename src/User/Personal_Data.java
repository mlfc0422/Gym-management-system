package User;
import java.sql.*;
import database.DatabaseConnector;

public class Personal_Data {
    private final String url = "jdbc:mysql://localhost:3306/gym?characterEncoding=utf-8&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "liyu422321";
    public void personal_data(String cus_id) throws SQLException {
        DatabaseConnector dc = new DatabaseConnector(url, username, password);
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = dc.getConnection();
            String query = "Select * From customer where cus_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, cus_id);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                // 从结果集中获取数据并进行处理
                cus_id = resultSet.getString("cus_id");
                int cus_pswd = resultSet.getInt("cus_pswd");

                System.out.println("账号: " + cus_id);
                System.out.println("密码: " + cus_pswd);
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

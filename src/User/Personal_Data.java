package User;
import java.sql.*;
import database.DatabaseConnector;

public class Personal_Data {

    public void personal_data(String cus_id) throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
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
                String cus_pswd = resultSet.getString("cus_pswd");
                String cus_name = resultSet.getString("cus_name");
                int vip_lvl = resultSet.getInt("vip_lvl");
                String cus_tel = resultSet.getString("cus_tel");
                String cus_hgt = resultSet.getString("cus_hgt");
                String cus_wgt = resultSet.getString("cus_wgt");
                String cus_age = resultSet.getString("cus_age");

                System.out.println("账号: " + cus_id);
                System.out.println("密码: " + cus_pswd);
                System.out.println("昵称: " + cus_name);
                System.out.println("会员等级: " + vip_lvl);
                System.out.println("电话: " + cus_tel);
                System.out.println("身高: " + cus_hgt+"(m)");
                System.out.println("体重: " + cus_wgt+"(kg)");
                System.out.println("年龄: " + cus_age+"(岁)");
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

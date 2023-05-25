package Employee;

import Common.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class emp_login {

    String emp_id = "";

    public boolean logOn2() throws SQLException {

        DatabaseConnector dc = new DatabaseConnector();
        Connection connection = dc.getConnection();
        Scanner sc = new Scanner(System.in);
        boolean loginSuccess = false;

        try {
            System.out.println("请输入账号：");
            emp_id = sc.nextLine();

            System.out.println("请输入密码：");
            String emp_pswd = sc.nextLine();

            String query = "SELECT * FROM employee WHERE emp_id = ? AND emp_pswd = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, emp_id);
                pstmt.setString(2, emp_pswd);
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("登录成功！");
                        loginSuccess = true;
                    } else {
                        System.out.println("用户名或密码错误，登录失败！");
                        emp_id = ""; // 清空 cus_id
                    }
                }
            } catch (SQLException e) {
                System.out.println("登录失败，请重新尝试！错误信息：" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("登录失败，请重新尝试！错误信息：" + e.getMessage());
        } finally {
            // 关闭连接
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return loginSuccess;
    }
}

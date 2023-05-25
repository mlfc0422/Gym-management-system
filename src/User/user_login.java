package User;

import database.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class user_login {
    String cus_id = "";

    public boolean logOn1() throws SQLException {

        DatabaseConnector dc = new DatabaseConnector();
        Connection connection = dc.getConnection();
        Scanner sc = new Scanner(System.in);
        boolean loginSuccess = false;

        try {
            System.out.println("请输入账号：");
            cus_id = sc.nextLine();

            System.out.println("请输入密码：");
            String cus_pswd = sc.nextLine();

            String query = "SELECT * FROM register WHERE cus_id = ? AND cus_pswd = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, cus_id);
                pstmt.setString(2, cus_pswd);
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("登录成功！");
                        loginSuccess = true;
                    } else {
                        System.out.println("用户名或密码错误，登录失败！");
                        cus_id = ""; // 清空 cus_id
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
    public String getCustomerId() {
        return cus_id;
    }

}


package User;

import database.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class login {
    private final String url = "jdbc:mysql://localhost:3306/gym?characterEncoding=utf-8&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "liyu422321";

    public String logOn() throws SQLException {

        DatabaseConnector dc = new DatabaseConnector(url, username, password);
        Connection connection = dc.getConnection();
        Scanner sc = new Scanner(System.in);
        String cus_id = "";

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

                    } else {
                        System.out.println("用户名或密码错误，登录失败！");
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
        return cus_id;
    }
}


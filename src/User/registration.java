package User;

import database.DatabaseConnector;
import java.sql.*;
import java.util.Scanner;

public class registration {
    private final String url = "jdbc:mysql://localhost:3306/gym?characterEncoding=utf-8&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "liyu422321";

    public void register() throws SQLException {
        DatabaseConnector dc = new DatabaseConnector(url, username, password);
        Connection connection = dc.getConnection();
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("请输入用户名：");
            String userId = sc.nextLine();
            System.out.println("请输入密码：");
            String password = sc.nextLine();

            String query = "INSERT INTO customer (cus_id, vip_lvl) VALUES (?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, userId);
                pstmt.setString(2, password);
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("注册成功！");
                } else {
                    System.out.println("注册失败，请重试！");
                }
            } catch (SQLException e) {
                System.out.println("注册失败，请重试！错误信息：" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("注册失败，请重试！错误信息：" + e.getMessage());
        }
    }

}

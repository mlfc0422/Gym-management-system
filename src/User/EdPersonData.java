package User;
import java.sql.*;
import database.DatabaseConnector;
import java.sql.SQLException;
import java.util.Scanner;

public class EdPersonData {

    public void editProfile(String cus_id) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入您的昵称：");
        String newName = sc.nextLine();

        System.out.println("请输入您的身高(m)：");
        String newHeight = sc.nextLine();

        System.out.println("请输入您的体重(kg)：");
        String newWeight = sc.nextLine();

        System.out.println("请输入您的电话：");
        String newPhoneNumber = sc.nextLine();

        System.out.println("请输入您的年龄：");
        String newAge = sc.nextLine();

        // 连接数据库并更新个人资料
        DatabaseConnector dc = new DatabaseConnector();
        Connection connection = dc.getConnection();
        String updateQuery = "UPDATE customer SET cus_name = ?, cus_hgt = ?, cus_wgt = ?, cus_tel = ?, cus_age = ? WHERE cus_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(updateQuery)) {
            pstmt.setString(1, newName);
            pstmt.setString(2, newHeight);
            pstmt.setString(3, newWeight);
            pstmt.setString(4, newPhoneNumber);
            pstmt.setString(5, newAge);
            pstmt.setString(6, cus_id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("个人资料已成功更新！");
            } else {
                System.out.println("更新失败，请重试！");
            }
        } catch (SQLException e) {
            System.out.println("更新个人资料时发生错误：" + e.getMessage());
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
    }

}

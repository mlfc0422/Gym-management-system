package Facility;

import Common.DatabaseConnector;
import java.sql.*;
import java.util.Scanner;

public class UserManagement {
    public void userManagement() throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Connection connection = null;
        Scanner sc = new Scanner(System.in);

        try {
            connection = dc.getConnection();

            System.out.print("请选择操作：\n1. 查询用户列表\n2. 删除用户\n");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                // 查询用户列表
                String sql = "SELECT * FROM customer";
                try (Statement stmt = connection.createStatement();
                     ResultSet resultSet = stmt.executeQuery(sql)) {

                    System.out.println("用户列表：");
                    while (resultSet.next()) {
                        String userId = resultSet.getString("cus_id");
                        String username = resultSet.getString("cus_name");
                        System.out.println("用户ID: " + userId + ", 用户名: " + username);
                    }
                } catch (SQLException e) {
                    System.out.println("查询用户列表失败: " + e.getMessage());
                }
            } else if (choice == 2) {
                // 删除用户
                System.out.print("请输入要删除的用户ID：");
                String userId = sc.nextLine();

                String deleteSql = "DELETE FROM customer WHERE cus_id = ?";
                String deleteRegistrationSql = "DELETE FROM register WHERE cus_id = ?";

                try (PreparedStatement stmt = connection.prepareStatement(deleteSql);
                     PreparedStatement registrationStmt = connection.prepareStatement(deleteRegistrationSql)) {
                    stmt.setString(1, userId);
                    registrationStmt.setString(1, userId);

                    connection.setAutoCommit(false); // 开启事务

                    stmt.executeUpdate();
                    registrationStmt.executeUpdate();

                    connection.commit(); // 提交事务

                    System.out.println("删除成功");
                } catch (SQLException e) {
                    connection.rollback(); // 回滚事务
                    System.out.println("删除用户失败: " + e.getMessage());
                } finally {
                    connection.setAutoCommit(true); // 恢复自动提交
                }
            } else {
                System.out.println("无效的选择！");
            }
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

}

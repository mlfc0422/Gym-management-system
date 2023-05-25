package User;

import java.sql.*;
import java.util.Scanner;
import java.util.Random;
import Common.DatabaseConnector;

public class registration {

    public void register() throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Connection connection = dc.getConnection();
        Scanner sc = new Scanner(System.in);
        ResultSet resultSet = null;
        int b = 0;

        try {
            while (true) {
                System.out.print("请输入账号: ");
                String cus_id = sc.nextLine();
                System.out.print("请输入密码: ");
                String cus_pswd = sc.nextLine();
                System.out.print("请再次输入密码: ");
                String cus_pswd2 = sc.nextLine();

                Random r = new Random();
                int i = r.nextInt(9000) + 1000;
                System.out.println("请输入以下验证码: " + i);
                int i2 = sc.nextInt();
                sc.nextLine(); // 消耗换行符

                String query = "SELECT * FROM register WHERE cus_id = ?";
                PreparedStatement pstmt = connection.prepareStatement(query);
                pstmt.setString(1, cus_id);
                resultSet = pstmt.executeQuery();

                if (cus_pswd.equals(cus_pswd2)) {
                    if (i2 == i) {
                        if (resultSet.next()) {
                            System.out.println("用户名已存在!");
                            continue;
                        } else {
                            try {
                                String registerQuery = "INSERT INTO register (cus_id, cus_pswd) VALUES (?, ?)";
                                pstmt = connection.prepareStatement(registerQuery);
                                pstmt.setString(1, cus_id);
                                pstmt.setString(2, cus_pswd);
                                b = pstmt.executeUpdate();

                                String customerQuery = "INSERT INTO customer (cus_id, cus_pswd) VALUES (?, ?)";
                                pstmt = connection.prepareStatement(customerQuery);
                                pstmt.setString(1, cus_id);
                                pstmt.setString(2, cus_pswd);
                                // 设置其他需要插入的信息
                                b = pstmt.executeUpdate();
                            } catch (Exception e) {
                                System.out.println("注册失败，异常原因: " + e.getMessage());
                            }

                            if (b != 0) {
                                System.out.println("注册成功!");
                                break;
                            }
                        }
                    } else {
                        System.out.println("验证码错误。");
                        continue;
                    }
                } else {
                    System.out.println("两次密码不一致，请确认您的密码。");
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("注册失败，请重新尝试！错误信息：" + e.getMessage());
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


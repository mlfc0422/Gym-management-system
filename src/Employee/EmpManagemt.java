package Employee;

import Common.DatabaseConnector;
import java.sql.*;
import java.util.Scanner;

public class EmpManagemt {
    public void manageEmployee() throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Scanner sc = new Scanner(System.in);

        System.out.println("请选择操作：");
        System.out.println("1. 录入员工信息");
        System.out.println("2. 查询员工信息");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        if (choice == 1) {
            System.out.println("请输入员工id：");
            int emp_id = sc.nextInt();
            sc.nextLine();

            System.out.println("请输入员工姓名：");
            String emp_name = sc.nextLine();

            System.out.println("请输入员工职位：");
            String emp_post = sc.nextLine();

            System.out.println("请输入员工联系电话：");
            String phone = sc.nextLine();

            System.out.println("请输入员工年龄：");
            int emp_age = sc.nextInt();

            System.out.println("请输入员工薪资：");
            Double salary = sc.nextDouble();

            String insertSql = "INSERT INTO emp_data (emp_id, emp_name, post, phone, age, salary) VALUES (?, ?, ?, ?, ?, ?)";
            try (Connection connection = dc.getConnection();
                 PreparedStatement pstmt = connection.prepareStatement(insertSql)) {
                pstmt.setInt(1, emp_id);
                pstmt.setString(2, emp_name);
                pstmt.setString(3, emp_post);
                pstmt.setString(4, phone);
                pstmt.setInt(5, emp_age);
                pstmt.setDouble(6, salary);
                pstmt.executeUpdate();

                System.out.println("员工信息插入成功！");
            } catch (SQLException e) {
                System.out.println("录入失败：" + e.getMessage());
            }
        } else if (choice == 2) {
            try (Connection connection = dc.getConnection()) {
                System.out.println("请输入员工姓名：");
                String emp_name = sc.nextLine();

                String query = "SELECT * FROM emp_data WHERE emp_name = ?";
                try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                    pstmt.setString(1, emp_name);
                    try (ResultSet resultSet = pstmt.executeQuery()) {
                        while (resultSet.next()) {
                            int emp_id = resultSet.getInt("emp_id");
                            emp_name = resultSet.getString("emp_name");
                            String post = resultSet.getString("post");
                            String phone = resultSet.getString("phone");
                            int age = resultSet.getInt("age");
                            Date post_time = resultSet.getDate("post_time");
                            Double salary = resultSet.getDouble("salary");

                            System.out.println("员工ID: " + emp_id);
                            System.out.println("员工姓名: " + emp_name);
                            System.out.println("职位: " + post);
                            System.out.println("电话: " + phone);
                            System.out.println("年龄: " + age);
                            System.out.println("入职时间: " + post_time);
                            System.out.println("薪资: " + salary);
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("查询失败: " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("连接数据库失败: " + e.getMessage());
            }
        } else {
            System.out.println("无效的选择！");
        }
    }

}

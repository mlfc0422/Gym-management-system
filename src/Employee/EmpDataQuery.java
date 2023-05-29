package Employee;

import Common.DatabaseConnector;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpDataQuery {
    public void empdataquery() throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Scanner sc = new Scanner(System.in);

        try (Connection connection = dc.getConnection()) {
            System.out.println("请输入员工姓名");
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
    }
}


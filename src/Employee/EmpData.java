package Employee;

import Common.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpData {
    public void emp_data() throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Connection connection = dc.getConnection();
        Scanner sc = new Scanner(System.in);

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
        try(PreparedStatement pstmt = connection.prepareStatement(insertSql)) {
            pstmt.setInt(1, emp_id);
            pstmt.setString(2, emp_name);
            pstmt.setString(3, emp_post);
            pstmt.setString(4, phone);
            pstmt.setInt(5, emp_age);
            pstmt.setDouble(6,salary);
            pstmt.executeUpdate();

            System.out.println("员工信息插入成功！");
        }catch (Exception e)
        {
            System.out.println("录入失败"+e.getMessage());
        }
        // 关闭资源
        connection.close();
    }
}

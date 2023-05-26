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
        String emp_id = sc.nextLine();

        System.out.println("请输入员工姓名：");
        String emp_name = sc.nextLine();

        System.out.println("请输入员工年龄：");
        String emp_age = sc.nextLine();

        System.out.println("请输入员工职位：");
        String emp_post = sc.nextLine();

        System.out.println("请输入员工薪资：");
        String emp_salary = sc.nextLine();

        String insertSql = "INSERT INTO employee (emp_id, emp_name, emp_age, emp_post, emp_salary) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement pstmt = connection.prepareStatement(insertSql)) {
            pstmt.setString(1, emp_id);
            pstmt.setString(2, emp_name);
            pstmt.setString(3, emp_age);
            pstmt.setString(4, emp_post);
            pstmt.setString(5, emp_salary);
            pstmt.executeUpdate();

            System.out.println("员工信息插入成功！");
        }

        // 关闭资源
        connection.close();
    }
}

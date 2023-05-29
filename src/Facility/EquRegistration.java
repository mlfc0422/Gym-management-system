package Facility;
import Common.DatabaseConnector;
import java.sql.*;
import java.util.Scanner;

public class EquRegistration {
    public void equregistration(String root_id) throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Connection connection = dc.getConnection();

        Scanner scanner = new Scanner(System.in);
        System.out.print("输入器材ID: ");
        int facility_id = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        System.out.print("输入器材名字: ");
        String name = scanner.nextLine();

        System.out.print("输入器材数量: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        System.out.print("输入器材负责人: ");
        String emp_name = scanner.nextLine();

        System.out.print("输入器材金额/个: ");
        double amount = scanner.nextDouble();

        String sql = "INSERT INTO facility (facility_id, facility_name, facility_amount, facility_num, facility_emp,root_id) " +
                "VALUES (?, ?, ?, ?, ?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, facility_id);
            stmt.setString(2, name);
            stmt.setDouble(3, amount);
            stmt.setInt(4, num);
            stmt.setString(5, emp_name);
            stmt.setString(6,root_id);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println(rows + "条信息录入成功！");
            }
        } catch (SQLException e) {
            System.err.println("录入失败：" + e.getMessage());
        } finally {
            // 关闭资源
            connection.close();
        }
    }
}


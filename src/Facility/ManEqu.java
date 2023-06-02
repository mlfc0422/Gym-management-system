package Facility;

import Common.DatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManEqu {
    public void manequ() throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Connection connection = dc.getConnection();

        String sql = "SELECT * FROM facility";

        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                int facility_id = resultSet.getInt("facility_id");
                String name = resultSet.getString("facility_name");
                double amount = resultSet.getDouble("facility_amount");
                int num = resultSet.getInt("facility_num");
                String emp_name = resultSet.getString("facility_emp");
                String root_id = resultSet.getString("root_id");

                System.out.println("器材ID: " + facility_id);
                System.out.println("器材名字: " + name);
                System.out.println("器材金额/个: " + amount);
                System.out.println("器材数量: " + num);
                System.out.println("器材负责人: " + emp_name);
                System.out.println("Root ID: " + root_id);
                System.out.println("-----------------------");
            }
        } catch (SQLException e) {
            System.err.println("查询失败：" + e.getMessage());
        } finally {
            // 关闭资源
            connection.close();
        }
    }

}

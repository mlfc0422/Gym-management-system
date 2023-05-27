package Finance;

import Common.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Spend {
    public void spend(String root_id) throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Scanner sc = new Scanner(System.in);

        Connection connection = dc.getConnection();

        System.out.println("请输入金额：");
        Double amount = sc.nextDouble();
        sc.nextLine();
        System.out.println("请输入支出用途：");
        String text = sc.nextLine();

        try  {
            String sql = "INSERT INTO finance (amount,text,root_id) VALUES (?, ?, ?)";

            try (PreparedStatement st = connection.prepareStatement(sql)) {
                st.setDouble(1, amount);
                st.setString(2, text);
                st.setString(3,root_id);
                st.executeUpdate();
                System.out.println("录入成功");
            }
        } catch (SQLException e) {
            System.out.println("插入失败: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("输入错误: " + e.getMessage());
        }
        connection.close();
    }
}

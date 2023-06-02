package Finance;

import Common.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Spend {
    private static final double MAX_AMOUNT = 999999999;

    public void spend(String root_id) throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Scanner sc = new Scanner(System.in);

        Connection connection = dc.getConnection();

        System.out.println("请输入金额：");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount > 0 && amount <= MAX_AMOUNT) { // MAX_AMOUNT为允许的最大金额
            System.out.println("请输入支出用途：");
            String text = sc.nextLine();

            try {
                String sql = "INSERT INTO finance (amount, text, root_id) VALUES (?, ?, ?)";

                try (PreparedStatement st = connection.prepareStatement(sql)) {
                    st.setDouble(1, amount);
                    st.setString(2, text);
                    st.setString(3, root_id);
                    st.executeUpdate();
                    System.out.println("录入成功");
                }
            } catch (SQLException e) {
                System.out.println("插入失败: " + e.getMessage());
            }
        } else {
            System.out.println("金额超出范围");
        }

        connection.close();
    }

}

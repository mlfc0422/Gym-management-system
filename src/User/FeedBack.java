package User;

import Common.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class FeedBack {
    public void feedback(String cus_id) throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Scanner sc = new Scanner(System.in);
        Connection connection = dc.getConnection();
        System.out.println("请输入你想要反馈的内容");
        String text = sc.nextLine();

        String sql = "INSERT INTO feedback (cus_id,text) VALUES (?,?)";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1,cus_id);
            pstmt.setString(2,text);
            pstmt.executeUpdate();
            System.out.println("反馈成功");
        }catch (Exception e )
        {
            System.out.println("反馈失败，错误原因:" + e.getMessage());
        }
    }
}

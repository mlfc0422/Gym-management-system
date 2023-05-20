package Appointment;

import database.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookLesson {
    private final String url = "jdbc:mysql://localhost:3306/gym?characterEncoding=utf-8&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "liyu422321";
    public void bookLesson(String cus_id) throws SQLException {
        DatabaseConnector dc = new DatabaseConnector(url, username, password);
        Scanner sc = new Scanner(System.in);

        Connection connection = dc.getConnection();

        System.out.println("请输入您想预约的课程代码：");
        String id = sc.nextLine();

        String pdSql = "SELECT IFNULL(shangxian, 0) - IFNULL(renshu, 0) AS availableSeats FROM kecheng WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(pdSql)) {
            pstmt.setString(1, id);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                int availableSeats = resultSet.getInt("availableSeats");

                if (availableSeats > 0) {
                    String querySql = "SELECT * FROM gerenkecheng WHERE id = ? and cus_id = ?";
                    pstmt.setString(1, id);
                    pstmt.setString(2, cus_id);
                    resultSet = pstmt.executeQuery(querySql);

                    if (resultSet.next()) {
                        System.out.println("您已预约过该课程！");
                    } else {
                        String bgSql = "UPDATE kecheng SET renshu = renshu + 1 WHERE id = ?";
                        String yySql = "INSERT INTO gerenkecheng SELECT * FROM (SELECT * FROM kecheng WHERE id = ? " +
                                "UNION SELECT cus_id from register where cus_id=?";

                        try (PreparedStatement bgPstmt = connection.prepareStatement(bgSql);
                             PreparedStatement yyPstmt = connection.prepareStatement(yySql)) {
                            bgPstmt.setString(1, id);
                            yyPstmt.setString(1, id);
                            yyPstmt.setString(2,cus_id);

                            bgPstmt.executeUpdate();
                            yyPstmt.executeUpdate();

                            System.out.println("预约成功！");
                        }
                    }
                } else {
                    System.out.println("您预约的课程已满！");
                }
            }
        }
    }

}



package Appointment;

import Common.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookLesson {
    public void bookLesson(String cus_id) throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Scanner sc = new Scanner(System.in);

        Connection connection = dc.getConnection();

        System.out.println("请输入您想预约的课程代码：");
        int course_id = sc.nextInt();

        String pdSql = "SELECT IFNULL(upper_limit, 0) - IFNULL(booked, 0) AS availableSeats FROM public_timetable WHERE course_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(pdSql)) {
            pstmt.setInt(1, course_id);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    int availableSeats = resultSet.getInt("availableSeats");

                    if (availableSeats > 0) {
                        String querySql = "SELECT * FROM personal_timetable WHERE course_id = ? and cus_id = ?";
                        try (PreparedStatement queryPstmt = connection.prepareStatement(querySql)) {
                            queryPstmt.setInt(1, course_id);
                            queryPstmt.setString(2, cus_id);
                            try (ResultSet queryResultSet = queryPstmt.executeQuery()) {
                                if (queryResultSet.next()) {
                                    System.out.println("您已预约过该课程！");
                                } else {
                                    String bgSql = "UPDATE public_timetable SET booked = booked + 1 WHERE course_id = ?";
                                    String yySql = "INSERT INTO personal_timetable (course_id,course, teacher_name, room, week, time, cus_id) " +
                                            "SELECT course_id,course, teacher_name, room, week, time, ? FROM public_timetable WHERE course_id = ?";

                                    try (PreparedStatement bgPstmt = connection.prepareStatement(bgSql);
                                         PreparedStatement yyPstmt = connection.prepareStatement(yySql)) {
                                        bgPstmt.setInt(1, course_id);
                                        bgPstmt.executeUpdate();

                                        yyPstmt.setString(1, cus_id);
                                        yyPstmt.setInt(2, course_id);
                                        yyPstmt.executeUpdate();

                                        System.out.println("预约成功！");
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("您预约的课程已满！");
                    }
                }
            }
        }
        connection.close();
    }

}



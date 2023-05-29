package Appointment;

import Common.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PublicCourseManagement {
    public void publiccoursemanagement() throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Connection connection = null;
        Scanner sc = new Scanner(System.in);

        try {
            connection = dc.getConnection();
            System.out.print("请输入课程id：");
            int courseId = Integer.parseInt(sc.nextLine());

            System.out.print("请输入教学星期：");
            String week = sc.nextLine();

            System.out.print("请输入教学时间：");
            String time = sc.nextLine();

            System.out.print("请输入课程项目：");
            String course = sc.nextLine();

            System.out.print("请输入教师id：");
            int teacherId = Integer.parseInt(sc.nextLine());

            System.out.print("请输入教师名字：");
            String teacherName = sc.nextLine();

            System.out.print("请输入教学地点：");
            String room = sc.nextLine();

            System.out.print("请输入时间id：");
            int timeId = Integer.parseInt(sc.nextLine());

            System.out.print("请输入最高人数：");
            int upperlimit = Integer.parseInt(sc.nextLine());

            // 插入数据
            String sql = "INSERT INTO public_timetable (course_id, week, time, course, teacher_id, teacher_name, room, time_id, upper_limit) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, courseId);
                stmt.setString(2, week);
                stmt.setString(3, time);
                stmt.setString(4, course);
                stmt.setInt(5, teacherId);
                stmt.setString(6, teacherName);
                stmt.setString(7, room);
                stmt.setInt(8, timeId);
                stmt.setInt(9, upperlimit);

                int affectedRows = stmt.executeUpdate();
                System.out.println(affectedRows + " 条课程信息已录入！");
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

}

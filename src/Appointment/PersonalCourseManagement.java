package Appointment;

import Common.DatabaseConnector;
import java.sql.*;
import java.util.Scanner;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class PersonalCourseManagement {
    public void personalcm() throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Scanner sc = new Scanner(System.in);
            System.out.print("请输入课程id：");
            int courseId = sc.nextInt();
            sc.nextLine(); // 消耗换行符

            System.out.print("请输入课程名称：");
            String course = sc.nextLine();

            System.out.print("请输入教师名字：");
            String teacherName = sc.nextLine();

            System.out.print("请输入教学地点：");
            String room = sc.nextLine();

            System.out.print("请输入教学日期：");
            String week = sc.nextLine();

            System.out.print("请输入教学时间（格式：HH:mm:ss）：");
            String timeStr = sc.nextLine();

            Time time;
            try {
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                java.util.Date parsedTime = timeFormat.parse(timeStr);
                time = new Time(parsedTime.getTime());
            } catch (ParseException e) {
                System.out.println("时间格式无效！请使用 HH:mm:ss 格式。");
                return;
            }

            System.out.print("请输入学员id：");
            int cusId = sc.nextInt();

            String sql = "INSERT INTO personal_timetable (course_id, course, teacher_name, room, week, time, cus_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (Connection connection = dc.getConnection();
                 PreparedStatement stmt = connection.prepareStatement(sql)) {

                stmt.setInt(1, courseId);
                stmt.setString(2, course);
                stmt.setString(3, teacherName);
                stmt.setString(4, room);
                stmt.setString(5, week);
                stmt.setTime(6, time);
                stmt.setInt(7, cusId);

                int affectedRows = stmt.executeUpdate();
                System.out.println(affectedRows + " 条课程数据被插入！");
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Number Format Exception: " + e.getMessage());
            }

    }
}

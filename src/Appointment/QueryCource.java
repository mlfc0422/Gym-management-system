package Appointment;

import database.DatabaseConnector;
import java.util.Scanner;
import java.sql.*;

public class QueryCource {
    public void querycource() throws SQLException {
        DatabaseConnector dc = new DatabaseConnector();
        Connection connection = dc.getConnection();
        ResultSet resultSet = null;
        Scanner sc = new Scanner(System.in);
        int choice1, choice2, choice3, choice4;

        System.out.println("请选择查询条件:\n1.全部\n2.教练\n3.课程\n4.时间");
        choice1 = sc.nextInt();

        switch (choice1) {
            case 1: {
                String query = "SELECT * FROM public_timetable";
                Statement stmt = connection.createStatement();
                resultSet = stmt.executeQuery(query);
                printQueryResult(resultSet);
                break;
            }
            case 2: {
                System.out.println("你想查看哪位老师的课程：1.张老师\n2.李老师\n3.王老师\n4.陈老师");
                choice2 = sc.nextInt();
                String teacher_name = null;
                if (choice2 == 1) {
                    teacher_name = "张三";
                } else if (choice2 == 2) {
                    teacher_name = "李四";
                } else if (choice2 == 3) {
                    teacher_name = "王五";
                } else if (choice2 == 4) {
                    teacher_name = "赵六";
                }
                String tc_query = "SELECT * FROM public_timetable WHERE teacher_name = ?";
                PreparedStatement pstmt = connection.prepareStatement(tc_query);
                pstmt.setString(1, teacher_name);
                resultSet = pstmt.executeQuery();
                printQueryResult(resultSet);
                break;
            }
            case 3: {
                System.out.println("你想查看哪个课程：1.瑜伽\n2.篮球训练\n3.游泳课程\n4.健身操课程");
                choice2 = sc.nextInt();
                String course = null;
                if (choice2 == 1) {
                    course = "瑜伽";
                } else if (choice2 == 2) {
                    course = "篮球训练";
                } else if (choice2 == 3) {
                    course = "游泳课程";
                } else if (choice2 == 4) {
                    course = "健身操课程";
                }
                String tc_query = "SELECT * FROM public_timetable WHERE course = ?";
                PreparedStatement pstmt = connection.prepareStatement(tc_query);
                pstmt.setString(1, course);
                resultSet = pstmt.executeQuery();
                printQueryResult(resultSet);
                break;
            }
            case 4: {
                sc.nextLine(); // Consume the newline character
                System.out.println("请输入要查询的星期几（例如:周一）:");
                String Week = sc.nextLine();

                System.out.println("请输入要查询的时间段:\n1.8:00-10:00\n2.10:00-12:00\n3.2:30-4:30\n4.4:30-6:30\n5.7:30-9:30");
                int time_id = sc.nextInt();

                String query = "SELECT * FROM public_timetable WHERE week = ? AND time_id = ?";
                PreparedStatement pstmt = connection.prepareStatement(query);
                pstmt.setString(1, Week);
                pstmt.setInt(2, time_id);
                resultSet = pstmt.executeQuery();
                printQueryResult(resultSet);
                break;
            }
            default:
                System.out.println("无效的选择，请重新输入。");
                break;
        }

        // 关闭资源
        if (resultSet != null) {
            resultSet.close();
        }
        connection.close();
    }

    // 打印查询结果的方法
    private void printQueryResult(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        // 打印表头
        for (int i = 1; i <= columnCount; i++) {
            System.out.printf("%-15s",metaData.getColumnName(i));
        }
        System.out.println();

        // 打印每行数据
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-15s",resultSet.getString(i));
            }
            System.out.println();
        }
    }
}
import User.Personal_Data;
import java.sql.*;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("欢迎使用");
        System.out.println("请选择你的身份");
        Personal_Data personalData = new Personal_Data();

        // 调用personal_data方法
        try {
            personalData.personal_data();
        } catch (SQLException e) {
            System.out.println("运行personal_data方法出错：" + e.getMessage());
        }

    }
}
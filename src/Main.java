import User.Personal_Data;
import User.login;
import User.registration;

import java.sql.*;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("欢迎使用");
        System.out.println("请选择你的身份");
        Personal_Data personalData = new Personal_Data();
        login lg = new login();
        registration rt = new registration();

        try {
            rt.register();
        } catch (SQLException e) {
            System.out.println("运行registration方法出错：" + e.getMessage());
        }

        try {
            lg.logOn();
        } catch (SQLException e) {
            System.out.println("运行logOn方法出错：" + e.getMessage());
        }
        // 调用personal_data方法
        try {
            personalData.personal_data();
        } catch (SQLException e) {
            System.out.println("运行personal_data方法出错：" + e.getMessage());
        }
    }
}
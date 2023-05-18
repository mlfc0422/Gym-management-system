import User.Personal_Data;
import User.login;
import User.registration;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
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

        login loginObj = new login();
        try {
            String cus_id = loginObj.logOn(); // 调用登录方法，并获取 cus_id 值
            if (!cus_id.isEmpty()) {
                Personal_Data pd = new Personal_Data();
                pd.personal_data(cus_id); // 调用 personal_data 方法，并传递 cus_id 值
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
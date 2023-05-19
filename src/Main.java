import User.Personal_Data;
import User.login;
import User.registration;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Personal_Data pd = new Personal_Data();
        login lg = new login();
        registration rt = new registration();
        String cus_id = "";

        System.out.println("欢迎使用健身房管理系统");
        System.out.println("请选择你的身份");
        System.out.println("1.会员\n2.员工");

        int identity = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            if (sc.hasNextInt()) {
                identity = sc.nextInt();
                if (identity == 1 || identity == 2) {
                    isValidInput = true;
                } else {
                    System.out.println("无效的选项，请重新输入：");
                }
            } else {
                System.out.println("无效的选项，请重新输入：");
                sc.next(); // 清除输入缓冲区
            }
        }

        if (identity == 1) {
            System.out.println("是否已经有账号");
            System.out.println("1.已经有账户\n2.还没有账户");
            int Account = sc.nextInt();
            while(true) {
                if (Account == 1) {
                    boolean loginSuccess = lg.logOn();
                    if (loginSuccess) {
                        cus_id = lg.getCustomerId();
                        while (true) {
                            System.out.println("请选择要使用的功能：\n1.查询个人信息\n2.其他功能");
                            int function = sc.nextInt();
                            switch (function) {
                                case 1: {
                                    pd.personal_data(cus_id);
                                    break;
                                }
                                case 2: {
                                    // 其他功能代码
                                    break;
                                }
                                default: {
                                    System.out.println("无效的选项，请重新选择。");
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("请重新尝试！");
                    }
                } else if (Account == 2) {
                    rt.register();
                    while(true) {
                        boolean loginSuccess = lg.logOn();
                        if (loginSuccess) {
                            while (true) {
                                System.out.println("请选择要使用的功能：\n1.查询个人信息\n2.其他功能");
                                int function = sc.nextInt();
                                switch (function) {
                                    case 1: {
                                        pd.personal_data(cus_id);
                                        break;
                                    }
                                    case 2: {
                                        // 其他功能代码
                                        break;
                                    }
                                    default: {
                                        System.out.println("无效的选项，请重新选择。");
                                        break;
                                    }
                                }
                            }
                        } else {
                            System.out.println("请重新尝试！");
                        }
                    }
                }
            }
        } else if (identity == 2) {
            // 员工身份代码
        }
    }
}
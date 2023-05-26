import Employee.EmpData;
import User.*;
import Employee.root_login;
import java.sql.SQLException;
import java.util.Scanner;
import  Appointment.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Personal_Data pd = new Personal_Data();
        user_login lg = new user_login();
        root_login lg1 = new root_login();
        registration rt = new registration();
        BookLesson bk = new BookLesson();
        EdPersonData epd = new EdPersonData();
        QueryCource qc = new QueryCource();
        queryPersonalCource qpc = new queryPersonalCource();
        EmpData ed = new EmpData();
        String cus_id;
        String root_id;

        System.out.println("欢迎使用健身房管理系统");
        System.out.println("请选择你的身份");
        System.out.println("1.会员\n2.员工");

        int identity = 0;
        boolean isValidInput = false;


        if (identity == 1) {
            System.out.println("是否已经有账号");
            System.out.println("1.已经有账户\n2.还没有账户");
            int Account = sc.nextInt();
            while(true) {
                if (Account == 1) {
                    boolean loginSuccess = lg.logOn1();
                    if (loginSuccess) {
                        cus_id = lg.getCustomerId();
                        while (true) {
                            System.out.println("请选择要使用的功能：\n1.查询个人信息\n2.编辑个人资料\n3.预约课程\n4.查询课程\n5.查询个人课表");
                            int function = sc.nextInt();
                            switch (function) {
                                case 1: {
                                    pd.personal_data(cus_id);
                                    break;
                                }
                                case 2: {
                                    epd.editProfile(cus_id);
                                    break;
                                }
                                case 3:{
                                    bk.bookLesson(cus_id);
                                    break;
                                }
                                case 4:{
                                    qc.querycource();
                                    break;
                                }
                                case 5:{
                                    qpc.querypersonalcource(cus_id);
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
                        boolean loginSuccess = lg.logOn1();
                        if (loginSuccess) {
                            cus_id = lg.getCustomerId();
                            while (true) {
                                System.out.println("请选择要使用的功能：\n1.查询个人信息\n2.编辑个人资料\n3.预约课程\n4.查询课程\n5.查询个人课表");
                                int function = sc.nextInt();
                                switch (function) {
                                    case 1: {
                                        pd.personal_data(cus_id);
                                        break;
                                    }
                                    case 2: {
                                        epd.editProfile(cus_id);
                                        break;
                                    }
                                    case 3:{
                                        bk.bookLesson(cus_id);
                                        break;
                                    }
                                    case 4:{
                                        qc.querycource();
                                        break;
                                    }
                                    case 5:{
                                        qpc.querypersonalcource(cus_id);
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
            lg1.logOn2();
            boolean loginSuccess = lg1.logOn2();
            if(loginSuccess)
            {
                root_id = lg1.getRoot_Id();
                while(true)
                {
                    System.out.println("请选择要使用的功能：\n1.录入员工信息\n2.编辑个人资料\n3.预约课程\n4.查询课程\n5.查询个人课表");
                    int function = sc.nextInt();
                    switch (function)
                    {
                        case 1:
                        {
                            ed.emp_data();
                        }
                    }
                }
            }
        }
    }
}
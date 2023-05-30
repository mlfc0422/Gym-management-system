import Employee.EmpData;
import Employee.EmpDataQuery;
import Facility.EquRegistration;
import User.*;
import Employee.root_login;
import java.sql.SQLException;
import java.util.Scanner;
import Appointment.*;
import Finance.Spend;
import Facility.EquRegistration;

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
        Spend sp = new Spend();
        EquRegistration er = new EquRegistration();
        EmpDataQuery edq = new EmpDataQuery();
        PersonalCourseManagement pcm = new PersonalCourseManagement();
        PublicCourseManagement pcm1 = new PublicCourseManagement();
        FeedBack fd = new FeedBack();

        String cus_id;
        String root_id;

        System.out.println("欢迎使用健身房管理系统");
        System.out.println("请选择你的身份");
        System.out.println("1.会员\n2.管理员");

        int identity;
        boolean isValidInput = false;
        identity = sc.nextInt();

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
                            System.out.println("请选择要使用的功能：\n1.查询个人信息\n2.编辑个人资料\n3.预约课程\n4.查询公共课程\n5.查询个人课表\n6.意见反馈");
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
                                case 6:
                                {
                                    fd.feedback(cus_id);
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
                                System.out.println("请选择要使用的功能：\n1.查询个人信息\n2.编辑个人资料\n3.预约课程\n4.查询课程\n5.查询个人课表\n6.意见反馈");
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
                                    case 6:
                                    {
                                        fd.feedback(cus_id);
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
            boolean loginSuccess = lg1.logOn2();
            if(loginSuccess)
            {
                root_id=lg1.getrootId();
                while(true)
                {
                    System.out.println("请选择要使用的功能：\n1.录入员工信息\n2.记录账单\n3.录入器材信息\n4.查询员工信息\n5.个人课程管理\n6.公共课程管理");
                    int function1 = sc.nextInt();
                    switch (function1)
                    {
                        case 1:
                        {
                            ed.emp_data();
                            break;
                        }
                        case 2:
                        {
                            sp.spend(root_id);
                            break;
                        }
                        case 3:
                        {
                            er.equregistration(root_id);
                            break;
                        }
                        case 4:
                        {
                            edq.empdataquery();
                            break;
                        }
                        case 5:
                        {
                            pcm.personalcm();
                            break;
                        }
                        case 6:
                        {
                            pcm1.publiccoursemanagement();
                            break;
                        }
                        default:
                        {
                            System.out.println("无效的选择，请重新输入");
                            break;
                        }
                    }
                }
            }
        }
    }
}
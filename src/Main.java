
import Common.Obj.obj;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        obj.initializeObjects();

        String cus_id;
        String root_id;

        System.out.println("欢迎使用健身房管理系统");
        System.out.println("请选择你的身份");
        System.out.println("1.会员\n2.管理员");

        int identity = obj.ip.getInput(sc, "请选择你的身份：", 1, 2);

        if (identity == 1) {
            System.out.println("是否已经有账号");
            System.out.println("1.已经有账户\n2.还没有账户");

            int accountOption = obj.ip.getInput(sc, "请选择账号选项：", 1, 2);

            if (accountOption == 1) {
                while (true) {
                    boolean loginSuccess = obj.lg.logOn1();
                    if (loginSuccess) {
                        cus_id = obj.lg.getCustomerId();
                        while (true) {
                            System.out.println("请选择要使用的功能：\n1.查询个人信息\n2.编辑个人资料\n3.预约课程\n4.查询公共课程\n5.查询个人课表\n6.意见反馈");
                            int function = obj.ip.getInput(sc, "请输入功能编号：", 1, 6);

                            switch (function) {
                                case 1: {
                                    obj.pd.personal_data(cus_id);
                                    break;
                                }
                                case 2: {
                                    obj.epd.editProfile(cus_id);
                                    break;
                                }
                                case 3: {
                                    obj.bk.bookLesson(cus_id);
                                    break;
                                }
                                case 4: {
                                    obj.qc.querycource();
                                    break;
                                }
                                case 5: {
                                    obj.qpc.querypersonalcource(cus_id);
                                    break;
                                }
                                case 6: {
                                    obj.fd.feedback(cus_id);
                                    break;
                                }
                                default: {
                                    System.out.println("无效的选项，请重新选择。");
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("登录失败，请重新尝试！");
                    }
                }
            } else if (accountOption == 2) {
                obj.rt.register();
                while (true) {
                    boolean loginSuccess = obj.lg.logOn1();
                    if (loginSuccess) {
                        cus_id = obj.lg.getCustomerId();
                        while (true) {
                            System.out.println("请选择要使用的功能：\n1.查询个人信息\n2.编辑个人资料\n3.预约课程\n4.查询课程\n5.查询个人课表\n6.意见反馈");
                            int function = obj.ip.getInput(sc, "请输入功能编号：", 1, 6);

                            switch (function) {
                                case 1: {
                                    obj.pd.personal_data(cus_id);
                                    break;
                                }
                                case 2: {
                                    obj.epd.editProfile(cus_id);
                                    break;
                                }
                                case 3: {
                                    obj.bk.bookLesson(cus_id);
                                    break;
                                }
                                case 4: {
                                    obj.qc.querycource();
                                    break;
                                }
                                case 5: {
                                    obj.qpc.querypersonalcource(cus_id);
                                    break;
                                }
                                case 6: {
                                    obj.fd.feedback(cus_id);
                                    break;
                                }
                                default: {
                                    System.out.println("无效的选项，请重新选择。");
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("登录失败，请重新尝试！");
                    }
                }
            }
        } else if (identity == 2) {
            while (true) {
                boolean loginSuccess = obj.lg1.logOn2();
                if (loginSuccess) {
                    root_id = obj.lg1.getrootId();
                    while (true) {
                        System.out.println("请选择要使用的功能：\n1.录入员工信息\n2.记录账单\n3.录入器材信息\n4.查询员工信息\n5.个人课程管理\n" +
                                "6.公共课程管理\n7.查看反馈\n8.查询账单\n9.器材查询");
                        int function1 = obj.ip.getInput(sc, "请输入功能编号：", 1, 9);

                        switch (function1) {
                            case 1: {
                                obj.ed.emp_data();
                                break;
                            }
                            case 2: {
                                obj.sp.spend(root_id);
                                break;
                            }
                            case 3: {
                                obj.er.equregistration(root_id);
                                break;
                            }
                            case 4: {
                                obj.edq.empdataquery();
                                break;
                            }
                            case 5: {
                                obj.pcm.personalcm();
                                break;
                            }
                            case 6: {
                                obj.pcm1.publiccoursemanagement();
                                break;
                            }
                            case 7: {
                                obj.mfb.manfeedback();
                                break;
                            }
                            case 8: {
                                obj.qs.queryspend();
                                break;
                            }
                            case 9: {
                                obj.ma.manequ();
                                break;
                            }
                            default: {
                                System.out.println("无效的选择，请重新输入");
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("登录失败，请重新尝试！");
                }
            }
        }
    }

}

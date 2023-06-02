package Common;

import Employee.*;
import Facility.*;
import Finance.*;
import User.*;
import Appointment.*;
public class Obj {
    public class obj {
        public static Personal_Data pd;
        public static UserLogin lg;
        public static RootLogin lg1;
        public static Registration rt;
        public static BookLesson bk;
        public static EdPersonData epd;
        public static QueryCource qc;
        public static QueryPersonalCource qpc;
        public static EmpData ed;
        public static Spend sp;
        public static EquRegistration er;
        public static EmpDataQuery edq;
        public static PersonalCourseManagement pcm;
        public static PublicCourseManagement pcm1;
        public static FeedBack fd;
        public static ManFeedBack mfb;
        public static QuerySpend qs;
        public static ManEqu ma;
        public static IntPut ip;

        public static void initializeObjects() {
            pd = new Personal_Data();
            lg = new UserLogin();
            lg1 = new RootLogin();
            rt = new Registration();
            bk = new BookLesson();
            epd = new EdPersonData();
            qc = new QueryCource();
            qpc = new QueryPersonalCource();
            ed = new EmpData();
            sp = new Spend();
            er = new EquRegistration();
            edq = new EmpDataQuery();
            pcm = new PersonalCourseManagement();
            pcm1 = new PublicCourseManagement();
            fd = new FeedBack();
            mfb = new ManFeedBack();
            qs = new QuerySpend();
            ma = new ManEqu();
            ip = new IntPut();
        }
    }
}

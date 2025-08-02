package lk.ijse.cmjd_110.courseRegisterPro.util;

import java.util.UUID;

public class IDGenerator {
    public static String studentIdGen(){
        return "STU-"+ UUID.randomUUID();
    }
    public static String lecturerIdGen(){
        return "LEC-"+ UUID.randomUUID();
    }

    public static String adminIdGen(){
        return "ADM-"+ UUID.randomUUID();
    }
    public static String courseIdGen(){
        return "CRS-"+ UUID.randomUUID();
    }
    public static String courseMaterialIdGen(){
        return "CMS-"+ UUID.randomUUID();
    }
}

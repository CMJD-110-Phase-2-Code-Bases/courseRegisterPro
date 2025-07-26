package lk.ijse.cmjd_110.courseRegisterPro.util;

import java.util.UUID;

public class IDGenerator {
    public static String studentIdGen(){
        return "STU-"+ UUID.randomUUID();
    }
}

package lk.ijse.cmjd_110.courseRegisterPro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnrollmentDTO implements Serializable {
    private String enrollId;
    private String studentId;
    private String courseId;
    private String enrolledDate;
    private String marks;
    private String grade;
}

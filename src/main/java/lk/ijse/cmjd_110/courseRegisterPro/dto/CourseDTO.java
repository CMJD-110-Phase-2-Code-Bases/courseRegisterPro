package lk.ijse.cmjd_110.courseRegisterPro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO implements Serializable {
    private String courseId;
    private String courseCode;
    private String courseName;
    private String description;
    private Integer credit;
    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private String instructorId;
}

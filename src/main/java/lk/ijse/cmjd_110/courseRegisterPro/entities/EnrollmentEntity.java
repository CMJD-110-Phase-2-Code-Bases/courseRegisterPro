package lk.ijse.cmjd_110.courseRegisterPro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "enrollment")
public class EnrollmentEntity {
    @Id
    private String enrollId;
    @ManyToOne
    @JoinColumn(name = "studentId")
    private StudentEntity student;
    @ManyToOne
    @JoinColumn(name = "courseId")
    private CourseEntity course;
    private String enrolledDate;
    private String marks;
    private String grade;
}

package lk.ijse.cmjd_110.courseRegisterPro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
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

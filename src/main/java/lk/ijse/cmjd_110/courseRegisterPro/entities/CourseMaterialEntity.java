package lk.ijse.cmjd_110.courseRegisterPro.entities;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="course_material")
public class CourseMaterialEntity {
    @Id
    private String materialId;
    private String fileName;
    private String materialType;
    private String material;
    private LocalDateTime uploadAt;
    @ManyToOne
    @JoinColumn(name = "courseId")
    private CourseEntity courseId;
}

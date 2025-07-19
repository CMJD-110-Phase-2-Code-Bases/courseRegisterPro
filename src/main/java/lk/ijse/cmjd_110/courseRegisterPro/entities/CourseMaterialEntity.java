package lk.ijse.cmjd_110.courseRegisterPro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
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

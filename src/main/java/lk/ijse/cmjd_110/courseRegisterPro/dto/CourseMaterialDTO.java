package lk.ijse.cmjd_110.courseRegisterPro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseMaterialDTO implements Serializable {
    private String materialId;
    private String fileName;
    private String materialType;
    private String material;
    private String uploadAt;
    private String courseId;
}

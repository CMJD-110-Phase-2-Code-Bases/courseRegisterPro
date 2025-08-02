package lk.ijse.cmjd_110.courseRegisterPro.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd_110.courseRegisterPro.dao.CourseMaterialDao;
import lk.ijse.cmjd_110.courseRegisterPro.dto.CourseMaterialDTO;
import lk.ijse.cmjd_110.courseRegisterPro.entities.CourseMaterialEntity;
import lk.ijse.cmjd_110.courseRegisterPro.service.CourseMaterialService;
import lk.ijse.cmjd_110.courseRegisterPro.util.EntityDTOConversionHandle;
import lk.ijse.cmjd_110.courseRegisterPro.util.IDGenerator;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.sqm.tree.expression.Conversion;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseMaterialServiceIMPL implements CourseMaterialService {
    private final CourseMaterialDao courseMaterialDao;
    private final EntityDTOConversionHandle conversion;

    @Override
    public void saveCourseMaterial(String fileName, String materialType,
                                   MultipartFile material,
                                   String uploadAt, String courseId) throws IOException {

        //step 1 - Create a DTO based on the received data
        var materialDTO = new CourseMaterialDTO();
        //Step 2 - Build the object
        //Step - 2.1 - Create Byte collection from the Multipart value
        byte[] materialBytes = material.getBytes();
        // step - 2.2 - Create String based on the byte collection
        String materialString = Base64.getEncoder().encodeToString(materialBytes);
        //Step 3 - Create date if not provided
        String uploadTime = uploadAt != null ? uploadAt : LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
        //Step 4 - Set the object fields
        materialDTO.setFileName(fileName);
        materialDTO.setMaterialType(materialType);
        materialDTO.setMaterial(materialString);
        materialDTO.setUploadAt(uploadTime);
        materialDTO.setCourseId(courseId);

        var courseMaterialEntity = conversion.toCourseMaterialEntity(materialDTO);
        courseMaterialEntity.setMaterialId(IDGenerator.courseMaterialIdGen());
        courseMaterialDao.save(courseMaterialEntity);
    }
    @Override
    public void deleteCourseMaterial(String courseMaterialId) throws Exception {
        Optional<CourseMaterialEntity> foundCourse =
                courseMaterialDao.findById(courseMaterialId);
        if (!foundCourse.isPresent()) {
            throw new Exception("Course Material not found");
        }
        courseMaterialDao.deleteById(courseMaterialId);
    }

    @Override
    public void updateCourseMaterial(String materialId, String fileName, String materialType, MultipartFile material, String uploadAt, String courseId) throws Exception {
        Optional<CourseMaterialEntity> foundCourse =
                courseMaterialDao.findById(materialId);
        if(!foundCourse.isPresent()){
            throw new Exception("Course Material not found");
        }
        byte[] materialBytes = material.getBytes();
        String materialString = Base64.getEncoder().encodeToString(materialBytes);
        String uploadTime = uploadAt != null ? uploadAt : LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);

        foundCourse.get().setFileName(fileName);
        foundCourse.get().setMaterialType(materialType);
        foundCourse.get().setMaterial(materialString);
        foundCourse.get().setUploadAt(uploadTime);
        foundCourse.get().getCourse().setCourseId(courseId);

    }

    @Override
    public CourseMaterialDTO getSelectedCourseMaterial(String courseMaterialId) throws Exception {
        Optional<CourseMaterialEntity> foundCourse =
                courseMaterialDao.findById(courseMaterialId);
        if(!foundCourse.isPresent()){
            throw new Exception("Course Material not found");
        }
        return conversion.toCourseMaterialDTO(
                courseMaterialDao.getReferenceById(courseMaterialId));
    }

    @Override
    public List<CourseMaterialDTO> getAllCourseMaterials() {
        return conversion.toCourseMaterialDTOList(courseMaterialDao.findAll());
    }
}

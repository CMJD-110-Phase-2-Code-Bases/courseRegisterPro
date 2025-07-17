package lk.ijse.cmjd_110.courseRegisterPro.controller;

import lk.ijse.cmjd_110.courseRegisterPro.dto.CourseMaterialDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@RestController
@RequestMapping("api/v1/material")
public class CourseMaterialController {
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseMaterialDTO> saveMaterial(
            @RequestParam("materialIdentity") String materialId,
            @RequestParam String fileName,
            @RequestParam String materialType,
            @RequestParam MultipartFile material,
            @RequestParam(required = false) String uploadAt,
            @RequestParam String courseId
    ) {
        //Step - 1: Create an object from incoming multipart data
        var courseMaterial= new CourseMaterialDTO();

        try {
        // Step-2: Build a multipart file as a String
            //Step 2.1: Create a Byte collection from the Multipart file
            byte [] materialBytes = material.getBytes();
            //Step 2.2: Develop a Base64 String based on the byte collection
            String base64Material = Base64.getEncoder().encodeToString(materialBytes);
        //Step-3: Handle upload time
            String uploadTime = uploadAt != null ? uploadAt : LocalDate.now().format(DateTimeFormatter.ISO_DATE);

        //Step-4: Build the entire object
            courseMaterial.setMaterialId(materialId);
            courseMaterial.setMaterialType(materialType);
            courseMaterial.setFileName(fileName);
            courseMaterial.setMaterial(base64Material);
            courseMaterial.setUploadAt(uploadTime);
            courseMaterial.setCourseId(courseId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ResponseEntity.ok(courseMaterial);

    }
}

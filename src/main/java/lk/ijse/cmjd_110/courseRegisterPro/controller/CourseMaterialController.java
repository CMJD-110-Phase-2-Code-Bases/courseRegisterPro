package lk.ijse.cmjd_110.courseRegisterPro.controller;

import lk.ijse.cmjd_110.courseRegisterPro.dto.CourseMaterialDTO;
import lk.ijse.cmjd_110.courseRegisterPro.exception.CourseMaterialNotFoundException;
import lk.ijse.cmjd_110.courseRegisterPro.service.CourseMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/material")
@RequiredArgsConstructor
public class CourseMaterialController {
    private final CourseMaterialService courseMaterialService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveMaterial(
            @RequestParam String fileName,
            @RequestParam String materialType,
            @RequestParam MultipartFile material,
            @RequestParam(required = false) String uploadAt,
            @RequestParam String courseId
    ) {
        try {
            courseMaterialService.saveCourseMaterial(fileName, materialType, material, uploadAt, courseId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IOException | CourseMaterialNotFoundException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{materialId}")
    public ResponseEntity<CourseMaterialDTO> getSelectedCourseMaterial(@PathVariable String materialId) {
        try {
            return new ResponseEntity<>(courseMaterialService.getSelectedCourseMaterial(materialId), HttpStatus.OK);
        } catch (CourseMaterialNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{matId}")
    public ResponseEntity<Void> deleteCourseMaterial(@PathVariable ("matId") String courseMaterialId) {
        try {
            courseMaterialService.deleteCourseMaterial(courseMaterialId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CourseMaterialNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{materialId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateCourseMaterial(@PathVariable ("materialId") String courseMaterialId,
                                                     @RequestParam String fileName,
                                                     @RequestParam String materialType,
                                                     @RequestParam MultipartFile material,
                                                     @RequestParam(required = false) String uploadAt,
                                                     @RequestParam String courseId
    ) {
        try {
            courseMaterialService.updateCourseMaterial(courseMaterialId, fileName, materialType, material, uploadAt, courseId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IOException | CourseMaterialNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<CourseMaterialDTO>> getAllMaterials() {
        return new ResponseEntity<>(courseMaterialService.getAllCourseMaterials(), HttpStatus.OK);
    }
}

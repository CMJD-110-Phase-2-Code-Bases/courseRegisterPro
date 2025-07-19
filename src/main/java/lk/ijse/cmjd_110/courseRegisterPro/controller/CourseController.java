package lk.ijse.cmjd_110.courseRegisterPro.controller;

import lk.ijse.cmjd_110.courseRegisterPro.dto.CourseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {
    @PostMapping
    public ResponseEntity<CourseDTO>saveCourse(CourseDTO courseDTO){
        return new ResponseEntity<>(courseDTO, HttpStatus.CREATED);
    }
    @GetMapping("{courseId}")
    public ResponseEntity<CourseDTO> getSelectedCourse(@PathVariable String courseId){
        return null;
    }
    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(){
        return null;
    }
    @DeleteMapping("{courseId}")
    public void deleteCourse(@PathVariable String courseId){

    }
    @PatchMapping("{courseId}")
    public void updateCourse(@PathVariable String courseId,CourseDTO courseDTO){

    }

}

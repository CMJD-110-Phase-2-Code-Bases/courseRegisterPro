package lk.ijse.cmjd_110.courseRegisterPro.controller;

import lk.ijse.cmjd_110.courseRegisterPro.dto.CourseDTO;
import lk.ijse.cmjd_110.courseRegisterPro.exception.CourseNotFoundException;
import lk.ijse.cmjd_110.courseRegisterPro.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<Void>saveCourse(@RequestBody CourseDTO courseDTO){
        courseService.saveCourse(courseDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("{courseId}")
    public ResponseEntity<CourseDTO> getSelectedCourse(@PathVariable String courseId) {
        try {
            return new ResponseEntity<>(courseService.getSelectedCourse(courseId), HttpStatus.OK);
        } catch (CourseNotFoundException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(){
        return new ResponseEntity<>(courseService.getAllCourses(),HttpStatus.OK);
    }
    @DeleteMapping("{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String courseId){
        try {
            courseService.deleteCourse(courseId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CourseNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping("{courseId}")
    public ResponseEntity<Void> updateCourse(@PathVariable String courseId,
                                             @RequestBody CourseDTO courseDTO){
        try {
            courseService.updateCourse(courseId,courseDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CourseNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

package lk.ijse.cmjd_110.courseRegisterPro.controller;

import lk.ijse.cmjd_110.courseRegisterPro.dto.EnrollmentDTO;
import lk.ijse.cmjd_110.courseRegisterPro.exception.EnrollmentNotFoundException;
import lk.ijse.cmjd_110.courseRegisterPro.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/enrollment")
@RestController
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentDTO> saveEnrollment(@RequestBody EnrollmentDTO enrollment){
        return new ResponseEntity<>(enrollment, HttpStatus.CREATED);
    }
    @GetMapping("{enrollmentId}")
    public ResponseEntity<EnrollmentDTO> getSelectedEnrollment(@PathVariable String enrollmentId){
        try {
            return new ResponseEntity<>(enrollmentService.getSelectedEnrollment(enrollmentId), HttpStatus.OK);
        }catch (EnrollmentNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> getAllEnrollment(){
        return new ResponseEntity<>(enrollmentService.getAllEnrollments(), HttpStatus.OK);
    }
    @DeleteMapping("{enrollmentId}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable String enrollmentId){
        try {
            enrollmentService.deleteEnrollment(enrollmentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (EnrollmentNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping("{enrollmentId}")
    public ResponseEntity<Void> updateEnrollment(@PathVariable String enrollmentId, @RequestBody EnrollmentDTO enrollment){
       try {
            enrollmentService.updateEnrollment(enrollmentId, enrollment);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }catch (EnrollmentNotFoundException e){
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

       }catch (Exception e) {
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

       }
    }
}

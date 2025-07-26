package lk.ijse.cmjd_110.courseRegisterPro.controller.common;

import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveStudent(@RequestBody UserDTO studentDTO){
        studentService.saveStudent(studentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "{studentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedStudent(@PathVariable String studentId){
        try {
            var selectedStudent = new UserDTO();
            selectedStudent = studentService.getSelectedStudent(studentId);
            return new ResponseEntity<>(selectedStudent,HttpStatus.OK);
        }catch (Exception ex){
            //Todo: insert a log
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllStudent(){
        return new  ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
    @PatchMapping
    public ResponseEntity<Void> updateStudent(@RequestParam ("id") String studentId,
                              @RequestBody UserDTO toBeUpdatedStudentDetails){
        try {
            studentService.updateStudent(studentId,toBeUpdatedStudentDetails);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String studentId){
        try {
            studentService.deleteStudent(studentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}


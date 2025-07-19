package lk.ijse.cmjd_110.courseRegisterPro.controller;

import lk.ijse.cmjd_110.courseRegisterPro.dto.Role;
import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.service.StudentService;
import lk.ijse.cmjd_110.courseRegisterPro.service.impl.StudentServiceIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveStudent(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
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
    public void updateStudent(@RequestParam ("stuId") String studentId,
                              @RequestParam String stuCity, @RequestBody UserDTO toBeUpdatedStudentDetails){
        System.out.println("Student ID: "+studentId);
        System.out.println("Student City: "+stuCity);
        System.out.println("To be updated details "+toBeUpdatedStudentDetails);
    }
    @DeleteMapping
    public void deleteStudent(@RequestHeader ("X-studentId") String studentId){
        System.out.println("To be deleted ID: "+studentId);
    }


}


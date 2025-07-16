package lk.ijse.cmjd_110.courseRegisterPro.controller;

import lk.ijse.cmjd_110.courseRegisterPro.dto.Role;
import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
     //Todo: Handle Student's details as CRUD operation

    //Save Student
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveStudent(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }
    @GetMapping(value = "{studentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedStudent(@PathVariable String studentId){
        System.out.println("Student ID is "+studentId);
        var userDTO = new UserDTO(
                "STU001",
                "John",
                "Doe",
                "john.doe@example.com",
                "123 Main Street",
                "Apartment 4B",
                "Near Central Park",
                "New York",
                "securePass123",
                Role.STUDENT
        );
        if(studentId.equals(userDTO.getUserId())){
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}


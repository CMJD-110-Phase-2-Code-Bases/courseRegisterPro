package lk.ijse.cmjd_110.courseRegisterPro.controller;

import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.service.LecturerService;
import lk.ijse.cmjd_110.courseRegisterPro.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/lecturer")
@RequiredArgsConstructor
public class LecturerController {
    private final LecturerService lecturerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveLecturer(@RequestBody UserDTO lecturer){
        return new ResponseEntity<>(lecturer, HttpStatus.CREATED);
    }
    @GetMapping(value = "{lecturerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedLecturer(@PathVariable String lecturerId){
        try {
            return new ResponseEntity<>(lecturerService.getSelectedLecturer(lecturerId),HttpStatus.OK);
        }catch (Exception ex){
            //Todo: insert a log
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllLecturers(){
        return new  ResponseEntity<>(lecturerService.getAllLecturers(), HttpStatus.OK);
    }
    @PatchMapping
    public void updateLecturer(@RequestParam ("lecId") String lecturerId,
                              @RequestParam String lectCity, @RequestBody UserDTO toBeUpdatedLecturerDetails){
        System.out.println("Lecturer ID: "+lecturerId);
        System.out.println("Lecturer City: "+lectCity);
        System.out.println("To be updated details "+toBeUpdatedLecturerDetails);
    }
    @DeleteMapping
    public void deleteLecturer(@RequestHeader ("X-lecturerId") String lecturerId){
        System.out.println("To be deleted ID: "+lecturerId);
    }


}


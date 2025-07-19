package lk.ijse.cmjd_110.courseRegisterPro.controller;

import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.service.AdminService;
import lk.ijse.cmjd_110.courseRegisterPro.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveAdmin(@RequestBody UserDTO admin){
        return new ResponseEntity<>(admin, HttpStatus.CREATED);
    }
    @GetMapping(value = "{adminId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedLecturer(@PathVariable String adminId){
        try {
            return new ResponseEntity<>(adminService.getSelectedAdmin(adminId),HttpStatus.OK);
        }catch (Exception ex){
            //Todo: insert a log
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllAdmins(){
        return new  ResponseEntity<>(adminService.getAllAdmins(), HttpStatus.OK);
    }
    @PatchMapping
    public void updateAdmin(@RequestParam ("admId") String adminId,
                              @RequestParam String admCity, @RequestBody UserDTO toBeUpdatedAdminDetails){
        System.out.println("Admin ID: "+adminId);
        System.out.println("Admin City: "+admCity);
        System.out.println("To be updated details "+toBeUpdatedAdminDetails);
    }
    @DeleteMapping
    public void deleteAdmin(@RequestHeader ("X-adminId") String adminId){
        System.out.println("To be deleted ID: "+adminId);
    }


}


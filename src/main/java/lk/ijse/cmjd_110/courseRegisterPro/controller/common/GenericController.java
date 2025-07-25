package lk.ijse.cmjd_110.courseRegisterPro.controller.common;
import lk.ijse.cmjd_110.courseRegisterPro.service.GenericUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public abstract class GenericController<T> {
   private final GenericUserService<T> userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveUser(@RequestBody T user){
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> getSelectedUser(@PathVariable String id){
        try {
            return new ResponseEntity<>(userService.getSelectedUser(id),HttpStatus.OK);
        }catch (Exception ex){
            //Todo: insert a log
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<T>> getAllUsers(){
        return new  ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @PatchMapping
    public ResponseEntity<Void> updateUser(@RequestParam ("id") String id,
                                              @RequestBody T toBeUpdatedUserDetails){
        try {
            userService.updateUser(id,toBeUpdatedUserDetails);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id){
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }










}

package lk.ijse.cmjd_110.courseRegisterPro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/heartbeat")
public class HealthTest {
    @GetMapping
    public String studentDataTest(){
        return "Course Register Pro is Running";
    }
}

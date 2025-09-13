package lk.ijse.cmjd_110.courseRegisterPro.controller.secure;

import lk.ijse.cmjd_110.courseRegisterPro.dto.secure.JWTResponse;
import lk.ijse.cmjd_110.courseRegisterPro.dto.secure.SecureUserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.dto.secure.UserLogin;
import lk.ijse.cmjd_110.courseRegisterPro.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping(value = "signin",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTResponse> signIn(@RequestBody UserLogin userLogin) {
        return new ResponseEntity<>(authService.SignIn(userLogin), HttpStatus.OK);
    }
    @PostMapping(value = "signup",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTResponse> signUp(@RequestBody SecureUserDTO secureUserDTO) {
        return new ResponseEntity<>(authService.SignUp(secureUserDTO), HttpStatus.OK);
    }
}

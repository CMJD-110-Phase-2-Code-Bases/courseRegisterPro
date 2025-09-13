package lk.ijse.cmjd_110.courseRegisterPro.service;

import lk.ijse.cmjd_110.courseRegisterPro.dto.secure.JWTResponse;
import lk.ijse.cmjd_110.courseRegisterPro.dto.secure.SecureUserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.dto.secure.UserLogin;

public interface AuthService {
    JWTResponse SignIn(UserLogin userLogin);
    JWTResponse SignUp(SecureUserDTO secureUserDTO);
}

package lk.ijse.cmjd_110.courseRegisterPro.service.impl.secure;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd_110.courseRegisterPro.dto.secure.JWTResponse;
import lk.ijse.cmjd_110.courseRegisterPro.dto.secure.SecureUserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.dto.secure.UserLogin;
import lk.ijse.cmjd_110.courseRegisterPro.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    @Override
    public JWTResponse SignIn(UserLogin userLogin) {
        return null;
    }

    @Override
    public JWTResponse SignUp(SecureUserDTO secureUserDTO) {
        return null;
    }
}

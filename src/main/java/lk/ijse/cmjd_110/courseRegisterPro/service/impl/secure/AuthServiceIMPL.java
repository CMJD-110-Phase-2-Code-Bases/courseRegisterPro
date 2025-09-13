package lk.ijse.cmjd_110.courseRegisterPro.service.impl.secure;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd_110.courseRegisterPro.dao.secure.UserSecureDao;
import lk.ijse.cmjd_110.courseRegisterPro.dto.secure.JWTResponse;
import lk.ijse.cmjd_110.courseRegisterPro.dto.secure.SecureUserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.dto.secure.UserLogin;
import lk.ijse.cmjd_110.courseRegisterPro.entities.secure.SecureUserEntity;
import lk.ijse.cmjd_110.courseRegisterPro.secureConfig.JWTUtils;
import lk.ijse.cmjd_110.courseRegisterPro.service.AuthService;
import lk.ijse.cmjd_110.courseRegisterPro.util.EntityDTOConversionHandle;
import lk.ijse.cmjd_110.courseRegisterPro.util.IDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    private final UserSecureDao userSecureDao;
    private final JWTUtils jwtUtils;
    private final EntityDTOConversionHandle entityDTOConversionHandle;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Override
    public JWTResponse SignIn(UserLogin userLogin) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLogin.getEmail(), userLogin.getPassword()));
        var signedUser = userSecureDao.findByEmail(userLogin.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        var generatedToken = jwtUtils.generateToken(signedUser.getEmail(),signedUser.getAuthorities());
        return JWTResponse.builder().token(generatedToken).build();

    }

    @Override
    public JWTResponse SignUp(SecureUserDTO secureUserDTO) {
        secureUserDTO.setUserId(IDGenerator.userIdGen());
        secureUserDTO.setPassword(passwordEncoder.encode(secureUserDTO.getPassword()));
        var savedUser = userSecureDao.save(entityDTOConversionHandle.toSecureUserEntity(secureUserDTO));
        var genToken = jwtUtils.generateToken(savedUser.getEmail(),savedUser.getAuthorities());
        return JWTResponse.builder().token(genToken).build();
    }
}

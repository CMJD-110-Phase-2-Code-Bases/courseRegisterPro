package lk.ijse.cmjd_110.courseRegisterPro.secureConfig;

import lk.ijse.cmjd_110.courseRegisterPro.dao.secure.UserSecureDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserSecureDao userSecureDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userSecureDao.findByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}

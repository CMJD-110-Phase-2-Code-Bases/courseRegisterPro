package lk.ijse.cmjd_110.courseRegisterPro.dto.secure;

import lk.ijse.cmjd_110.courseRegisterPro.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SecureUserDTO implements Serializable {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;

}

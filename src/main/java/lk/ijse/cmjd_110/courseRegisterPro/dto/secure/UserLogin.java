package lk.ijse.cmjd_110.courseRegisterPro.dto.secure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLogin implements Serializable {
    private String email;
    private String password;
}

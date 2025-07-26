package lk.ijse.cmjd_110.courseRegisterPro.entities;

import jakarta.persistence.*;
import lk.ijse.cmjd_110.courseRegisterPro.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "lecturer")
public class LecturerEntity {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}

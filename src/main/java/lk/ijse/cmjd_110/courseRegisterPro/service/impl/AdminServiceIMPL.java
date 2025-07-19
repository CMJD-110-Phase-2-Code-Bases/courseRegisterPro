package lk.ijse.cmjd_110.courseRegisterPro.service.impl;

import lk.ijse.cmjd_110.courseRegisterPro.dto.Role;
import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class AdminServiceIMPL implements AdminService {
    @Override
    public void saveAdmin(UserDTO lecturer) {

    }

    @Override
    public UserDTO getSelectedAdmin(String adminId) throws Exception {
        UserDTO selectedAdmin =  new UserDTO(
                "ADM001",
                "Nihal",
                "Perera",
                "np@example.com",
                "123 Main Street",
                "Apartment 4B",
                "Near Central Park",
                "New York",
                "securePass123",
                Role.ADMIN
        );
        if(adminId.equals(selectedAdmin.getUserId())){
            return selectedAdmin;
        }
        throw new Exception("Admin member not found");
    }

    @Override
    public List<UserDTO> getAllAdmins() {
        return Arrays.asList(
                new UserDTO("ADMIN02", "Nimal",
                        "Fernando", "nimalf@mail.com",
                        "Lake Road", "Colombo 7",
                        "Colombo", "Colombo",
                        "abc123", Role.ADMIN),

                new UserDTO("ADMIN03", "Sithara",
                        "Jayasinghe", "sithara.j@mail.com",
                        "Temple Lane", "Galle Fort",
                        "Galle", "Galle",
                        "pass456", Role.ADMIN),

                new UserDTO("ADMIN04", "Ruwan",
                        "Silva", "ruwan.s@mail.com",
                        "Hill Street", "Kandy Central",
                        "Kandy", "Kandy",
                        "kandy321", Role.ADMIN),

                new UserDTO("ADMIN05", "Dilani",
                        "Hettiarachchi", "dilani.h@mail.com",
                        "Marine Drive", "Negombo North",
                        "Negombo", "Negombo",
                        "negombo789", Role.ADMIN),

                new UserDTO("ADMIN06", "Suresh",
                        "Wickramasinghe", "suresh.w@mail.com",
                        "Green Avenue", "Matara West",
                        "Matara", "Matara",
                        "matara123", Role.ADMIN)
        );
    }

    @Override
    public void updateAdmin(String lecturerId, UserDTO toBeUpdatedLecturer) {

    }

    @Override
    public void deleteAdmin(String lecturerId) {

    }
}

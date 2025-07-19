package lk.ijse.cmjd_110.courseRegisterPro.service.impl;

import lk.ijse.cmjd_110.courseRegisterPro.dto.Role;
import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.service.LecturerService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class LecturerServiceIMPL implements LecturerService {
    @Override
    public void saveLecturer(UserDTO lecturer) {

    }

    @Override
    public UserDTO getSelectedLecturer(String lectId) throws Exception {
        UserDTO selectedLecturer =  new UserDTO(
                "LEC001",
                "Kasun",
                "Shehan",
                "ks@example.com",
                "123 Main Street",
                "Apartment 4B",
                "Near Central Park",
                "New York",
                "securePass123",
                Role.LECTURER
        );
        if(lectId.equals(selectedLecturer.getUserId())){
            return selectedLecturer;
        }
        throw new Exception("Student not found");
    }

    @Override
    public List<UserDTO> getAllLecturers() {
        return Arrays.asList(
                new UserDTO("LEC02", "Nimal",
                        "Fernando", "nimalf@mail.com",
                        "Lake Road", "Colombo 7",
                        "Colombo", "Colombo",
                        "abc123", Role.LECTURER),

                new UserDTO("LEC03", "Sithara",
                        "Jayasinghe", "sithara.j@mail.com",
                        "Temple Lane", "Galle Fort",
                        "Galle", "Galle",
                        "pass456", Role.LECTURER),

                new UserDTO("LEC04", "Ruwan",
                        "Silva", "ruwan.s@mail.com",
                        "Hill Street", "Kandy Central",
                        "Kandy", "Kandy",
                        "kandy321", Role.LECTURER),

                new UserDTO("LEC05", "Dilani",
                        "Hettiarachchi", "dilani.h@mail.com",
                        "Marine Drive", "Negombo North",
                        "Negombo", "Negombo",
                        "negombo789", Role.LECTURER),

                new UserDTO("LEC06", "Suresh",
                        "Wickramasinghe", "suresh.w@mail.com",
                        "Green Avenue", "Matara West",
                        "Matara", "Matara",
                        "matara123", Role.LECTURER)
        );
    }

    @Override
    public void updateLecturer(String lecturerId, UserDTO toBeUpdatedLecturer) {

    }

    @Override
    public void deleteLecturer(String lecturerId) {

    }
}

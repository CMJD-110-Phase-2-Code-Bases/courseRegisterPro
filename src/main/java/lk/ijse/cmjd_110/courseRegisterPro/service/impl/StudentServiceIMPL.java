package lk.ijse.cmjd_110.courseRegisterPro.service.impl;

import lk.ijse.cmjd_110.courseRegisterPro.dto.Role;
import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {
    @Override
    public void saveStudent(UserDTO student) {

    }

    @Override
    public UserDTO getSelectedStudent(String studentId) {
        return new UserDTO(
                "STU001",
                "John",
                "Doe",
                "john.doe@example.com",
                "123 Main Street",
                "Apartment 4B",
                "Near Central Park",
                "New York",
                "securePass123",
                Role.STUDENT
        );
    }

    @Override
    public List<UserDTO> getAllStudents() {
        return List.of();
    }

    @Override
    public void updateStudent(String studentId, UserDTO toBeUpdatedStudent) {

    }

    @Override
    public void deleteStudent(String studentId) {

    }
}

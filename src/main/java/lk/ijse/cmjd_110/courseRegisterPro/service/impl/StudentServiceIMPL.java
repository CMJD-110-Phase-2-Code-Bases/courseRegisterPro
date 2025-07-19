package lk.ijse.cmjd_110.courseRegisterPro.service.impl;

import lk.ijse.cmjd_110.courseRegisterPro.dto.Role;
import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {
    @Override
    public void saveStudent(UserDTO student) {

    }

    @Override
    public UserDTO getSelectedStudent(String studentId) throws Exception {
        UserDTO selectedStudent =  new UserDTO(
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
        if(studentId.equals(selectedStudent.getUserId())){
            return selectedStudent;
        }
        throw new Exception("Student not found");
    }

    @Override
    public List<UserDTO> getAllStudents() {
        List<UserDTO> studentList = Arrays.asList(
                new UserDTO("STU02", "Nimal",
                        "Fernando", "nimalf@mail.com",
                        "Lake Road", "Colombo 7",
                        "Colombo", "Colombo",
                        "abc123", Role.STUDENT),

                new UserDTO("STU03", "Sithara",
                        "Jayasinghe", "sithara.j@mail.com",
                        "Temple Lane", "Galle Fort",
                        "Galle", "Galle",
                        "pass456", Role.STUDENT),

                new UserDTO("STU04", "Ruwan",
                        "Silva", "ruwan.s@mail.com",
                        "Hill Street", "Kandy Central",
                        "Kandy", "Kandy",
                        "kandy321", Role.STUDENT),

                new UserDTO("STU05", "Dilani",
                        "Hettiarachchi", "dilani.h@mail.com",
                        "Marine Drive", "Negombo North",
                        "Negombo", "Negombo",
                        "negombo789", Role.STUDENT),

                new UserDTO("STU06", "Suresh",
                        "Wickramasinghe", "suresh.w@mail.com",
                        "Green Avenue", "Matara West",
                        "Matara", "Matara",
                        "matara123", Role.STUDENT)
        );
        return studentList;
    }

    @Override
    public void updateStudent(String studentId, UserDTO toBeUpdatedStudent) {

    }

    @Override
    public void deleteStudent(String studentId) {

    }
}

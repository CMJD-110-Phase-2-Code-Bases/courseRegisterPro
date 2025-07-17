package lk.ijse.cmjd_110.courseRegisterPro.service;

import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;

import java.util.List;

public interface StudentService {
    void saveStudent(UserDTO student);
    UserDTO getSelectedStudent(String studentId);
    List<UserDTO> getAllStudents();
    void updateStudent(String studentId,UserDTO toBeUpdatedStudent);
    void deleteStudent(String studentId);
}

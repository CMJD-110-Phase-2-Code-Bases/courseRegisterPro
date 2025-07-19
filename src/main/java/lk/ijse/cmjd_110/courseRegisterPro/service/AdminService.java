package lk.ijse.cmjd_110.courseRegisterPro.service;

import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;

import java.util.List;

public interface AdminService {
    void saveAdmin(UserDTO lecturer);
    UserDTO getSelectedAdmin(String studentId) throws Exception;
    List<UserDTO> getAllAdmins();
    void updateAdmin(String lecturerId,UserDTO toBeUpdatedLecturer);
    void deleteAdmin(String lecturerId);
}

package lk.ijse.cmjd_110.courseRegisterPro.service;

import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;

import java.util.List;

public interface LecturerService {
    void saveLecturer(UserDTO lecturer);
    UserDTO getSelectedLecturer(String studentId) throws Exception;
    List<UserDTO> getAllLecturers();
    void updateLecturer(String lecturerId,UserDTO toBeUpdatedLecturer);
    void deleteLecturer(String lecturerId);
}

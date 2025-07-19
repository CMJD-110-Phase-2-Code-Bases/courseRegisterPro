package lk.ijse.cmjd_110.courseRegisterPro.service.impl;

import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.service.LecturerService;

import java.util.List;

public class LecturerServiceIMPL implements LecturerService {
    @Override
    public void saveLecturer(UserDTO lecturer) {

    }

    @Override
    public UserDTO getSelectedLecturer(String studentId) throws Exception {
        return null;
    }

    @Override
    public List<UserDTO> getAllLecturers() {
        return List.of();
    }

    @Override
    public void updateLecturer(String lecturerId, UserDTO toBeUpdatedLecturer) {

    }

    @Override
    public void deleteLecturer(String lecturerId) {

    }
}

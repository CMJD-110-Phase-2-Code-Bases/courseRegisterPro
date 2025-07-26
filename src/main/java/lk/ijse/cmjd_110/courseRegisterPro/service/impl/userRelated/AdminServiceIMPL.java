package lk.ijse.cmjd_110.courseRegisterPro.service.impl.userRelated;

import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.service.GenericUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceIMPL implements GenericUserService<UserDTO> {

    @Override
    public void saveUser(UserDTO lecturer) {

    }

    @Override
    public UserDTO getSelectedUser(String studentId) throws Exception {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public void updateUser(String lecturerId, UserDTO toBeUpdatedLecturer) {

    }

    @Override
    public void deleteUser(String lecturerId) {

    }
}

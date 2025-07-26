package lk.ijse.cmjd_110.courseRegisterPro.service.impl.userRelated;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd_110.courseRegisterPro.dao.LecturerDao;
import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.service.GenericUserService;
import lk.ijse.cmjd_110.courseRegisterPro.util.EntityDTOConversionHandle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class LecturerServiceIMPL implements GenericUserService<UserDTO> {
    private final LecturerDao lecturerDao;
    private final EntityDTOConversionHandle entityDTOConversionHandle;

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

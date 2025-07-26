package lk.ijse.cmjd_110.courseRegisterPro.service.impl.userRelated;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd_110.courseRegisterPro.dao.LecturerDao;
import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.entities.LecturerEntity;
import lk.ijse.cmjd_110.courseRegisterPro.entities.StudentEntity;
import lk.ijse.cmjd_110.courseRegisterPro.service.GenericUserService;
import lk.ijse.cmjd_110.courseRegisterPro.util.EntityDTOConversionHandle;
import lk.ijse.cmjd_110.courseRegisterPro.util.IDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class LecturerServiceIMPL implements GenericUserService<UserDTO> {
    private final LecturerDao lecturerDao;
    private final EntityDTOConversionHandle entityDTOConversionHandle;

    @Override
    public void saveUser(UserDTO lecturer) {
        var lecturerEntity = entityDTOConversionHandle.toLecturerEntity(lecturer);
        lecturerEntity.setId(IDGenerator.lecturerIdGen());
        lecturerDao.save(lecturerEntity);
    }

    @Override
    public UserDTO getSelectedUser(String lectId) throws Exception {
        Optional<LecturerEntity> foundLecturer = lecturerDao.findById(lectId);
        if(!foundLecturer.isPresent()){
            throw new Exception("Lecturer not found");
        }
       return entityDTOConversionHandle
               .toLecturerDTO(lecturerDao.getReferenceById(lectId));
    }

    @Override
    public List<UserDTO> getAllUsers() {
      return entityDTOConversionHandle.getLecturerDTOList(lecturerDao.findAll());
    }

    @Override
    public void updateUser(String lecturerId, UserDTO toBeUpdatedLecturer) throws Exception {
        Optional<LecturerEntity> foundLecturer = lecturerDao.findById(lecturerId);
        if(!foundLecturer.isPresent()){
            throw new Exception("Lecturer not found");
        }
        foundLecturer.get().setFirstName(toBeUpdatedLecturer.getFirstName());
        foundLecturer.get().setLastName(toBeUpdatedLecturer.getLastName());
        foundLecturer.get().setAddressLine1(toBeUpdatedLecturer.getAddressLine1());
        foundLecturer.get().setAddressLine2(toBeUpdatedLecturer.getAddressLine2());
        foundLecturer.get().setAddressLine3(toBeUpdatedLecturer.getAddressLine3());
        foundLecturer.get().setCity(toBeUpdatedLecturer.getCity());
        foundLecturer.get().setEmail(toBeUpdatedLecturer.getEmail());
        foundLecturer.get().setPassword(toBeUpdatedLecturer.getPassword());
    }

    @Override
    public void deleteUser(String lecturerId) throws Exception {
        Optional<LecturerEntity> foundLecturer = lecturerDao.findById(lecturerId);
        if(!foundLecturer.isPresent()){
            throw new Exception("Lecturer not found");
        }
        lecturerDao.deleteById(lecturerId);
    }
}

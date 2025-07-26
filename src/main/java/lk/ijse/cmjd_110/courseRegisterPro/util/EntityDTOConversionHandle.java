package lk.ijse.cmjd_110.courseRegisterPro.util;

import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.entities.AdminEntity;
import lk.ijse.cmjd_110.courseRegisterPro.entities.LecturerEntity;
import lk.ijse.cmjd_110.courseRegisterPro.entities.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EntityDTOConversionHandle {
   private final ModelMapper modelMapper;

   //Student
    public UserDTO toStudentDTO(StudentEntity student){
        return modelMapper.map(student,UserDTO.class);
    }
    public StudentEntity toStudentEntity(UserDTO userDTO){
        return modelMapper.map(userDTO,StudentEntity.class);
    }
    public List<UserDTO> getStudentDTOList(List<StudentEntity> studentEntityList){
        return modelMapper.map(studentEntityList,new TypeToken<List<UserDTO>>(){}.getType());
    }

    //Lecturer
    public UserDTO toLecturerDTO(LecturerEntity lecturer){
        return modelMapper.map(lecturer,UserDTO.class);
    }
    public LecturerEntity toLecturerEntity(UserDTO lecturerDTO){
        return modelMapper.map(lecturerDTO,LecturerEntity.class);
    }
    public List<UserDTO> getLecturerDTOList(List<LecturerEntity> lecturerEntityList){
        return modelMapper.map(lecturerEntityList,new TypeToken<List<UserDTO>>(){}.getType());
    }

    //Admin
    public UserDTO toAdminDTO(AdminEntity admin){
        return modelMapper.map(admin,UserDTO.class);
    }
    public AdminEntity toAdminEntity(UserDTO adminDto){
        return modelMapper.map(adminDto,AdminEntity.class);
    }
    public List<UserDTO> getAdminDTOList(List<AdminEntity> adminEntityList){
        return modelMapper.map(adminEntityList,new TypeToken<List<UserDTO>>(){}.getType());
    }

}

package lk.ijse.cmjd_110.courseRegisterPro.util;

import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
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

}

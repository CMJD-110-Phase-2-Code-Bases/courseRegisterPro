package lk.ijse.cmjd_110.courseRegisterPro.util;

import lk.ijse.cmjd_110.courseRegisterPro.dao.LecturerDao;
import lk.ijse.cmjd_110.courseRegisterPro.dto.CourseDTO;
import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.entities.AdminEntity;
import lk.ijse.cmjd_110.courseRegisterPro.entities.CourseEntity;
import lk.ijse.cmjd_110.courseRegisterPro.entities.LecturerEntity;
import lk.ijse.cmjd_110.courseRegisterPro.entities.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EntityDTOConversionHandle {
   private final ModelMapper modelMapper;
   private final LecturerDao lecturerDao;

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

    //Course
    public CourseDTO toCourseDTO(CourseEntity courseEntity){
        var courseDTO = new CourseDTO();
        courseDTO.setCourseId(courseEntity.getCourseId());
        courseDTO.setCourseCode(courseEntity.getCourseCode());
        courseDTO.setCourseName(courseEntity.getCourseName());
        courseDTO.setDescription(courseEntity.getDescription());
        courseDTO.setDayOfWeek(courseEntity.getDayOfWeek());
        courseDTO.setCredit(courseEntity.getCredit());
        courseDTO.setStartTime(courseEntity.getStartTime());
        courseDTO.setEndTime(courseEntity.getEndTime());
        if(courseEntity.getInstructorId() != null){
            courseDTO.setInstructorId(courseEntity.getInstructorId().getId());
        }
        return courseDTO;
    }
    public CourseEntity toCourseEntity(CourseDTO courseDTO){
        var courseEntity = new CourseEntity();
        courseEntity.setCourseId(courseDTO.getCourseId());
        courseDTO.setCourseCode(courseEntity.getCourseCode());
        courseEntity.setCourseName(courseDTO.getCourseName());
        courseEntity.setDescription(courseDTO.getDescription());
        courseEntity.setDayOfWeek(courseDTO.getDayOfWeek());
        courseEntity.setCredit(courseDTO.getCredit());
        courseEntity.setStartTime(courseDTO.getStartTime());
        courseEntity.setEndTime(courseDTO.getEndTime());
        if(courseDTO.getInstructorId() != null){
            LecturerEntity lecturer = lecturerDao.findById(courseDTO.getInstructorId())
                    .orElseThrow(() -> new RuntimeException("Lecturer Not Found"));
            courseEntity.setInstructorId(lecturer);
        }
        return courseEntity;
    }
    public List<CourseDTO> toCourseDTOList(List<CourseEntity> courseEntities){
        return courseEntities.stream().map(this::toCourseDTO).toList();
    }
    public List<CourseEntity>toCourseEntityList(List<CourseDTO>courseDTOS){
        return courseDTOS.stream().map(this::toCourseEntity).toList();
    }


}

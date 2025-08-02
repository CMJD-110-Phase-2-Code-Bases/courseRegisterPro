package lk.ijse.cmjd_110.courseRegisterPro.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd_110.courseRegisterPro.dao.CourseDao;
import lk.ijse.cmjd_110.courseRegisterPro.dto.CourseDTO;
import lk.ijse.cmjd_110.courseRegisterPro.dto.Role;
import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.entities.CourseEntity;
import lk.ijse.cmjd_110.courseRegisterPro.entities.StudentEntity;
import lk.ijse.cmjd_110.courseRegisterPro.exception.CourseNotFoundException;
import lk.ijse.cmjd_110.courseRegisterPro.service.CourseService;
import lk.ijse.cmjd_110.courseRegisterPro.util.EntityDTOConversionHandle;
import lk.ijse.cmjd_110.courseRegisterPro.util.IDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseServiceIMPL implements CourseService {
    private final CourseDao courseDao;
    private final EntityDTOConversionHandle ech;

    @Override
    public void saveCourse(CourseDTO course) {
        var courseEntity = ech.toCourseEntity(course);
        courseEntity.setCourseId(IDGenerator.courseIdGen());
        courseDao.save(courseEntity);
    }

    @Override
    public CourseDTO getSelectedCourse(String courseId) throws Exception {
        Optional<CourseEntity> foundCourse = courseDao.findById(courseId);
        if(!foundCourse.isPresent()){
            throw new Exception("Course not found");
        }
       return ech.toCourseDTO(courseDao.getReferenceById(courseId));
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return ech.toCourseDTOList(courseDao.findAll());
    }

    @Override
    public void updateCourse(String courseId, CourseDTO toBeUpdatedCourse) throws Exception {
        Optional<CourseEntity> foundCourse = courseDao.findById(courseId);
        if(!foundCourse.isPresent()){
            throw new CourseNotFoundException("Course not found");
        }
        foundCourse.get().setCourseName(toBeUpdatedCourse.getCourseName());
        foundCourse.get().setCourseCode(toBeUpdatedCourse.getCourseCode());
        foundCourse.get().setDescription(toBeUpdatedCourse.getDescription());
        foundCourse.get().setCredit(toBeUpdatedCourse.getCredit());
        foundCourse.get().setDayOfWeek(toBeUpdatedCourse.getDayOfWeek());
        foundCourse.get().setStartTime(toBeUpdatedCourse.getStartTime());
        foundCourse.get().setEndTime(toBeUpdatedCourse.getEndTime());
        foundCourse.get().getInstructorId().setId(toBeUpdatedCourse.getInstructorId());
    }

    @Override
    public void deleteCourse(String courseId) throws Exception {
        Optional<CourseEntity> foundCourse = courseDao.findById(courseId);
        if(!foundCourse.isPresent()){
            throw new Exception("Course not found");
        }
        courseDao.deleteById(courseId);
    }
}

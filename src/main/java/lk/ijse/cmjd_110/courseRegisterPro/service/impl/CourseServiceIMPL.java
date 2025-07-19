package lk.ijse.cmjd_110.courseRegisterPro.service.impl;

import lk.ijse.cmjd_110.courseRegisterPro.dto.CourseDTO;
import lk.ijse.cmjd_110.courseRegisterPro.dto.Role;
import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;
import lk.ijse.cmjd_110.courseRegisterPro.service.CourseService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
@Service
public class CourseServiceIMPL implements CourseService {
    @Override
    public void saveCourse(CourseDTO course) {

    }

    @Override
    public CourseDTO getSelectedCourse(String courseId) throws Exception {
        CourseDTO selectedCourse = new CourseDTO(
                "CSE101",
                "CS101",
                "Introduction to Computer Science",
                "Basic concepts of computing and programming",
                3,
                "Monday",
                LocalTime.of(9, 0),
                LocalTime.of(11, 0),
                "LEC001"
        );
        if(courseId.equals(selectedCourse.getCourseId())){
            return selectedCourse;
        }
        throw new Exception("Course not found");
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return  Arrays.asList(
                new CourseDTO("CSE101", "CS101", "Intro to Computer Science",
                        "Basic computing concepts and programming", 3,
                        "Monday", LocalTime.of(9, 0), LocalTime.of(11, 0), "LECT001"),

                new CourseDTO("MAT201", "MA201", "Discrete Mathematics",
                        "Logic, sets, combinatorics, and graph theory", 4,
                        "Tuesday", LocalTime.of(10, 0), LocalTime.of(12, 0), "LECT002"),

                new CourseDTO("PHY111", "PH111", "Physics for Engineers",
                        "Mechanics, thermodynamics, and electromagnetism", 3,
                        "Wednesday", LocalTime.of(8, 30), LocalTime.of(10, 30), "LECT003"),

                new CourseDTO("ENG102", "EN102", "Academic Writing",
                        "Writing and communication skills for academia", 2,
                        "Thursday", LocalTime.of(13, 0), LocalTime.of(14, 30), "LECT004"),

                new CourseDTO("CSE202", "CS202", "Data Structures",
                        "Implementation and analysis of data structures", 3,
                        "Friday", LocalTime.of(11, 0), LocalTime.of(13, 0), "LECT001")
        );
    }

    @Override
    public void updateCourse(String courseId, CourseDTO toBeUpdatedCourse) {

    }

    @Override
    public void deleteCourse(String courseId) {

    }
}

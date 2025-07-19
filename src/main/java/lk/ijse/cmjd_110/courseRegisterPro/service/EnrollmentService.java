package lk.ijse.cmjd_110.courseRegisterPro.service;

import lk.ijse.cmjd_110.courseRegisterPro.dto.EnrollmentDTO;
import lk.ijse.cmjd_110.courseRegisterPro.dto.UserDTO;

import java.util.List;

public interface EnrollmentService {
    void saveEnrollment(EnrollmentDTO enrollment);
    EnrollmentDTO getSelectedEnrollment(String enrollmentId) throws Exception;
    List<EnrollmentDTO> getAllEnrollments();
    void updateEnrollment(String enrollmentId,EnrollmentDTO toBeUpdatedEnrollment);
    void deleteEnrollment(String enrollmentId);
}

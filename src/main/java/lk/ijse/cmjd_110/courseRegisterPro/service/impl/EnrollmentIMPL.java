package lk.ijse.cmjd_110.courseRegisterPro.service.impl;

import lk.ijse.cmjd_110.courseRegisterPro.dto.EnrollmentDTO;
import lk.ijse.cmjd_110.courseRegisterPro.service.EnrollmentService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class EnrollmentIMPL implements EnrollmentService {
    @Override
    public void saveEnrollment(EnrollmentDTO enrollment) {

    }

    @Override
    public EnrollmentDTO getSelectedEnrollment(String enrollmentId) throws Exception {
        var selectedEnrollment = new EnrollmentDTO(
                "ENR001",
                "STU001",
                "CSE101",
                "2025-01-15",
                "85",
                "A");

        if(enrollmentId.equals(selectedEnrollment.getEnrollId())){
            return selectedEnrollment;
        }
        throw new Exception("Enrollment not found");
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        return Arrays.asList(
                new EnrollmentDTO("ENR002", "STU002", "MAT201", "2025-01-16", "78", "B+"),
                new EnrollmentDTO("ENR003", "STU003", "PHY111", "2025-01-17", "92", "A+"),
                new EnrollmentDTO("ENR004", "STU004", "ENG102", "2025-01-18", "69", "C+"),
                new EnrollmentDTO("ENR005", "STU005", "CSE202", "2025-01-19", "88", "A"),
                new EnrollmentDTO("ENR006", "STU001", "MAT201", "2025-01-16", "81", "A-"),
                new EnrollmentDTO("ENR007", "STU002", "ENG102", "2025-01-18", "75", "B"),
                new EnrollmentDTO("ENR008", "STU006", "CSE101", "2025-01-15", "90", "A+")
        );
    }

    @Override
    public void updateEnrollment(String enrollmentId, EnrollmentDTO toBeUpdatedEnrollment) {

    }

    @Override
    public void deleteEnrollment(String enrollmentId) {

    }
}

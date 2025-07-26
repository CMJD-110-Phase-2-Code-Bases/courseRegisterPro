package lk.ijse.cmjd_110.courseRegisterPro.dao;

import lk.ijse.cmjd_110.courseRegisterPro.entities.LecturerEntity;
import lk.ijse.cmjd_110.courseRegisterPro.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerDao extends JpaRepository<LecturerEntity,String> {

}

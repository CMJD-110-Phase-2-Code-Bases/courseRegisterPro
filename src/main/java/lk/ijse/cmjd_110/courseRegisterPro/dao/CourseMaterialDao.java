package lk.ijse.cmjd_110.courseRegisterPro.dao;

import lk.ijse.cmjd_110.courseRegisterPro.entities.CourseMaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialDao extends JpaRepository<CourseMaterialEntity, String> {
}

package lk.ijse.cmjd_110.courseRegisterPro.dao;

import lk.ijse.cmjd_110.courseRegisterPro.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<AdminEntity,String> {
}

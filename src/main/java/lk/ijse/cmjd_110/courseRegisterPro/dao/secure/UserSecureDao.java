package lk.ijse.cmjd_110.courseRegisterPro.dao.secure;

import lk.ijse.cmjd_110.courseRegisterPro.entities.secure.SecureUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSecureDao extends JpaRepository<SecureUserEntity, String> {
    Optional<SecureUserEntity> findByEmail(String email);
}

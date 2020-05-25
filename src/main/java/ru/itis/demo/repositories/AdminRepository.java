package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.demo.models.User;

@Repository
public interface AdminRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE ems_user u SET state = ?2 WHERE u.id = ?1")
    void changeState(Long id, String state);

    @Query(nativeQuery = true, value = "SELECT state FROM ems_user WHERE id = ?")
    String getState(Long id);
}

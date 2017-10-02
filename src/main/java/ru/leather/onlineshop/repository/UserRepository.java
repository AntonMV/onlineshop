package ru.leather.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.leather.onlineshop.model.User;

import java.time.LocalDate;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query("select b from User b where b.email = :email")
//    User findByName(@Param("email") String email);

//    @Modifying(clearAutomatically = true)
//    @Query("UPDATE Contacts c SET c.name = ?2, c.address = ?3, c.phone = ?4, c.birthday = ?5  WHERE c.id = ?1")
//    void updateEmail(int id, String name, String address, String phone, LocalDate birthday);

    @Query("select b from User b where b.email = ?1")
    User findByName(String email);

    @Query("SELECT count(b.email) FROM User b WHERE b.email = ?1")
    Integer findByAccount(String email);

}

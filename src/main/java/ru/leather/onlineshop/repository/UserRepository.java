package ru.leather.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.leather.onlineshop.model.User;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query("select b from User b where b.email = :email")
//    User findByName(@Param("email") String email);

    @Query("select b from User b where b.email = ?1")
    User findByName(String email);

//    @Modifying(clearAutomatically = true)
//    @Query("UPDATE User c SET c.name = ?2, c.address = ?3,  WHERE c.email = ?1")
//    int updateEmail(String email, String name, String address, );
}

package ru.leather.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.leather.onlineshop.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {

    @Query("select b from Roles b where b.name = ?1")
    Roles findByName(String name);
}

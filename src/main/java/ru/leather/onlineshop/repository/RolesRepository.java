package ru.leather.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.leather.onlineshop.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
}

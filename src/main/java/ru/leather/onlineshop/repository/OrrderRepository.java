package ru.leather.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.leather.onlineshop.model.Orrder;

public interface OrrderRepository extends JpaRepository<Orrder, Integer> {
}

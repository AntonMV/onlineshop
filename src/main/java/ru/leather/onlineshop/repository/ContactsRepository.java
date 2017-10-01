package ru.leather.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.leather.onlineshop.model.Contacts;

public interface ContactsRepository extends JpaRepository<Contacts, Integer> {
}

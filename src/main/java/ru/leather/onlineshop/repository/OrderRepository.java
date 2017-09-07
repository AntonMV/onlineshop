package ru.leather.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.leather.onlineshop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}

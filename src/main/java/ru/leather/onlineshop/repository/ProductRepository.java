package ru.leather.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.leather.onlineshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    @Query("select b from Product b where b.name = :name")
    Product findByName(@Param("name") String name);
}

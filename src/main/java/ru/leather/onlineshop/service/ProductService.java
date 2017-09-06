package ru.leather.onlineshop.service;

import ru.leather.onlineshop.model.Product;

import java.util.List;

public interface ProductService {
    Product addBank(Product product);
    void delete(Integer id);
    Product getByName(String name);
    Product editBank(Product product);
    List<Product> getAll();
}

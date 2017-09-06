package ru.leather.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.leather.onlineshop.model.Product;
import ru.leather.onlineshop.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addBank(Product product) {
        return productRepository.saveAndFlush(product);
    }

    public void delete(Integer id) {
        productRepository.delete(id);
    }

    public Product getByName(String name) {
        return productRepository.findByName(name);
    }

    public Product editBank(Product product) {
        return productRepository.saveAndFlush(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
}

package ru.leather.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.leather.onlineshop.model.Product;
import ru.leather.onlineshop.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @CacheEvict(value="FlushModel")
    public Product addBank(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Transactional
    @CacheEvict(value="FlushModel")
    public void delete(Integer id) {
        productRepository.delete(id);
    }

    @Cacheable(value="CacheModel")
    public Product getByName(String name) {
        return productRepository.findByName(name);
    }

    @Transactional
    @CacheEvict(value="FlushModel")
    public Product editBank(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Cacheable(value="CacheModel")
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}

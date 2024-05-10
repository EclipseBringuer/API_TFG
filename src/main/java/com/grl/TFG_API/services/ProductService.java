package com.grl.TFG_API.services;

import com.grl.TFG_API.model.entity.Product;
import com.grl.TFG_API.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public List<String> getAllCategories() {
        return repository.getDistinctCategories();
    }
}
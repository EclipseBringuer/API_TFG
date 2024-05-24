package com.grl.TFG_API.services;

import com.grl.TFG_API.model.entity.Product;
import com.grl.TFG_API.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Servicio para la gestión de productos.
 */
@Service
public class ProductService {
    private final ProductRepository repository;

    /**
     * Constructor del servicio ProductService.
     *
     * @param repository El repositorio de productos.
     */
    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtiene todos los productos.
     *
     * @return Una lista de todos los productos.
     */
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    /**
     * Obtiene todas las categorías distintas de productos.
     *
     * @return Una lista de todas las categorías distintas.
     */
    public List<String> getAllCategories() {
        return repository.getDistinctCategories();
    }
}
package com.grl.TFG_API.controllers;

import com.grl.TFG_API.model.entity.Product;
import com.grl.TFG_API.services.ProductService;
import com.grl.TFG_API.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con los productos en la API.
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    /**
     * Obtiene todos los productos disponibles.
     *
     * @param token Token de seguridad para autorización.
     * @return ResponseEntity con la lista de productos o estado de error si la autorización falla.
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam("token") String token) {
        if (SecurityService.isTokenValid(token)) {
            return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Obtiene todas las categorías de productos disponibles.
     *
     * @param token Token de seguridad para autorización.
     * @return ResponseEntity con la lista de categorías o estado de error si la autorización falla.
     */
    @GetMapping("/getCategories")
    public ResponseEntity<List<String>> getAllCategories(@RequestParam("token") String token) {
        if (SecurityService.isTokenValid(token)) {
            return new ResponseEntity<>(service.getAllCategories(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
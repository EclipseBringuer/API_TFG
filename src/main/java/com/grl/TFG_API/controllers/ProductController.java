package com.grl.TFG_API.controllers;

import com.grl.TFG_API.model.entity.Product;
import com.grl.TFG_API.services.ProductService;
import com.grl.TFG_API.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam("token") String token) {
        if (SecurityService.isTokenValid(token)) {
            return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/getCategories")
    public ResponseEntity<List<String>> getAllCategories(@RequestParam("token") String token) {
        if (SecurityService.isTokenValid(token)) {
            return new ResponseEntity<>(service.getAllCategories(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
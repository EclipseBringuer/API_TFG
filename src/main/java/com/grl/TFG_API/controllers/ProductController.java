package com.grl.TFG_API.controllers;

import com.grl.TFG_API.services.ProductService;
import com.grl.TFG_API.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;
    @Autowired
    private SecurityService securityService;


}
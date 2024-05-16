package com.grl.TFG_API.controllers;

import com.grl.TFG_API.model.dto.NewOrderDTO;
import com.grl.TFG_API.services.OrderService;
import com.grl.TFG_API.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("/new")
    public ResponseEntity<NewOrderDTO> createNewOrder(@RequestParam("token") String token, @RequestBody NewOrderDTO orderDTO) {
        if (SecurityService.isTokenValid(token)) {
            return new ResponseEntity<>(service.createNewOrder(orderDTO), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/findByUser")
    public ResponseEntity<List<NewOrderDTO>> findOrdersByUserId(@RequestParam("token") String token, @RequestParam("id") Integer userId) {
        if (SecurityService.isTokenValid(token)) {
            return new ResponseEntity<>(service.getOrdersByUserId(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
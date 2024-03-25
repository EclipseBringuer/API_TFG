package com.grl.TFG_API.controllers;

import com.grl.TFG_API.model.entity.User;
import com.grl.TFG_API.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Operation(summary = "Devulve un usuario por sus credenciales")
    @GetMapping("/{gmail}/{password}")
    public ResponseEntity<User> getUserByCredentials(@PathVariable String gmail, @PathVariable String password) {
        return new ResponseEntity<>(service.getByCredentials(gmail, password), HttpStatus.OK);
    }
}
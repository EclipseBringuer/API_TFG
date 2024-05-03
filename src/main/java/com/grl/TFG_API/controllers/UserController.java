package com.grl.TFG_API.controllers;

import com.grl.TFG_API.model.dto.NewUserDTO;
import com.grl.TFG_API.model.entity.User;
import com.grl.TFG_API.services.SecurityService;
import com.grl.TFG_API.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @Operation(summary = "Devulve un usuario por sus credenciales")
    @GetMapping("/{gmail}/{password}")
    public ResponseEntity<User> getUserByCredentials(@PathVariable String gmail, @PathVariable String password) {
        var user = service.getByCredentials(gmail, password);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(summary = "Guarda un nuevo usuario en la base de datos y lo devuelve con el id actualizado")
    @PostMapping("/new")
    public ResponseEntity<User> createNewUser(@RequestParam("token") String token, @RequestBody NewUserDTO newUser) {
        if (SecurityService.isTokenValid(token)) {
            var output = service.saveNewUser(newUser);
            if (output.getId() != 0) {
                return new ResponseEntity<>(output, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(output, HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
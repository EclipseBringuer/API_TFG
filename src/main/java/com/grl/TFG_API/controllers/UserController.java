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

/**
 * Controlador para gestionar las operaciones relacionadas con los usuarios en la API.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    /**
     * Devuelve un usuario por sus credenciales.
     *
     * @param token    Token de seguridad para autorización.
     * @param gmail    Correo electrónico del usuario.
     * @param password Contraseña del usuario.
     * @return ResponseEntity con el usuario correspondiente o estado de error si la autorización falla.
     */
    @Operation(summary = "Devuelve un usuario por sus credenciales")
    @GetMapping("/{gmail}/{password}")
    public ResponseEntity<User> getUserByCredentials(@RequestParam("token") String token, @PathVariable String gmail, @PathVariable String password) {
        if (SecurityService.isTokenValid(token)) {
            return new ResponseEntity<>(service.getByCredentials(gmail, password), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Guarda un nuevo usuario en la base de datos y lo devuelve con el ID actualizado.
     *
     * @param token   Token de seguridad para autorización.
     * @param newUser DTO del nuevo usuario a crear.
     * @return ResponseEntity con el usuario creado o estado de error si la autorización falla.
     */
    @Operation(summary = "Guarda un nuevo usuario en la base de datos y lo devuelve con el id actualizado")
    @PostMapping("/new")
    public ResponseEntity<User> createNewUser(@RequestParam("token") String token, @RequestBody NewUserDTO newUser) {
        if (SecurityService.isTokenValid(token)) {
            return new ResponseEntity<>(service.saveNewUser(newUser), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Actualiza un usuario en la base de datos y lo devuelve con los campos actualizados.
     *
     * @param token   Token de seguridad para autorización.
     * @param updatedUser DTO del nuevo usuario a crear.
     * @return ResponseEntity con el usuario actualizado o estado de error si la autorización falla.
     */
    @Operation(summary = "Actualiza un usuario en la base de datos y lo devuelve con los campos actualizados")
    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestParam("token") String token, @RequestBody NewUserDTO updatedUser) {
        if (SecurityService.isTokenValid(token)) {
            return new ResponseEntity<>(service.updateUser(updatedUser), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
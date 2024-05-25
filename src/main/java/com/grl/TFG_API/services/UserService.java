package com.grl.TFG_API.services;

import com.grl.TFG_API.model.dto.NewUserDTO;
import com.grl.TFG_API.model.entity.User;
import com.grl.TFG_API.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para manejar la lógica de negocio relacionada con los usuarios.
 */
@Service
public class UserService {
    private final UserRepository repository;
    private final DTOTransformationService transformator;

    /**
     * Constructor de la clase UserService.
     *
     * @param repository    Repositorio de usuarios para interactuar con la base de datos.
     * @param transformator Servicio de transformación para convertir entre entidades y DTOs.
     */
    @Autowired
    public UserService(UserRepository repository, DTOTransformationService transformator) {
        this.repository = repository;
        this.transformator = transformator;
    }

    /**
     * Obtiene un usuario por sus credenciales (correo electrónico y contraseña).
     *
     * @param gmail    El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @return El usuario correspondiente a las credenciales, o un nuevo objeto User si no se encuentra.
     */
    public User getByCredentials(String gmail, String password) {
        User output = new User();
        var user = repository.getUserByGmailAndPassword(gmail, password);
        if (user != null) {
            output = user;
            output.setOrders(null); // Limpiar las órdenes del usuario para evitar ciclos en JSON
        }
        return output;
    }

    /**
     * Guarda un nuevo usuario en la base de datos.
     *
     * @param newUser DTO que contiene la información del nuevo usuario.
     * @return El usuario guardado, o un nuevo objeto User si el correo electrónico ya existe.
     */
    public User saveNewUser(NewUserDTO newUser) {
        var output = new User();
        if(!repository.existsByGmail(newUser.gmail())){
            output = repository.save(transformator.convertNewUserDTOIntoUser(newUser));
        }
        return output;
    }

    /**
     * Actualiza un usuario en la base de datos.
     *
     * @param updatedUser DTO que contiene la información del nuevo usuario.
     * @return El usuario guardado, o un nuevo objeto User si el correo electrónico ya existe.
     */
    public User updateUser(NewUserDTO updatedUser) {
        return  repository.save(transformator.convertNewUserDTOIntoUser(updatedUser));
    }
}
package com.grl.TFG_API.repositories;

import com.grl.TFG_API.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz del repositorio para gestionar entidades {@link User}.
 * <p>
 * Esta interfaz extiende JpaRepository para proporcionar operaciones CRUD para las entidades Order.
 * </p>
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * Obtiene un usuario por su correo electrónico y contraseña.
     *
     * @param gmail    El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @return El usuario encontrado, o null si no se encuentra.
     */
    User getUserByGmailAndPassword(String gmail, String password);

    /**
     * Comprueba si un usuario existe por su correo electrónico.
     *
     * @param gmail El correo electrónico del usuario.
     * @return true si el usuario existe, false si no.
     */
    Boolean existsByGmail(String gmail);
}
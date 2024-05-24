package com.grl.TFG_API.model.dto;

/**
 * Clase de registro que representa la información de un nuevo usuario.
 */
public record NewUserDTO(String name, String gmail, String password, String phone, String address) {
}
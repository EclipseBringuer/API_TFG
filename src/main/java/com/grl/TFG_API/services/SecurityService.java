package com.grl.TFG_API.services;

import org.springframework.stereotype.Service;
import java.util.Objects;

/**
 * Servicio de seguridad para validar tokens de autenticación.
 */
@Service
public class SecurityService {
    private static final String SECURITY_TOKEN = "15112004";

    /**
     * Verifica si un token proporcionado es válido.
     *
     * @param token El token que se desea validar.
     * @return true si el token es válido, false en caso contrario.
     */
    public static boolean isTokenValid(String token) {
        return Objects.equals(token, SECURITY_TOKEN);
    }
}
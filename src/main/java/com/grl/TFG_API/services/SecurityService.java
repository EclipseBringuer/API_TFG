package com.grl.TFG_API.services;

import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class SecurityService {
    private static final String SECURITY_TOKEN = "15112004";

    public static boolean isTokenValid(String token) {
        return Objects.equals(token, SECURITY_TOKEN);
    }
}
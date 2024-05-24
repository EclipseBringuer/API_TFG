package com.grl.TFG_API.model.dto;

import com.grl.TFG_API.model.entity.Product;

/**
 * Clase de registro que representa la información de un ítem.
 */
public record ItemInfoDTO(Integer id, Integer amount, Product product) {
}
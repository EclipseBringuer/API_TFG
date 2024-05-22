package com.grl.TFG_API.model.dto;

import com.grl.TFG_API.model.entity.Product;

public record ItemInfoDTO(Integer id, Integer amount, Product product) {
}
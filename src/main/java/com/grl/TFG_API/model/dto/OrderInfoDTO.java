package com.grl.TFG_API.model.dto;

import java.util.List;

public record OrderInfoDTO(Integer id, Double price, String paymentMethod, String state, String delivery,
                           UserInfoDTO user, List<ItemInfoDTO> items) {
}
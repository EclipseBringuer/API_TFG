package com.grl.TFG_API.model.dto;

import com.grl.TFG_API.model.entity.Item;
import com.grl.TFG_API.model.entity.User;
import java.util.List;

public record NewOrderDTO(Integer id, Double price, String paymentMethod, List<Item> items, User user) {
}
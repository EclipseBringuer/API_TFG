package com.grl.TFG_API.services;

import com.grl.TFG_API.model.dto.NewOrderDTO;
import com.grl.TFG_API.model.entity.Item;
import com.grl.TFG_API.model.entity.Order;
import com.grl.TFG_API.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order createNewOrder(NewOrderDTO newOrderDTO) {
        return repository.save(convertOrderDTOToOrder(newOrderDTO));
    }

    private Order convertOrderDTOToOrder(NewOrderDTO newOrderDTO) {
        Order output = new Order();
        output.setId(newOrderDTO.id());
        output.setItems(newOrderDTO.items());
        output.setPrice(newOrderDTO.price());
        output.setUser(newOrderDTO.user());
        output.setPaymentMethod(newOrderDTO.paymentMethod());
        for (Item item : output.getItems()) {
            item.setOrder(output);
        }
        return output;
    }
}
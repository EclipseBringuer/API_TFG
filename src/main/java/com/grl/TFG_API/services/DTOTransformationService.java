package com.grl.TFG_API.services;

import com.grl.TFG_API.model.dto.*;
import com.grl.TFG_API.model.entity.Item;
import com.grl.TFG_API.model.entity.Order;
import com.grl.TFG_API.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DTOTransformationService {
    public User convertNewUserDTOIntoUser(NewUserDTO newUserDTO) {
        User user = new User();
        user.setName(newUserDTO.name());
        user.setAddress(newUserDTO.address());
        user.setPassword(newUserDTO.password());
        user.setPhone(newUserDTO.phone());
        user.setGmail(newUserDTO.gmail());
        return user;
    }

    public Order convertOrderNewDTOToOrder(NewOrderDTO newOrderDTO) {
        Order output = new Order();
        output.setId(newOrderDTO.id());
        output.setItems(newOrderDTO.items());
        output.setPrice(newOrderDTO.price());
        output.setUser(newOrderDTO.user());
        output.setPaymentMethod(newOrderDTO.paymentMethod());
        output.setState(newOrderDTO.state());
        output.setDelivery(newOrderDTO.delivery());
        for (Item item : output.getItems()) {
            item.setOrder(output);
        }
        return output;
    }

    public NewOrderDTO convertOrderToNewDTO(Order order) {
        for (Item item : order.getItems()) {
            item.setOrder(null);
        }
        return new NewOrderDTO(order.getId(), order.getPrice(), order.getPaymentMethod(),
                order.getItems(), null, order.getState(), order.getDelivery());
    }

    public OrderInfoDTO convertOrderToInfoDTO(Order order) {
        return new OrderInfoDTO(order.getId(), order.getPrice(), order.getPaymentMethod(), order.getState(),
                order.getDelivery(), covertUserToInfoDTO(order.getUser()),
                order.getItems().stream().map(this::convertItemToInfoDTO).collect(Collectors.toList()));
    }

    public UserInfoDTO covertUserToInfoDTO(User user) {
        return new UserInfoDTO(user.getName(), user.getPhone(), user.getAddress());
    }

    public ItemInfoDTO convertItemToInfoDTO(Item item) {
        return new ItemInfoDTO(item.getId(), item.getAmount(), item.getProduct());
    }
}
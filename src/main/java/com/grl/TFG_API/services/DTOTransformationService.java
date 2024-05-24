package com.grl.TFG_API.services;

import com.grl.TFG_API.model.dto.*;
import com.grl.TFG_API.model.entity.Item;
import com.grl.TFG_API.model.entity.Order;
import com.grl.TFG_API.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Servicio para la transformación de DTOs y entidades.
 */
@Service
public class DTOTransformationService {
    /**
     * Convierte un DTO de nuevo usuario en una entidad de usuario.
     *
     * @param newUserDTO DTO del nuevo usuario.
     * @return La entidad de usuario convertida.
     */
    public User convertNewUserDTOIntoUser(NewUserDTO newUserDTO) {
        User user = new User();
        user.setName(newUserDTO.name());
        user.setAddress(newUserDTO.address());
        user.setPassword(newUserDTO.password());
        user.setPhone(newUserDTO.phone());
        user.setGmail(newUserDTO.gmail());
        return user;
    }

    /**
     * Convierte un DTO de nueva orden en una entidad de orden.
     *
     * @param newOrderDTO DTO de la nueva orden.
     * @return La entidad de orden convertida.
     */
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

    /**
     * Convierte una entidad de orden en un DTO de nueva orden.
     *
     * @param order La entidad de orden.
     * @return El DTO de nueva orden convertido.
     */
    public NewOrderDTO convertOrderToNewDTO(Order order) {
        for (Item item : order.getItems()) {
            item.setOrder(null);
        }
        return new NewOrderDTO(order.getId(), order.getPrice(), order.getPaymentMethod(),
                order.getItems(), null, order.getState(), order.getDelivery());
    }

    /**
     * Convierte una entidad de orden en un DTO de información de orden.
     *
     * @param order La entidad de orden.
     * @return El DTO de información de orden convertido.
     */
    public OrderInfoDTO convertOrderToInfoDTO(Order order) {
        return new OrderInfoDTO(order.getId(), order.getPrice(), order.getPaymentMethod(), order.getState(),
                order.getDelivery(), covertUserToInfoDTO(order.getUser()),
                order.getItems().stream().map(this::convertItemToInfoDTO).collect(Collectors.toList()));
    }

    /**
     * Convierte una entidad de usuario en un DTO de información de usuario.
     *
     * @param user La entidad de usuario.
     * @return El DTO de información de usuario convertido.
     */
    public UserInfoDTO covertUserToInfoDTO(User user) {
        return new UserInfoDTO(user.getName(), user.getPhone(), user.getAddress());
    }

    /**
     * Convierte una entidad de ítem en un DTO de información de ítem.
     *
     * @param item La entidad de ítem.
     * @return El DTO de información de ítem convertido.
     */
    public ItemInfoDTO convertItemToInfoDTO(Item item) {
        return new ItemInfoDTO(item.getId(), item.getAmount(), item.getProduct());
    }
}
package com.grl.TFG_API.services;

import com.grl.TFG_API.model.dto.NewOrderDTO;
import com.grl.TFG_API.model.dto.OrderInfoDTO;
import com.grl.TFG_API.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio para la gestión de órdenes.
 */
@Service
public class OrderService {
    private final OrderRepository repository;
    private final DTOTransformationService transformator;

    /**
     * Constructor del servicio OrderService.
     *
     * @param repository    El repositorio de órdenes.
     * @param transformator El servicio de transformación de DTOs.
     */
    @Autowired
    public OrderService(OrderRepository repository, DTOTransformationService transformator) {
        this.repository = repository;
        this.transformator = transformator;
    }

    /**
     * Crea una nueva orden.
     *
     * @param newOrderDTO Los datos de la nueva orden.
     * @return El DTO de la nueva orden creada.
     */
    public NewOrderDTO createNewOrder(NewOrderDTO newOrderDTO) {
        return transformator.convertOrderToNewDTO(repository.save(transformator.convertOrderNewDTOToOrder(newOrderDTO)));
    }

    /**
     * Obtiene todas las órdenes de un usuario por su ID.
     *
     * @param userId El ID del usuario.
     * @return Una lista de DTOs de las órdenes del usuario.
     */
    public List<NewOrderDTO> getOrdersByUserId(Integer userId) {
        return repository.getOrderByUserId(userId).stream()
                .map(transformator::convertOrderToNewDTO).collect(Collectors.toList());
    }

    /**
     * Obtiene todas las órdenes no completadas o canceladas de un usuario por su ID.
     *
     * @param userId El ID del usuario.
     * @return Una lista de DTOs de las órdenes del usuario.
     */
    public List<NewOrderDTO> getOrdersNotCompletedByUserId(Integer userId) {
        return repository.getAllNotCompletedByUserId(userId).stream()
                .map(transformator::convertOrderToNewDTO).collect(Collectors.toList());
    }

    /**
     * Obtiene todas las órdenes que no están completadas.
     *
     * @return Una lista de DTOs de las órdenes no completadas.
     */
    public List<OrderInfoDTO> getAllNotCompleted() {
        return repository.getAllNotCompleted().stream().map(transformator::convertOrderToInfoDTO).collect(Collectors.toList());
    }

    /**
     * Actualiza el estado de una orden.
     *
     * @param id    El ID de la orden.
     * @param state El nuevo estado de la orden.
     * @return El DTO de la orden actualizada.
     */
    public OrderInfoDTO updateState(Integer id, String state) {
        repository.updateOrderByState(id, state);
        return transformator.convertOrderToInfoDTO(repository.findById(id).get());
    }
}
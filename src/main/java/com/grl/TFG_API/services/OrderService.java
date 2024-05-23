package com.grl.TFG_API.services;

import com.grl.TFG_API.model.dto.NewOrderDTO;
import com.grl.TFG_API.model.dto.OrderInfoDTO;
import com.grl.TFG_API.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final DTOTransformationService transformator;

    @Autowired
    public OrderService(OrderRepository repository, DTOTransformationService transformator) {
        this.repository = repository;
        this.transformator = transformator;
    }

    public NewOrderDTO createNewOrder(NewOrderDTO newOrderDTO) {
        return transformator.convertOrderToNewDTO(repository.save(transformator.convertOrderNewDTOToOrder(newOrderDTO)));
    }

    public List<NewOrderDTO> getOrdersByUserId(Integer userId) {
        return repository.getOrderByUserId(userId).stream()
                .map(transformator::convertOrderToNewDTO).collect(Collectors.toList());
    }

    public List<OrderInfoDTO> getAllNotCompleted() {
        return repository.getAllNotCompleted().stream().map(transformator::convertOrderToInfoDTO).collect(Collectors.toList());
    }

    public OrderInfoDTO updateState(Integer id, String state) {
        repository.updateOrderByState(id, state);
        return transformator.convertOrderToInfoDTO(repository.findById(id).get());
    }
}
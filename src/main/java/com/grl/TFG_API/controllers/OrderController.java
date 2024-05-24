package com.grl.TFG_API.controllers;

import com.grl.TFG_API.model.dto.NewOrderDTO;
import com.grl.TFG_API.model.dto.OrderInfoDTO;
import com.grl.TFG_API.services.OrderService;
import com.grl.TFG_API.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con los pedidos en la API.
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    /**
     * Crea un nuevo pedido.
     *
     * @param token    Token de seguridad para autorización.
     * @param orderDTO Datos del nuevo pedido.
     * @return ResponseEntity con el nuevo pedido creado o estado de error si la autorización falla.
     */
    @PostMapping("/new")
    public ResponseEntity<NewOrderDTO> createNewOrder(@RequestParam("token") String token, @RequestBody NewOrderDTO orderDTO) {
        if (SecurityService.isTokenValid(token)) {
            return new ResponseEntity<>(service.createNewOrder(orderDTO), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Busca todos los pedidos de un usuario dado su ID.
     *
     * @param token  Token de seguridad para autorización.
     * @param userId ID del usuario.
     * @return ResponseEntity con la lista de pedidos del usuario o estado de error si la autorización falla.
     */
    @GetMapping("/findByUser")
    public ResponseEntity<List<NewOrderDTO>> findOrdersByUserId(@RequestParam("token") String token, @RequestParam("id") Integer userId) {
        if (SecurityService.isTokenValid(token)) {
            return new ResponseEntity<>(service.getOrdersByUserId(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Busca todos los pedidos no completados ni cancelados de un usuario dado su ID.
     *
     * @param token  Token de seguridad para autorización.
     * @param userId ID del usuario.
     * @return ResponseEntity con la lista de pedidos del usuario o estado de error si la autorización falla.
     */
    @GetMapping("/getAllNotCompletedById")
    public ResponseEntity<List<NewOrderDTO>> findOrdersNotCompletedByUserId(@RequestParam("token") String token, @RequestParam("id") Integer userId) {
        if (SecurityService.isTokenValid(token)) {
            return new ResponseEntity<>(service.getOrdersNotCompletedByUserId(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Obtiene todos los pedidos no completados.
     *
     * @param token Token de seguridad para autorización.
     * @return ResponseEntity con la lista de pedidos no completados o estado de error si la autorización falla.
     */
    @GetMapping("/getAllNotCompleted")
    public ResponseEntity<List<OrderInfoDTO>> getAllNotCompleted(@RequestParam("token") String token) {
        if (SecurityService.isTokenValid(token)) {
            return new ResponseEntity<>(service.getAllNotCompleted(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Actualiza el estado de un pedido.
     *
     * @param token Token de seguridad para autorización.
     * @param state Nuevo estado del pedido.
     * @param id    ID del pedido a actualizar.
     * @return ResponseEntity con el pedido actualizado o estado de error si la autorización falla.
     */
    @PutMapping("updateState/{id}")
    public ResponseEntity<OrderInfoDTO> updateState(@RequestParam("token") String token, @RequestParam("state") String state, @PathVariable Integer id) {
        if (SecurityService.isTokenValid(token)) {
            return new ResponseEntity<>(service.updateState(id, state), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
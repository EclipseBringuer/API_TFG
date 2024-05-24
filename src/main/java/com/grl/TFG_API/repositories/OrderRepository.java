package com.grl.TFG_API.repositories;

import com.grl.TFG_API.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Interfaz del repositorio para gestionar entidades {@link Order}.
 * <p>
 * Esta interfaz extiende JpaRepository para proporcionar operaciones CRUD para las entidades Order.
 * </p>
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    /**
     * Recupera una lista de pedidos por el ID del usuario.
     *
     * @param id el ID del usuario.
     * @return una lista de pedidos asociados con el ID del usuario especificado.
     */
    List<Order> getOrderByUserId(Integer id);

    /**
     * Recupera una lista de pedidos que no están completados ni cancelados.
     * <p>
     * Este método utiliza una consulta JPQL personalizada para obtener pedidos
     * donde el estado no es 'COMPLETED' ni 'CANCELED'.
     * </p>
     *
     * @return una lista de pedidos que no están completados ni cancelados.
     */
    @Query("SELECT o FROM Order o WHERE o.state NOT IN ('COMPLETED', 'CANCELED')")
    List<Order> getAllNotCompleted();

    /**
     * Recupera una lista de pedidos que no están completados ni cancelados en base al id del usuario.
     * <p>
     * Este método utiliza una consulta JPQL personalizada para obtener pedidos
     * donde el estado no es 'COMPLETED' ni 'CANCELED' ademas de filtrar por el id del usuario.
     * </p>
     *
     * @return una lista de pedidos que no están completados ni cancelados.
     */
    @Query("SELECT o FROM Order o WHERE o.state NOT IN ('COMPLETED', 'CANCELED') AND o.user.id = :id")
    List<Order> getAllNotCompletedByUserId(@Param("id") Integer userId);

    /**
     * Actualiza el estado de un pedido por su ID.
     * <p>
     * Este método utiliza una consulta JPQL personalizada para actualizar el estado de un pedido
     * identificado por su ID. El método está anotado con @Modifying y @Transactional
     * para permitir la ejecución de la operación de actualización.
     * </p>
     *
     * @param id    el ID del pedido a actualizar.
     * @param state el nuevo estado a establecer.
     */
    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.state = :state WHERE o.id = :id")
    void updateOrderByState(@Param("id") Integer id, @Param("state") String state);
}
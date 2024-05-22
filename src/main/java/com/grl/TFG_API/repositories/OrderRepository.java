package com.grl.TFG_API.repositories;

import com.grl.TFG_API.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> getOrderByUserId(Integer id);

    @Query("SELECT o FROM Order o WHERE o.state NOT IN ('COMPLETED', 'CANCELED')")
    List<Order> getAllNotCompleted();

    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.state = :state WHERE o.id = :id")
    Integer updateOrderByState(@Param("id") Integer id, @Param("state") String state);
}
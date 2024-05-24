package com.grl.TFG_API.repositories;

import com.grl.TFG_API.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz del repositorio para gestionar entidades {@link Item}.
 * <p>
 * Esta interfaz extiende JpaRepository para proporcionar operaciones CRUD para las entidades Item.
 * </p>
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
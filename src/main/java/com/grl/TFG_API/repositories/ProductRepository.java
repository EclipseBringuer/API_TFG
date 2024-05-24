package com.grl.TFG_API.repositories;

import com.grl.TFG_API.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Interfaz del repositorio para gestionar entidades {@link Product}.
 * <p>
 * Esta interfaz extiende JpaRepository para proporcionar operaciones CRUD para las entidades Product.
 * </p>
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    /**
     * Obtiene una lista de categorías distintas de productos.
     *
     * @return Lista de categorías distintas de productos.
     */
    @Query("SELECT distinct(p.category) FROM Product p ORDER BY p.category")
    List<String> getDistinctCategories();
}
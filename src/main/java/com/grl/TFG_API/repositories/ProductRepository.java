package com.grl.TFG_API.repositories;

import com.grl.TFG_API.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT distinct(p.category) FROM Product p ORDER BY p.category")
    List<String> getDistinctCategories();
}
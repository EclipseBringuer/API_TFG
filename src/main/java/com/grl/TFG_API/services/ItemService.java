package com.grl.TFG_API.services;

import com.grl.TFG_API.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para la gestión de items.
 */
@Service
public class ItemService {
    private final ItemRepository repository;

    /**
     * Constructor del servicio ItemService.
     *
     * @param repository    El repositorio de items.
     */
    @Autowired
    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }
}
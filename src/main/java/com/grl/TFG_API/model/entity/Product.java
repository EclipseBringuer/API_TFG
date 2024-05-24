package com.grl.TFG_API.model.entity;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Clase que representa un producto en la base de datos.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "menu_name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "photo")
    private Integer photo;
    @Column(name = "description")
    private String description;
    @Column(name = "category")
    private String category;

    /**
     * Constructor por defecto de la clase Product.
     */
    public Product() {

    }

    /**
     * Constructor de la clase Product.
     *
     * @param id          El identificador del producto.
     * @param name        El nombre del producto.
     * @param price       El precio del producto.
     * @param photo       La foto del producto.
     * @param description La descripción del producto.
     * @param category    La categoría del producto.
     */
    public Product(Integer id, String name, Double price, Integer photo, String description, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.photo = photo;
        this.description = description;
        this.category = category;
    }

    // Métodos getters y setters...
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //Método sobreescrito toString
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
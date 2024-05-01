package com.grl.TFG_API.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "menu_name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "description")
    private String description;
    @Column(name = "category")
    private String category;

    public Product() {

    }

    public Product(Integer id, String name, Double price, byte[] photo, String description, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.photo = photo;
        this.description = description;
        this.category = category;
    }

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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", photo='" + Arrays.toString(photo) + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
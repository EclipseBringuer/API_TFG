package com.grl.TFG_API.model.entity;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Clase que representa un elemento individual en un pedido.
 */
@Entity
@Table(name = "item")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "amount")
    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * Constructor por defecto de la clase Item.
     */
    public Item(){

    }

    /**
     * Constructor de la clase Item.
     *
     * @param id      El identificador del elemento.
     * @param amount  La cantidad del elemento.
     * @param order   El pedido al que pertenece el elemento.
     * @param product El producto asociado al elemento.
     */
    public Item(Integer id, Integer amount, Order order, Product product) {
        this.id = id;
        this.amount = amount;
        this.order = order;
        this.product = product;
    }

    // Métodos getters y setters...
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    //Método sobreescrito toString
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", amount=" + amount +
                ", order=" + order.getId() +
                ", product=" + product.getName() +
                '}';
    }
}
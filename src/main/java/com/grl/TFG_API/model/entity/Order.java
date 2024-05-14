package com.grl.TFG_API.model.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "`order`")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "price")
    private Double price;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "delivery")
    private String delivery;
    @Column(name = "state")
    private String state;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Item> items;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order(){

    }

    public Order(Integer id, Double price, String paymentMethod, String delivery, String state, List<Item> items, User user) {
        this.id = id;
        this.price = price;
        this.paymentMethod = paymentMethod;
        this.delivery = delivery;
        this.state = state;
        this.items = items;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", delivery='" + delivery + '\'' +
                ", state='" + state + '\'' +
                ", items=" + items +
                ", user=" + user.getName() +
                '}';
    }
}
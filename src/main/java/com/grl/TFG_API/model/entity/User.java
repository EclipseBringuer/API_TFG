package com.grl.TFG_API.model.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un usuario en el sistema.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "gmail")
    private String gmail;
    @Column(name = "pass")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    /**
     * Constructor por defecto de la clase User.
     */
    public User() {
        this.id = 0;
        this.name = "";
        this.gmail = "";
        this.password = "";
        this.phone = "";
        this.address = "";
        this.orders = new ArrayList<>();
    }

    /**
     * Constructor de la clase User.
     *
     * @param id       El identificador del usuario.
     * @param name     El nombre del usuario.
     * @param gmail    El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @param phone    El número de teléfono del usuario.
     * @param address  La dirección del usuario.
     * @param orders   La lista de pedidos asociados al usuario.
     */
    public User(Integer id, String name, String gmail, String password, String phone, String address, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.gmail = gmail;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.orders = orders;
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

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    //Método sobreescrito toString
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gmail='" + gmail + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }
}
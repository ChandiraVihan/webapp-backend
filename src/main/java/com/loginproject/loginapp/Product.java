package com.loginproject.loginapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pro_id;

    private String pro_name;        // Product name
    private String description; // Short description
    private double price;       // Price of product
    private int quantity;       // Inventory stock

    public Product() {}

    public Product(String pro_name, String description, double price, int quantity) {
        this.pro_name = pro_name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    public Long getId() {
        return pro_id;
    }

    public String getName() {
        return pro_name;
    }

    public void setName(String name) {
        this.pro_name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


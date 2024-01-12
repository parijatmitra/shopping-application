package com.shoppingapplication.shoppingapplication.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

@Entity
@Table(name = "menu_item")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
     @JoinColumn(name = "shop_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference
    private Shop shop;
    private int shop_id;
    @NotNull
    private String name;
    private char size;
    private String key_ingredients;
    private double price;

    public MenuItem() {
    }

    public MenuItem(int shop_id, String name, char size, String key_ingredients, double price) {
        this.shop_id = shop_id;
        this.name = name;
        this.size = size;
        this.key_ingredients = key_ingredients;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public String getKey_ingredients() {
        return key_ingredients;
    }

    public void setKey_ingredients(String key_ingredients) {
        this.key_ingredients = key_ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

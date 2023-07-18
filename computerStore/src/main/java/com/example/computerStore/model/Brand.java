package com.example.computerStore.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;
@Entity
@Table(name = "BRAND")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int _id;
    @Column(name = "brand", nullable = false)
    private String _brand;
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private Set<Product> products = new LinkedHashSet<Product>();

    public Brand(){

    }
    public Brand(int _id, String _brand, Set<Product> products) {
        this._id = _id;
        this._brand = _brand;
        this.products = products;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_brand() {
        return _brand;
    }

    public void set_brand(String _brand) {
        this._brand = _brand;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

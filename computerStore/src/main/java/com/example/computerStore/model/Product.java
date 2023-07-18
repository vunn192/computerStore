package com.example.computerStore.model;


import jakarta.persistence.*;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int _id;
    @URL
    @Column(name = "img", nullable = false)
    private String _img;
    @Column(name = "name", nullable = false)
    private String _name;
    @Column(name = "price", nullable = false)
    private long _price;
    @Column(name = "description", nullable = false, length = 1000)
    private String _desc;

    @Column(name = "warranty", nullable = false)
    private String _warranty;
    @Column(name = "brandId", nullable = false)
    private int _brandId;
    @ManyToOne
    @JoinColumn(name = "brandId", insertable = false, updatable = false)
    private Brand brand;

    public Product(){

    }
    public Product(int _id, String _img, String _name, long _price, String _desc, String _warranty, int _brandId, Brand brand) {
        this._id = _id;
        this._img = _img;
        this._name = _name;
        this._price = _price;
        this._desc = _desc;
        this._warranty = _warranty;
        this._brandId = _brandId;
        this.brand = brand;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_img() {
        return _img;
    }

    public void set_img(String _img) {
        this._img = _img;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public long get_price() {
        return _price;
    }

    public void set_price(long _price) {
        this._price = _price;
    }

    public String get_desc() {
        return _desc;
    }

    public void set_desc(String _desc) {
        this._desc = _desc;
    }

    public String get_warranty() {
        return _warranty;
    }

    public void set_warranty(String _warranty) {
        this._warranty = _warranty;
    }

    public int get_brandId() {
        return _brandId;
    }

    public void set_brandId(int _brandId) {
        this._brandId = _brandId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}

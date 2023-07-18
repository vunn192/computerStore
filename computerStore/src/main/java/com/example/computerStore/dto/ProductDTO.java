package com.example.computerStore.dto;
public class ProductDTO {
    private int _id;
    private String _img;
    private String _name;
    private long _price;
    private String _desc;
    private String _warranty;
    private int _brand_id;

    public ProductDTO(){

    }
    public ProductDTO(int _id, String _img, String _name, long _price, String _desc, String _warranty, int _brand_id) {
        this._id = _id;
        this._img = _img;
        this._name = _name;
        this._price = _price;
        this._desc = _desc;
        this._warranty = _warranty;
        this._brand_id = _brand_id;
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

    public int get_brand() {
        return _brand_id;
    }

    public void set_brand(int _brand) {
        this._brand_id = _brand;
    }
}

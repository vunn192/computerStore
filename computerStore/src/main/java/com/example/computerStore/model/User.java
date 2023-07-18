package com.example.computerStore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int _id;
    @Column(name = "username", nullable = false, unique = true)
    private String _username;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String _email;

    @Column(name = "password", nullable = false)
    private String _password;

    public User(){

    }
    public User(int _id, String _username, String _email, String _password) {
        this._id = _id;
        this._username = _username;
        this._email = _email;
        this._password = _password;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }
}

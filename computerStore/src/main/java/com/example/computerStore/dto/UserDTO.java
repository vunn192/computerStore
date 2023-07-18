package com.example.computerStore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {
    @JsonIgnore
    private int _id;
    @NotBlank
    @Size(max=20)
    @JsonProperty("username")
    private String _username;

    @Email
    @JsonProperty("email")
    private String _email;

    @NotBlank
    @Size(max=120)
    @JsonProperty("password")
    private String _password;

    public UserDTO(){

    }
    public UserDTO(int _id, String _username, String _email, String _password) {
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

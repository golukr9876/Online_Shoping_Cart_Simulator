package com.shopcart.model;

// File: Admin.java
public class Admin extends User {
    public Admin(String name, String email, String phone, String password) {
        super(name, email, phone, password, "Admin");
    }
}

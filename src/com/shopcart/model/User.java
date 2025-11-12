package com.shopcart.model;
// File: User.java
public class User {
    protected String name;
    protected String email;
    protected String phone;
    protected String password;
    protected String role;

    public User(String name, String email, String phone, String password, String role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
    }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getRole() { return role; }
    public String getPassword() { return password; }

    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }

    public void changePassword(String newPass) {
        this.password = newPass;
    }

    public String toFileFormat() {
        return name + "," + email + "," + phone + "," + password + "," + role;
    }

    public void showDetails() {
        System.out.println("Name: " + name + " | Email: " + email + " | Phone: " + phone + " | Role: " + role);
    }
}

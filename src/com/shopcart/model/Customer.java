package com.shopcart.model;

public class Customer {
    private int id;
    private String name;
    private String email;
    private Cart cart; // each customer has a cart

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cart = new Cart();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Cart getCart() { return cart; }

    public void displayCustomer() {
        System.out.println("Customer: " + name + " | Email: " + email + " | ID: " + id);
    }
}


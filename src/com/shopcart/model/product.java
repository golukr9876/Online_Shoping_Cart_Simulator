package com.shopcart.model;
 /* Base abstract product class. All product types extend this.
 */
public abstract class Product {
    private int id;
    private String name;
    private double price;
    private String category; // simple string category (you can change to enum if you want)

    public Product(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // getters / setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    public void setPrice(double price) { this.price = price; }
    public void setName(String name) { this.name = name; }

    // each concrete product will implement its own display details
    public abstract void displayDetails();

}


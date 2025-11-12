package com.shopcart.model;

public class Clothing extends Product {
    private String size;
    private String color;

    public Clothing(int id, String name, double price, String size, String color) {
        super(id, name, price, "Clothing");
        this.size = size;
        this.color = color;
    }

    public String getSize() { return size; }
    public String getColor() { return color; }

    @Override
    public void displayDetails() {
        System.out.printf("Clothing - %s [id:%d] | Size: %s | Color: %s | Price: ₹%.2f%n",
                getName(), getId(), size, color, getPrice());
    }
}


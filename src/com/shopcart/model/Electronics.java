package com.shopcart.model;

public class Electronics extends Product {
    private String brand;
    private int warrantyMonths;

    public Electronics(int id, String name, double price, String brand, int warrantyMonths) {
        super(id, name, price, "Electronics");
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    public String getBrand() { return brand; }
    public int getWarrantyMonths() { return warrantyMonths; }

    @Override
    public void displayDetails() {
        System.out.printf("Electronics - %s [id:%d] | Brand: %s | Warranty: %d months | Price: ₹%.2f%n",
                getName(), getId(), brand, warrantyMonths, getPrice());
    }
}



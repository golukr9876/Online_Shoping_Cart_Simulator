package com.shopcart.model;

public class Grocery extends Product {
    private double weightKg;
    private String expiryDate; // simple String (yyyy-mm-dd). You can change to LocalDate later.

    public Grocery(int id, String name, double price, double weightKg, String expiryDate) {
        super(id, name, price, "Grocery");
        this.weightKg = weightKg;
        this.expiryDate = expiryDate;
    }

    public double getWeightKg() { return weightKg; }
    public String getExpiryDate() { return expiryDate; }

    @Override
    public void displayDetails() {
        System.out.printf("Grocery - %s [id:%d] | Weight: %.2f kg | Expiry: %s | Price: ₹%.2f%n",
                getName(), getId(), weightKg, expiryDate, getPrice());
    }
}

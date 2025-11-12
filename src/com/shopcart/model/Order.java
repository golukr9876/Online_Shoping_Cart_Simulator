package com.shopcart.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private int orderId;
    private Customer customer;
    private Cart cartSnapshot; // keep a snapshot of cart at order time
    private LocalDateTime orderDate;
    private double amountPaid;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        // shallow copy snapshot (you can implement deep copy if needed)
        this.cartSnapshot = new Cart();
        for (CartItem ci : customer.getCart().getItems()) {
            this.cartSnapshot.addItem(ci.getProduct(), ci.getQuantity());
        }
        this.orderDate = LocalDateTime.now();
        this.amountPaid = cartSnapshot.getTotalAmount();
    }

    public int getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public double getAmountPaid() { return amountPaid; }
    public String getOrderDateFormatted() {
        return orderDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void displayOrderSummary() {
        System.out.println("\n--- Order Summary ---");
        customer.displayCustomer();
        System.out.println("Order ID: " + orderId + " | Date: " + getOrderDateFormatted());
        cartSnapshot.displayCart();
        System.out.printf("Amount Paid: ₹%.2f%n", amountPaid);
        System.out.println("---------------------\n");
    }
}


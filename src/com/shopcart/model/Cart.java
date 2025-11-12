package com.shopcart.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    // Add item — if same product exists, increase quantity
    public void addItem(Product product, int quantity) {
        if (product == null || quantity <= 0) return;
        Optional<CartItem> existing = items.stream()
                .filter(ci -> ci.getProduct().getId() == product.getId())
                .findFirst();
        if (existing.isPresent()) {
            CartItem ci = existing.get();
            ci.setQuantity(ci.getQuantity() + quantity);
        } else {
            items.add(new CartItem(product, quantity));
        }
        System.out.println(quantity + " x " + product.getName() + " added to cart.");
    }

    public void removeItem(int productId) {
        items.removeIf(ci -> ci.getProduct().getId() == productId);
        System.out.println("Removed product id " + productId + " from cart (if it existed).");
    }

    public void updateQuantity(int productId, int newQty) {
        if (newQty <= 0) {
            removeItem(productId);
            return;
        }
        for (CartItem ci : items) {
            if (ci.getProduct().getId() == productId) {
                ci.setQuantity(newQty);
                System.out.println("Updated quantity for product id " + productId + " to " + newQty);
                return;
            }
        }
        System.out.println("Product id " + productId + " not found in cart.");
    }

    public double getTotalAmount() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items); // return copy to avoid external modification
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("\nYour cart is empty.");
            return;
        }
        System.out.println("\n🛒 Cart Items:");
        for (CartItem ci : items) {
            ci.displayCartItem();
        }
        System.out.printf("Total: ₹%.2f%n%n", getTotalAmount());
    }
}


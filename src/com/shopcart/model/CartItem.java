package com.shopcart.model;

    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        if (quantity <= 0) quantity = 1;
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        if (quantity <= 0) return;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public void displayCartItem() {
        System.out.printf("%s (id:%d) x %d = ₹%.2f%n",
                product.getName(), product.getId(), quantity, getTotalPrice());
    }

}

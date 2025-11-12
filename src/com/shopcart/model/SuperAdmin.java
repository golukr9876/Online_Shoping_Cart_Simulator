package com.shopcart.model;

// File: SuperAdmin.java
public class SuperAdmin extends User {
    private static int count = 0;
    private static final int MAX_SUPERADMINS = 3;

    public SuperAdmin(String name, String email, String phone, String password) {
        super(name, email, phone, password, "SuperAdmin");
        if (count >= MAX_SUPERADMINS) {
            throw new RuntimeException("Max 3 SuperAdmins allowed!");
        }
        count++;
    }


    public static int getSuperAdminCount() {
        return count;
    }
}

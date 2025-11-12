package com.shopcart.utils;

// File: Database.java
import java.io.*;
import java.util.*;

import com.shopcart.model.Admin;
import com.shopcart.model.Customer;
import com.shopcart.model.SuperAdmin;
import com.shopcart.model.User;

public class Database {
    public static ArrayList<User> users = new ArrayList<>();
    private static final String FILE_PATH = "data\\users.txt";

    // Super Admins hardcoded
    static {
        users.add(new SuperAdmin("Master1", "master1@shop.com", "9999999991", "admin123"));
        users.add(new SuperAdmin("Master2", "master2@shop.com", "9999999992", "admin123"));
    }

    public static void loadUsers() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return;

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d.length != 5) continue;

                String name = d[0], email = d[1], phone = d[2], pass = d[3], role = d[4];

                User u;
                switch (role) {
                    case "Admin":
                        u = new Admin(name, email, phone, pass);
                        break;
                    case "User":
                        u = new Customer(name, email, phone, pass);
                        break;
                    default:
                        continue; // super admin file me nahi rakhte
                }
                users.add(u);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    public static void saveUsers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User u : users) {
                if (!u.getRole().equals("SuperAdmin")) {
                    bw.write(u.toFileFormat());
                    bw.newLine();
                }
            }
        } catch (Exception e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    public static boolean isPhoneExist(String phone) {
        for (User u : users) {
            if (u.getPhone().equals(phone)) return true;
        }
        return false;
    }

    public static User getUserByPhone(String phone) {
        for (User u : users) {
            if (u.getPhone().equals(phone)) return u;
        }
        return null;
    }
}

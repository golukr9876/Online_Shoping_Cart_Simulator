package com.shopcart.service;
import com.shopcart.model.Admin;
import com.shopcart.model.Customer; 
import com.shopcart.utils.Database;
import com.shopcart.model.User;

// File: UserManager.java
import java.util.*;

public class UserManager {
    private Scanner sc = new Scanner(System.in);

    public void registerUser(String creatorRole) {
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Email: ");
        String email = sc.nextLine();
        System.out.println("Enter Phone (10 digits): ");
        String phone = sc.nextLine();

        if (phone.length() != 10 || Database.isPhoneExist(phone)) {
            System.out.println("Invalid or existing phone number!");
            return;
        }

        System.out.println("Enter Password: ");
        String password = sc.nextLine();

        User newUser;

        if (creatorRole.equals("SuperAdmin")) {
            System.out.println("Create as Admin or User? (A/U): ");
            String type = sc.nextLine();
            if (type.equalsIgnoreCase("A")) {
                newUser = new Admin(name, email, phone, password);
            } else {
                newUser = new Customer(name, email, phone, password);
            }
        } else {
            newUser = new Customer(name, email, phone, password);
        }

        Database.users.add(newUser);
        Database.saveUsers();
        System.out.println("Registration Successful for " + newUser.getRole() + "!");
    }

    public User login() {
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        User u = Database.getUserByPhone(phone);
        if (u != null && u.checkPassword(password)) {
            System.out.println("Welcome, " + u.getName() + " (" + u.getRole() + ")");
            return u;
        } else {
            System.out.println("Invalid credentials!");
            return null;
        }
    }

    public void forgotPassword() {
        System.out.print("Enter your phone number: ");
        String phone = sc.nextLine();
        User u = Database.getUserByPhone(phone);
        if (u == null) {
            System.out.println("No account found with this phone!");
            return;
        }
        System.out.print("Enter new password: ");
        String newPass = sc.nextLine();
        u.changePassword(newPass);
        Database.saveUsers();
        System.out.println("Password updated successfully!");
    }

    public void listUsers() {
        for (User u : Database.users) {
            u.showDetails();
        }
    }
}

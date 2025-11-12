package com.shopcart.main;

import com.shopcart.model.User;
import com.shopcart.service.UserManager;
import com.shopcart.utils.Database;

import java.util.*;

public class App {
    // File: Main.java
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            UserManager um = new UserManager();
            User loggedUser = null;
    
            Database.loadUsers(); // Load saved users on startup
    
            while (true) {
                System.out.println("\n=== ONLINE SHOPPING USER SYSTEM ===");
                if (loggedUser == null) {
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Forgot Password");
                    System.out.println("4. Exit");
                } else {
                    System.out.println("Logged in as: " + loggedUser.getRole() + " (" + loggedUser.getName() + ")");
                    System.out.println("1. Register New User");
                    System.out.println("2. Change Password");
                    System.out.println("3. View All Users");
                    System.out.println("4. Logout");
                }
                System.out.print("Choose: ");
                int choice = sc.nextInt();
                sc.nextLine();
               
    
                if (loggedUser == null) {
                    switch (choice) {
                        case 1:
                            um.registerUser("User");
                            break;
                        case 2:
                            loggedUser = um.login();
                            break;
                        case 3:
                            um.forgotPassword();
                            break;
                        case 4:
                            System.out.println("Goodbye!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                    }
                } else {
                    switch (choice) {
                        case 1:
                            um.registerUser(loggedUser.getRole());
                            break;
                        case 2:
                            System.out.print("Enter new password: ");
                            String np = sc.nextLine();
                            loggedUser.changePassword(np);
                            Database.saveUsers();
                            System.out.println("Password changed!");
                            break;
                        case 3:
                            if (loggedUser.getRole().equals("SuperAdmin")) {
                                um.listUsers();
                            } else {
                                System.out.println("Access Denied!");
                            }
                            break;
                        case 4:
                            loggedUser = null;
                            System.out.println("You have been logged out.");
                            break;
                        default:
                            System.out.println("Invalid choice!");
                    }
                }
            }
         
        }
}
    


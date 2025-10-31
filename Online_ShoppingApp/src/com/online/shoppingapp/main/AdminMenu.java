package com.online.shoppingapp.main;

import java.util.*;
import com.online.shoppingapp.entities.*;
import com.online.shoppingapp.services.*;

public class AdminMenu {
    public static void show(ProductService productService, OrderService orderService, Scanner sc) {
        AdminService adminService = new AdminService(productService, orderService);

        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Products");
            System.out.println("4. Create Admin");
            System.out.println("5. View Admins");
            System.out.println("6. Update Order Status");
            System.out.println("7. View Orders");
            System.out.println("8. Return");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Stock Quantity: ");
                    int qty = sc.nextInt();
                    adminService.addProduct(new Product(id, name, price, qty));
                    break;

                case 2:
                    System.out.print("Enter Product ID to remove: ");
                    adminService.removeProduct(sc.nextInt());
                    break;

                case 3:
                    adminService.viewProducts();
                    break;

                case 4:
                    System.out.print("Enter Admin ID: ");
                    int aid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Username: ");
                    String aname = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String aemail = sc.nextLine();
                    adminService.createAdmin(new Admin(aid, aname, aemail));
                    break;

                case 5:
                    adminService.viewAdmins();
                    break;

                case 6:
                    System.out.print("Enter Order ID: ");
                    int oid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new status (Completed/Delivered/Cancelled): ");
                    String status = sc.nextLine();
                    adminService.updateOrderStatus(oid, status);
                    break;

                case 7:
                    adminService.viewOrders();
                    break;

                case 8:
                    System.out.println("Exiting Admin Menu...");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
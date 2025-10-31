package com.online.shoppingapp.main;

import java.util.*;
import com.online.shoppingapp.entities.*;
import com.online.shoppingapp.services.*;

public class CustomerMenu {
    public static void show(ProductService productService, OrderService orderService, Scanner sc) {
        CustomerService customerService = new CustomerService(productService, orderService);

        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Create Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Place Order");
            System.out.println("4. View Orders");
            System.out.println("5. View Products");
            System.out.println("6. Return");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();
                    customerService.createCustomer(new Customer(id, username, email, address));
                    break;

                case 2:
                    customerService.viewCustomers();
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    int cid = sc.nextInt();
                    customerService.placeOrder(cid, sc);
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    int cid2 = sc.nextInt();
                    customerService.viewOrdersByCustomer(cid2);
                    break;

                case 5:
                    customerService.viewProducts();
                    break;

                case 6:
                    System.out.println("Exiting Customer Menu...");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
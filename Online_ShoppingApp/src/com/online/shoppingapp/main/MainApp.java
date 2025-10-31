package com.online.shoppingapp.main;

import java.util.*;
import com.online.shoppingapp.services.*;
import com.online.shoppingapp.entities.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();

        while (true) {
            System.out.println("1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: AdminMenu.show(productService, orderService, sc); break;
                case 2: CustomerMenu.show(productService, orderService, sc); break;
                case 3: System.out.println("Exiting..."); System.exit(0);
                default: System.out.println("Invalid option!");
            }
        }
    }
}
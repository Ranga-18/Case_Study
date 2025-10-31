package com.online.shoppingapp.services;

import java.util.*;
import com.online.shoppingapp.entities.*;

public class AdminService {
    private List<Admin> admins = new ArrayList<>();
    private ProductService productService;
    private OrderService orderService;

    public AdminService(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    // Add a new admin
    public void createAdmin(Admin admin) {
        admins.add(admin);
        System.out.println("Admin created successfully!");
    }

    // View all admins
    public void viewAdmins() {
        if (admins.isEmpty()) {
            System.out.println("No admins available.");
        } else {
            System.out.println("Admins:");
            for (Admin admin : admins) {
                System.out.println(admin);
            }
        }
    }

    // Add product
    public void addProduct(Product product) {
        productService.addProduct(product);
        System.out.println("Product added successfully!");
    }

    // Remove product
    public void removeProduct(int productId) {
        productService.removeProduct(productId);
        System.out.println("Product removed successfully!");
    }

    // View all products
    public void viewProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Products:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    // View all orders
    public void viewOrders() {
        List<Order> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
        } else {
            System.out.println("Orders:");
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    // Update order status
    public void updateOrderStatus(int orderId, String status) {
        orderService.updateOrderStatus(orderId, status);
        System.out.println("Order status updated successfully!");
    }
}
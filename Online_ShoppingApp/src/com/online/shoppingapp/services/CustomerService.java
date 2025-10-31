package com.online.shoppingapp.services;

import java.util.*;
import com.online.shoppingapp.entities.*;

public class CustomerService {
    private List<Customer> customers = new ArrayList<>();
    private ProductService productService;
    private OrderService orderService;

    // ✅ REQUIRED CONSTRUCTOR
    public CustomerService(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    // ✅ Create new customer
    public void createCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer created successfully!");
    }

    // ✅ View all customers
    public void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("Customers:");
            for (Customer c : customers) {
                System.out.println(c);
            }
        }
    }

    // ✅ View all available products
    public void viewProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Products:");
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }

    // ✅ Place an order
    public void placeOrder(int customerId, Scanner sc) {
        Customer customer = findCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        List<ProductQuantityPair> items = new ArrayList<>();
        while (true) {
            System.out.print("Enter Product ID to add to order (or -1 to complete): ");
            int productId = sc.nextInt();
            if (productId == -1) break;

            Product product = getProductById(productId);
            if (product == null) {
                System.out.println("Product not found!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            if (quantity > product.getStockQuantity()) {
                System.out.println("Insufficient stock!");
                continue;
            }

            product.setStockQuantity(product.getStockQuantity() - quantity);
            items.add(new ProductQuantityPair(product, quantity));
        }

        if (items.isEmpty()) {
            System.out.println("No items added to order.");
            return;
        }

        Order order = new Order(customer, items);
        customer.getOrders().add(order);
        orderService.placeOrder(order);
        System.out.println("Order placed successfully!");
    }

    // ✅ View orders by customer
    public void viewOrdersByCustomer(int customerId) {
        Customer customer = findCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        List<Order> orders = customer.getOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders found for this customer.");
        } else {
            System.out.println("Orders:");
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    // 🔍 Helpers
    private Customer findCustomerById(int id) {
        for (Customer c : customers) {
            if (c.getUserId() == id) return c;
        }
        return null;
    }

    private Product getProductById(int id) {
        for (Product p : productService.getAllProducts()) {
            if (p.getProductId() == id) return p;
        }
        return null;
    }
}
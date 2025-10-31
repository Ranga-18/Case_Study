package com.online.shoppingapp.entities;

import java.util.*;

public class Order {
    private static int idCounter = 1;
    private int orderId;
    private Customer customer;
    private List<ProductQuantityPair> products;
    private String status;

    public Order(Customer customer, List<ProductQuantityPair> products) {
        this.orderId = idCounter++;
        this.customer = customer;
        this.products = products;
        this.status = "Pending";
    }

    public int getOrderId() { return orderId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order ID: " + orderId + ", Status: " + status + "\n");
        for (ProductQuantityPair pq : products) {
            sb.append("  ").append(pq).append("\n");
        }
        return sb.toString();
    }
}
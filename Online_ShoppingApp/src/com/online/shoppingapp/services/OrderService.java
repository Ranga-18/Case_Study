package com.online.shoppingapp.services;

import java.util.*;
import com.online.shoppingapp.entities.*;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrdersByCustomer(Customer customer) {
        List<Order> result = new ArrayList<>();
        for (Order o : orders) {
            if (o.toString().contains(customer.getUsername())) result.add(o);
        }
        return result;
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void updateOrderStatus(int orderId, String status) {
        for (Order o : orders) {
            if (o.getOrderId() == orderId) {
                o.setStatus(status);
                break;
            }
        }
    }
}
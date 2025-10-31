package com.online.shoppingapp.services;

import java.util.*;
import com.online.shoppingapp.entities.Product;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {
        products.removeIf(p -> p.getProductId() == productId);
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
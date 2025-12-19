/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

import java.util.*;

public class ShoppingCart {

    private static ShoppingCart instance = null;
    private final Map<String, CartItem> items = new LinkedHashMap<>();

    private ShoppingCart() {}

    public static synchronized ShoppingCart getInstance() {
        if (instance == null) instance = new ShoppingCart();
        return instance;
    }

    public void addProduct(Product p, int qty) {
        CartItem existing = items.get(p.getId());
        if (existing == null) items.put(p.getId(), new CartItem(p, qty));
        else existing.quantity += qty;
    }

    public void removeProduct(String productId, int qty) {
        CartItem existing = items.get(productId);
        if (existing == null) return;
        existing.quantity -= qty;
        if (existing.quantity <= 0) items.remove(productId);
    }

    public Collection<CartItem> getItems() { return items.values(); }

    public double getTotal() {
        double sum = 0;
        for (CartItem ci : items.values()) {
            sum += ci.product.getPrice() * ci.quantity;
        }
        return sum;
    }

    public void clear() { items.clear(); }
    public boolean isEmpty() { return items.isEmpty(); }
}

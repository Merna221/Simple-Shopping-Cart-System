/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

import java.util.*;

public class ShopService {

    private final ShoppingCart cart = ShoppingCart.getInstance();
    private final List<OrderObserver> observers = new ArrayList<>();
    private PaymentStrategy paymentStrategy;

    public void registerObserver(OrderObserver obs) { observers.add(obs); }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        double total = cart.getTotal();

        if (paymentStrategy == null) {
            System.out.println("No payment method selected.");
            return;
        }

        System.out.println("Paying $" + String.format("%.2f", total) +
                " using " + paymentStrategy.getName());

        boolean ok = paymentStrategy.pay(total);

        if (ok) {
            String orderId = "ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            List<CartItem> itemsBackup = new ArrayList<>(cart.getItems());

            System.out.println("Order placed: " + orderId);

            for (OrderObserver o : observers) {
                o.onOrderPlaced(orderId, itemsBackup, total);
            }

            cart.clear();
        }
    }
}

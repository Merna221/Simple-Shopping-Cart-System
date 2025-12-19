/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

public class EmailNotificationObserver implements OrderObserver {

    @Override
    public void onOrderPlaced(String orderId, java.util.List<CartItem> items, double total) {
        System.out.println("[EmailObserver] Sending confirmation email for order " +
                orderId + " (total: $" + String.format("%.2f", total) + ")");
    }
}

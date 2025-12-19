/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

public class InventoryObserver implements OrderObserver {

    @Override
    public void onOrderPlaced(String orderId, java.util.List<CartItem> items, double total) {
        System.out.println("[InventoryObserver] Order " + orderId +
                " placed. Updating inventory for " + items.size() + " items.");
    }
}

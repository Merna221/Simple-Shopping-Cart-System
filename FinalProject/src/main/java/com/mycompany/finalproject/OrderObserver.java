/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.finalproject;

import java.util.List;

public interface OrderObserver {
    void onOrderPlaced(String orderId, List<CartItem> items, double total);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

public class RemoveCommand implements CartCommand {

    private final ShoppingCart cart = ShoppingCart.getInstance();
    private final String productId;
    private final int qty;

    public RemoveCommand(String productId, int qty) {
        this.productId = productId;
        this.qty = qty;
    }

    @Override
    public void execute() {
        cart.removeProduct(productId, qty);
        System.out.println("Removed " + qty + " units of product id " + productId);
    }
}

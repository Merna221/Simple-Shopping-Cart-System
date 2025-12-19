/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

public class AddCommand implements CartCommand {

    private final ShoppingCart cart = ShoppingCart.getInstance();
    private final Product product;
    private final int qty;

    public AddCommand(Product p, int qty) {
        this.product = p;
        this.qty = qty;
    }

    @Override
    public void execute() {
        cart.addProduct(product, qty);
        System.out.println("Added " + qty + " x " + product.getName());
    }
}


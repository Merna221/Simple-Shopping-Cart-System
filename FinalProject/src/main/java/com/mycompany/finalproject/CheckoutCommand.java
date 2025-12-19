/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

public class CheckoutCommand implements CartCommand {

    private final ShopService service;

    public CheckoutCommand(ShopService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.checkout();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

public class PayPalPayment implements PaymentStrategy {

    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Processing PayPal payment for " + email);
        return true;
    }

    @Override
    public String getName() { return "PayPal"; }
}

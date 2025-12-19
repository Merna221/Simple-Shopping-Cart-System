/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

public class GiftWrapDecorator extends ProductDecorator {

    private final double wrapPrice = 2.50;

    public GiftWrapDecorator(Product wrappee) {
        super(wrappee);
    }

    @Override
    public double getPrice() {
        return wrappee.getPrice() + wrapPrice;
    }

    @Override
    public String getDescription() {
        return wrappee.getDescription() + " + Gift-wrapping";
    }

    @Override
    public String getName() {
        return wrappee.getName() + " (Gift-wrapped)";
    }
}

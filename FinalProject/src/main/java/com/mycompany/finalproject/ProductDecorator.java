/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

/**
 *
 * @author dell
 */
public abstract class ProductDecorator implements Product {
    protected final Product wrappee;

    public ProductDecorator(Product wrappee) {
        this.wrappee = wrappee;
    }

    public String getId() { return wrappee.getId(); }
    public String getName() { return wrappee.getName(); }
    public double getPrice() { return wrappee.getPrice(); }
    public String getDescription() { return wrappee.getDescription(); }
}

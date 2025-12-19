/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;


public class ProductFactory {

    public static Product createProduct(String key) {
        switch (key.toLowerCase()) {
            case "book":
                return new SimpleProduct("p1", "The Pragmatic Programmer", 39.99, "Classic programming book");
            case "mouse":
                return new SimpleProduct("p2", "Wireless Mouse", 19.95, "Ergonomic wireless mouse");
            case "mug":
                return new SimpleProduct("p3", "Coffee Mug", 9.99, "Ceramic mug 350ml");
            default:
                return new SimpleProduct("p0", "Unknown Item", 0.0, "No description");
        }
    }
}


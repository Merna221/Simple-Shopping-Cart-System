/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

import java.util.*;

public class Catalog {

    private final Map<String, Product> products = new LinkedHashMap<>();

    public Catalog() {
        add(ProductFactory.createProduct("book"));
        add(ProductFactory.createProduct("mouse"));
        add(ProductFactory.createProduct("mug"));
    }

    private void add(Product p) { products.put(p.getId(), p); }

    public Collection<Product> list() { return products.values(); }

    public Product findById(String id) { return products.get(id); }
}


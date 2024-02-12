package com.example.springboot.entity;

import java.util.Map;

public class Product {
    private int id;
    private String name;
    private String category;
    private int salesUnits;
    private Map<String, Integer> stock;

    public Product(int id,String name, String category, int salesUnits, Map<String, Integer> stock) {
        this.id= id;
        this.name = name;
        this.category = category;
        this.salesUnits = salesUnits;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSalesUnits() {
        return salesUnits;
    }

    public void setSalesUnits(int salesUnits) {
        this.salesUnits = salesUnits;
    }

    public Map<String, Integer> getStock() {
        return stock;
    }

    public void setStock(Map<String, Integer> stock) {
        this.stock = stock;
    }
}
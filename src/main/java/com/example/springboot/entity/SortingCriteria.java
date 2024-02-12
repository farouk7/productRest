package com.example.springboot.entity;

public class SortingCriteria {
    private double salesUnitsWeight;
    private double stockRatioWeight;

    public double getSalesUnitsWeight() {
        return salesUnitsWeight;
    }

    public SortingCriteria(double salesUnitsWeight, double stockRatioWeight) {
        this.salesUnitsWeight = salesUnitsWeight;
        this.stockRatioWeight = stockRatioWeight;
    }

    public void setSalesUnitsWeight(double salesUnitsWeight) {
        this.salesUnitsWeight = salesUnitsWeight;
    }

    public double getStockRatioWeight() {
        return stockRatioWeight;
    }

    public void setStockRatioWeight(double stockRatioWeight) {
        this.stockRatioWeight = stockRatioWeight;
    }
}
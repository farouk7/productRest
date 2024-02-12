package com.example.springboot.service;

import com.example.springboot.entity.Product;
import com.example.springboot.entity.SortingCriteria;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    public List<Product> sortProducts(SortingCriteria sortingCriteria, String category, List<Product> productList) {
    /*En la web de Zara.com tenemos distintas categorías de producto (camisetas, zapatos , jeans,
        pantalones, etc.), que sirven para organizar el producto en la web de forma que los clientes puedan
        encontrar lo que están buscando*/
        List<Product> filteredProducts = productList.stream()
                .filter(product -> category.equalsIgnoreCase(product.getCategory()))
                .collect(Collectors.toList());

        /*Nos gustaría tener un algoritmo que permita ordenar los productos dentro de las categorías en base
            a una métrica (p.ej. unidades vendidas, stock disponible, etc.) o una combinación ponderada de las
            mismas (p.ej. 80% unidades vendidas y 20% stock disponible).*/
        Comparator<Product> comparator = Comparator.comparingDouble(product ->
                sortingCriteria.getSalesUnitsWeight() * product.getSalesUnits() +
                        sortingCriteria.getStockRatioWeight() * calculateStockRatio(product.getStock()));

        filteredProducts.sort(comparator.reversed());

        return filteredProducts;
    }

    // el calculo de la racion entre el numero total de (las disponibles/las tallas completas)
    private double calculateStockRatio(Map<String, Integer> stock) {
        int totalSizes = stock.size();
        long availableSizes = stock.values().stream().filter(stockCount -> stockCount > 0).count();
        return (double) availableSizes / totalSizes;
    }
}
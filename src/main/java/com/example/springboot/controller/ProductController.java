package com.example.springboot.controller;

import com.example.springboot.entity.Product;
import com.example.springboot.entity.SortingCriteria;
import com.example.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    Product product1 = new Product(1, "V-NECK BASIC SHIRT", "T-Shirts", 100, Map.of("S", 4, "M", 9, "L", 0));
    Product product2 = new Product(2, "COTTON T-SHIRT", "T-Shirts", 50, Map.of("S", 10, "M", 8, "L", 6));
    Product product3 = new Product(3, "SLIM FIT JEANS", "Jeans", 80, Map.of("S", 5, "M", 7, "L", 3));

    List<Product> productList = List.of(product1, product2, product3);

    @PostMapping("/sort")
    public List<Product> sortProducts(@RequestBody SortingCriteria sortingCriteria, @RequestParam String category) {
        return productService.sortProducts(sortingCriteria, category,productList);
    }
}
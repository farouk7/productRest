package com.example.springboot;

import com.example.springboot.entity.Product;
import com.example.springboot.entity.SortingCriteria;
import com.example.springboot.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testSortProducts() {
        // crear datos de ejemplo
        Product product1 = new Product(1, "V-NECK BASIC SHIRT", "T-Shirts", 100, Map.of("S", 4, "M", 9, "L", 0));
        Product product2 = new Product(2, "COTTON T-SHIRT", "T-Shirts", 50, Map.of("S", 10, "M", 8, "L", 6));
        Product product3 = new Product(3, "SLIM FIT JEANS", "Jeans", 80, Map.of("S", 5, "M", 7, "L", 3));

        List<Product> productList = List.of(product1, product2, product3);

        // definir creterio de ordenar
        SortingCriteria sortingCriteria = new SortingCriteria(0.8, 0.2);

        // sortear con la categoria dseada
        List<Product> sortedTShirts = productService.sortProducts(sortingCriteria, "T-Shirts", productList);
        assertEquals(2, sortedTShirts.size());
        assertEquals(product1, sortedTShirts.get(0));
        assertEquals(product2, sortedTShirts.get(1));

        // Sort the products within the "Jeans" category
        List<Product> sortedJeans = productService.sortProducts(sortingCriteria, "Jeans", productList);
        assertEquals(1, sortedJeans.size());
        assertEquals(product3, sortedJeans.get(0));
    }
}
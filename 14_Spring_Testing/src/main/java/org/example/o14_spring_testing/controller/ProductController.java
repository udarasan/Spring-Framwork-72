package org.example.o14_spring_testing.controller;

import lombok.RequiredArgsConstructor;
import org.example.o14_spring_testing.entity.Product;
import org.example.o14_spring_testing.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(
                productService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product>
    getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(
                productService.getProductById(id));
    }
    @PostMapping
    public ResponseEntity<Product>
    createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(
                productService.createProduct(product));
    }
    @PutMapping
    public ResponseEntity<Product>
    updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(
                productService.updateProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product>
    deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

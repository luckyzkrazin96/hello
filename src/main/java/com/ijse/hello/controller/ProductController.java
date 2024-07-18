package com.ijse.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hello.entity.Product;
import com.ijse.hello.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        if (product.getName() == null || product.getName() == "") {
            return ResponseEntity.status(400).body("Please enter a valid Product Name");
        }

        if (product.getDescription() == null || product.getDescription() == "") {
            return ResponseEntity.status(400).body("Please enter a valid Description");
        }

        // if (product.getPrice() == Double.parseDouble(null)) {
        //     return ResponseEntity.status(400).body("Please enter a valid Price");
        // }

        try {
            Product createdProduct = productService.createProduct(product);
            return ResponseEntity.status(201).body(createdProduct);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.status(200).body(products);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductbyId(@PathVariable Long productId) {
        Product product = productService.getProductIdById(productId);

        if (product == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(product);
        }
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product product) {
        Product updateProduct = productService.updateProduct(productId, product);

        if (updateProduct == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            return ResponseEntity.status(200).body(updateProduct);

        }
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

}

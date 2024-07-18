package com.ijse.hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.hello.entity.Product;

@Service
public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductIdById(Long id);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

}

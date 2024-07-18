package com.ijse.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.hello.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

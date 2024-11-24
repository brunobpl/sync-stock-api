package com.lima.bruno.demogestaoestoque.repository;

import com.lima.bruno.demogestaoestoque.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

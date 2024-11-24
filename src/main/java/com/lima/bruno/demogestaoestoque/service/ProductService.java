package com.lima.bruno.demogestaoestoque.service;

import com.lima.bruno.demogestaoestoque.entity.Product;
import com.lima.bruno.demogestaoestoque.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listProducts(){
        return productRepository.findAll();
    }
}

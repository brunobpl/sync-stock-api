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

    public Product createProduct(Product product){
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setSpecialty(product.getSpecialty());
        newProduct.setDescription(product.getDescription());
        newProduct.setUnitMeasure(String.valueOf(product.getUnitMeasure()));
        newProduct.setUnitPrice(product.getUnitPrice());
        newProduct.setQuantity(product.getQuantity());
        newProduct.setStorage(product.getStorage());
        return productRepository.save(newProduct);
    }
}

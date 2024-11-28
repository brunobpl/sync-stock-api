package com.lima.bruno.demogestaoestoque.controller;

import com.lima.bruno.demogestaoestoque.entity.Product;
import com.lima.bruno.demogestaoestoque.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        try{
            List<Product> products = productService.listProducts();
            return ResponseEntity.ok(products);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return null;
    }
}

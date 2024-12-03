package com.lima.bruno.demogestaoestoque.controller;

import com.lima.bruno.demogestaoestoque.entity.Produto;
import com.lima.bruno.demogestaoestoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> getProducts(){
        try{
            List<Produto> produtos = produtoService.listarProdutos();
            return ResponseEntity.ok(produtos);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Produto> createProduct(@RequestBody Produto produto){
        try{
            Produto novoProduto = produtoService.criarProduto(produto);
            return ResponseEntity.ok(novoProduto);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}

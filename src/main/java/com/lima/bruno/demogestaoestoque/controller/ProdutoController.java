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

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProductById(@PathVariable("id") Long id){
        Produto produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{produtoId}/estoque/{estoqueId}")
    public ResponseEntity<Produto> atualizaEstoque(
            @PathVariable Long produtoId,
            @PathVariable Long estoqueId) {
        Produto produtoAtualizado = produtoService.atualizaEstoque(produtoId, estoqueId);
        return ResponseEntity.ok(produtoAtualizado);
    }
}

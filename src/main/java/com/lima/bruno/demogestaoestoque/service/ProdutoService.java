package com.lima.bruno.demogestaoestoque.service;

import com.lima.bruno.demogestaoestoque.entity.Produto;
import com.lima.bruno.demogestaoestoque.entity.enums.UnidadeDeMedidaEnum;
import com.lima.bruno.demogestaoestoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto criarProduto(Produto produto){
        Produto novoProduto = new Produto();
        novoProduto.setNome(produto.getNome());
        novoProduto.setEspecialidade(produto.getEspecialidade());
        novoProduto.setDescricao(produto.getDescricao());
        novoProduto.setUnidadeDeMedida(UnidadeDeMedidaEnum.valueOf(String.valueOf(produto.getUnidadeDeMedida())));
        novoProduto.setPrecoUnitario(produto.getPrecoUnitario());
        novoProduto.setQuantidade(produto.getQuantidade());
        novoProduto.setEstoque(produto.getEstoque());
        return produtoRepository.save(novoProduto);
    }
}

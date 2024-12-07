package com.lima.bruno.demogestaoestoque.service;

import com.lima.bruno.demogestaoestoque.entity.Estoque;
import com.lima.bruno.demogestaoestoque.entity.Produto;
import com.lima.bruno.demogestaoestoque.entity.enums.UnidadeDeMedidaEnum;
import com.lima.bruno.demogestaoestoque.repository.EstoqueRepository;
import com.lima.bruno.demogestaoestoque.repository.ProdutoRepository;
import com.lima.bruno.demogestaoestoque.service.exceptions.DatabaseException;
import com.lima.bruno.demogestaoestoque.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

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

    public Produto buscarProdutoPorId(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void excluirProduto(Long id){
        try{
            produtoRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    /**
     * @param produtoId ID do produto a ser atualizado
     * @param estoqueId ID do novo estoque para alocar o produto
     * @return Produto com estoque atualizado
     */
    public Produto atualizaEstoque(Long produtoId, Long estoqueId){

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com o ID: " + produtoId));

        Estoque novoEstoque = estoqueRepository.findById(estoqueId)
                .orElseThrow(() -> new EntityNotFoundException("Estoque não encontrado com o ID: " + estoqueId));

        produto.setEstoque(novoEstoque);
        return produtoRepository.save(produto);
    }
}

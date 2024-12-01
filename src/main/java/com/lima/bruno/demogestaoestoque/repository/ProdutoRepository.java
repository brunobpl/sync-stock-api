package com.lima.bruno.demogestaoestoque.repository;

import com.lima.bruno.demogestaoestoque.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

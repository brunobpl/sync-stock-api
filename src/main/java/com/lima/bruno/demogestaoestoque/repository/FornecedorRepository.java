package com.lima.bruno.demogestaoestoque.repository;

import com.lima.bruno.demogestaoestoque.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}

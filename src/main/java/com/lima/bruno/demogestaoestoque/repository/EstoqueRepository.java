package com.lima.bruno.demogestaoestoque.repository;

import com.lima.bruno.demogestaoestoque.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}

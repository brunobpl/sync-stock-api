package com.lima.bruno.demogestaoestoque.repository;

import com.lima.bruno.demogestaoestoque.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}

package com.lima.bruno.demogestaoestoque.config;

import com.lima.bruno.demogestaoestoque.entity.Produto;
import com.lima.bruno.demogestaoestoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {

       //Instanciar objetos e salvar para popular banco de dados.

    }
}

package com.lima.bruno.demogestaoestoque.controller;

import com.lima.bruno.demogestaoestoque.entity.Projeto;
import com.lima.bruno.demogestaoestoque.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<Projeto>> getProjects(){
        try{
            List<Projeto> projetos = projetoService.listarProjetos();
            return ResponseEntity.ok(projetos);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Projeto> createProjeto(@RequestBody Projeto projeto){
        try{
            Projeto novoProjeto = projetoService.criarProjeto(projeto);
            return ResponseEntity.ok(novoProjeto);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> getProjetoPorId(@PathVariable Long id){
        Projeto projeto = projetoService.buscarProjetoPorId(id);
        return ResponseEntity.ok(projeto);
    }
}

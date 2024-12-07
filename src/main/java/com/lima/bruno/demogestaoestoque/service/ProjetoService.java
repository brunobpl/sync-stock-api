package com.lima.bruno.demogestaoestoque.service;

import com.lima.bruno.demogestaoestoque.entity.Projeto;
import com.lima.bruno.demogestaoestoque.repository.ProjetoRepository;
import com.lima.bruno.demogestaoestoque.service.exceptions.DatabaseException;
import com.lima.bruno.demogestaoestoque.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listarProjetos(){
        return projetoRepository.findAll();
    }

    public Projeto criarProjeto(Projeto projeto){
        Projeto novoProjeto = new Projeto();
        novoProjeto.setNome(projeto.getNome());
        novoProjeto.setNumero(projeto.getNumero());
        novoProjeto.setCentroDeCusto(projeto.getCentroDeCusto());
        return projetoRepository.save(novoProjeto);
    }

    public Projeto buscarProjetoPorId(Long id){
        Optional<Projeto> projeto = projetoRepository.findById(id);
        return projeto.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void excluirProjeto(Long id){
        try{
            projetoRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
}

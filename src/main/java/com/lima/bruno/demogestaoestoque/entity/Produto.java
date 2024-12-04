package com.lima.bruno.demogestaoestoque.entity;
import com.lima.bruno.demogestaoestoque.entity.enums.UnidadeDeMedidaEnum;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Produto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especialidade;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private UnidadeDeMedidaEnum unidadeDeMedida;

    private Double precoUnitario;
    private Integer quantidade;

    @OneToOne(cascade = CascadeType.ALL)
    private Estoque estoque;

    @ManyToMany(mappedBy = "produtos")
    private List<NotaFiscal> notasFiscais = new ArrayList<>();


    public Produto() {
    }

    public Produto(String nome, String especialidade, String descricao,
                   UnidadeDeMedidaEnum unidadeDeMedida,
                   Double precoUnitario,
                   Integer quantidade,
                   Estoque storage) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.descricao = descricao;
        this.unidadeDeMedida = unidadeDeMedida;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UnidadeDeMedidaEnum getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(UnidadeDeMedidaEnum unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", descricao='" + descricao + '\'' +
                ", unidadeDeMedida=" + unidadeDeMedida +
                ", precoUnitario=" + precoUnitario +
                ", quantidade=" + quantidade +
                ", estoque=" + estoque +
                '}';
    }
}

package com.lima.bruno.demogestaoestoque.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Estoque implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String localizacao;
    private Integer prateleira;
    private String lado;
    private Integer andar;

    public Estoque() {
    }

    public Estoque(String localizacao, Integer prateleira, String lado, Integer andar) {
        this.localizacao = localizacao;
        this.prateleira = prateleira;
        this.lado = lado;
        this.andar = andar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(Integer prateleira) {
        this.prateleira = prateleira;
    }

    public String getLado() {
        return lado;
    }

    public void setLado(String lado) {
        this.lado = lado;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return Objects.equals(id, estoque.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "id=" + id +
                ", localizacao='" + localizacao + '\'' +
                ", prateleira=" + prateleira +
                ", lado='" + lado + '\'' +
                ", andar=" + andar +
                '}';
    }
}

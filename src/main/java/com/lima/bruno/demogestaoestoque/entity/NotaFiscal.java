package com.lima.bruno.demogestaoestoque.entity;


import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class NotaFiscal implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serie;
    private String numero;
    private Date dataEmissao;
    private Double total;

    @ManyToOne
    private Fornecedor fornecedor;

    @ManyToMany
    private List<Produto> produtos;

    public NotaFiscal() {
    }

    public NotaFiscal(String serie, String numero, Date dataEmissao, Double total) {
        this.serie = serie;
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotaFiscal that = (NotaFiscal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "NotaFiscal{" +
                "id=" + id +
                ", serie='" + serie + '\'' +
                ", numero='" + numero + '\'' +
                ", dataEmissao=" + dataEmissao +
                ", total=" + total +
                '}';
    }
}

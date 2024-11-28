package com.lima.bruno.demogestaoestoque.entity;
import com.lima.bruno.demogestaoestoque.entity.enums.UnitMeasureEnum;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialty;
    private String description;
    private UnitMeasureEnum unitMeasure;
    private Double unitPrice;
    private Integer quantity;

    @OneToOne(cascade = CascadeType.ALL)
    private Storage storage;

    public Product() {
    }

    public Product(Long id, String name, String specialty, String description, String unitMeasure, Double unitPrice, Integer quantity, Storage storage) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.description = description;
        this.unitMeasure = UnitMeasureEnum.valueOf(unitMeasure);
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.storage = storage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UnitMeasureEnum getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = UnitMeasureEnum.valueOf(unitMeasure);
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", description='" + description + '\'' +
                ", unitMeasure='" + unitMeasure + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", storage=" + storage +
                '}';
    }
}

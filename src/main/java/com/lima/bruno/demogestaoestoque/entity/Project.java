package com.lima.bruno.demogestaoestoque.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long costCenter;

    //Asssociação com produto pendente.

    public Project() {}

    public Project(Long id, String name, Long costCenter) {
        this.id = id;
        this.name = name;
        this.costCenter = costCenter;
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

    public Long getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(Long costCenter) {
        this.costCenter = costCenter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", costCenter=" + costCenter +
                '}';
    }
}

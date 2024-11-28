package com.lima.bruno.demogestaoestoque.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private Integer shelf;
    private String side;
    private Integer level;
    private String specialty;

}

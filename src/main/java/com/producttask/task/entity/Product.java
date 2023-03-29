package com.producttask.task.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false, length = 150)
    private String description;

    @Column(name = "serial", nullable = false, length = 150)
    private String serial;

    @Column(name = "status")
    private Boolean status;

    @JsonManagedReference
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<Orders> orders ;
}

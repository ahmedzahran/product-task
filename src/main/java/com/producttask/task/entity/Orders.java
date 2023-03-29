package com.producttask.task.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "status",columnDefinition = "boolean default false")
    private Boolean status =false;

    @Column(name = "address", nullable = false, length = 150)
    private String address;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

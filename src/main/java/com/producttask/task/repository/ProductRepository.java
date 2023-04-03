package com.producttask.task.repository;

import com.producttask.task.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ProductRepository  extends JpaRepository<Product,Integer> {

    Optional<Product> findProductBySerialAndStatus(Integer serial,boolean status);
}

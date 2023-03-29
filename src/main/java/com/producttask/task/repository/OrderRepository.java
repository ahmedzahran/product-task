package com.producttask.task.repository;

import com.producttask.task.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Integer> {


    Page<Orders> findAllByStatus(Pageable pageable ,Boolean status);
}

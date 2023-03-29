package com.producttask.task.service;

import com.producttask.task.entity.Product;
import com.producttask.task.exception.BusinessExceptions;
import com.producttask.task.repository.ProductRepository;
import dto.GeneralResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<GeneralResponse> list(Pageable page) throws BusinessExceptions {
        Page<Product> all = productRepository.findAll(page);
        if (all.isEmpty()){
            throw new BusinessExceptions("no data found");
        }
        return new GeneralResponse().response(all);
    }
}

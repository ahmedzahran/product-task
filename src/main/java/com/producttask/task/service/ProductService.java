package com.producttask.task.service;

import com.producttask.task.dto.ProductDto;
import com.producttask.task.entity.Product;
import com.producttask.task.exception.BusinessExceptions;
import com.producttask.task.repository.ProductRepository;
import com.producttask.task.dto.GeneralResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<GeneralResponse> list(int pageNo,int pageSize) throws BusinessExceptions {

        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Product> allProduct = productRepository.findAll(pageable);

        var dataList = allProduct.getContent().stream().map(product -> {
            return new ProductDto(product);
        }).collect(Collectors.toList());

        if (allProduct.isEmpty()){
            throw new BusinessExceptions("no data found");
        }

        return GeneralResponse.builder()
                .pageNo(allProduct.getNumber())
                .pageSize(allProduct.getSize())
                .totalElements(allProduct.getTotalElements())
                .totalPages(allProduct.getTotalPages())
                .build().response(dataList);
    }
}

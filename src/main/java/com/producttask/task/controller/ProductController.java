package com.producttask.task.controller;

import com.producttask.task.exception.BusinessExceptions;
import com.producttask.task.service.ProductService;
import dto.GeneralResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<GeneralResponse> list(Pageable pageable) throws BusinessExceptions {
        return productService.list(pageable);
    }
}

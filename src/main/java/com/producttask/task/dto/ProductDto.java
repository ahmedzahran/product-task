package com.producttask.task.dto;

import com.producttask.task.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    private Integer serial;
    private String description;

    public ProductDto(Product product){
        this.serial = product.getSerial();
        this.description = product.getDescription();
    }
}

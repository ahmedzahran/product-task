package com.producttask.task.dto;

import com.producttask.task.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {

    private String address;
    private Boolean status;

    public OrderDto(Orders order){
        this.address = order.getAddress();
        this.status = order.getStatus();
    }
}

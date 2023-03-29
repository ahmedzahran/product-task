package com.producttask.task.validation;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliverOrderRequest implements Serializable {

    @NotNull(message = "order id can`t be null")
    private Integer orderId;
}

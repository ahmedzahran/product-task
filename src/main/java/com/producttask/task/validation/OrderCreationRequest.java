package com.producttask.task.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreationRequest implements Serializable {

    @NotNull(message = "address  can`t be null")
    @NotBlank(message = "address must exist")
    private String address;

    @NotNull(message = "product serial can`t be null")
    private Integer serial;
}

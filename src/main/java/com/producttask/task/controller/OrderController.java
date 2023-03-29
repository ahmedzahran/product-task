package com.producttask.task.controller;

import com.producttask.task.exception.BusinessExceptions;
import com.producttask.task.service.OrderService;
import com.producttask.task.validation.DeliverOrderRequest;
import com.producttask.task.validation.OrderCreationRequest;
import com.producttask.task.dto.GeneralResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<GeneralResponse> add(@Valid @RequestBody OrderCreationRequest request) throws BusinessExceptions {

        return orderService.createOrder(request);
    }

    @GetMapping("viewToggle")
    public ResponseEntity<GeneralResponse> view(Pageable pageable,@RequestParam(value="isValid", required = false, defaultValue = "true") boolean isValid) throws BusinessExceptions {
        return orderService.viewToggleOrderByStatus(pageable,isValid);
    }

    @GetMapping("viewOrders")
    public ResponseEntity<GeneralResponse> viewOrders(Pageable pageable) throws BusinessExceptions {
        return orderService.viewUndeliveredOrders(pageable);
    }

    @GetMapping("viewDelivered")
    public ResponseEntity<GeneralResponse> viewDeliveredOrders(Pageable pageable) throws BusinessExceptions {
        return orderService.viewDeliveredOrders(pageable);
    }

    @PostMapping("deliver")
    public ResponseEntity<GeneralResponse> deliver(@Valid @RequestBody DeliverOrderRequest request) throws BusinessExceptions {

        return  orderService.deliver(request);
    }
}

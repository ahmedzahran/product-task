package com.producttask.task.service;

import com.producttask.task.entity.Orders;
import com.producttask.task.exception.BusinessExceptions;
import com.producttask.task.repository.OrderRepository;
import com.producttask.task.repository.ProductRepository;
import com.producttask.task.validation.DeliverOrderRequest;
import com.producttask.task.validation.OrderCreationRequest;
import com.producttask.task.dto.GeneralResponse;
import com.producttask.task.dto.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    public ResponseEntity<GeneralResponse> createOrder(OrderCreationRequest request) throws BusinessExceptions {

        var product = productRepository.findProductById(request.getProductId())
                .orElseThrow(() -> new BusinessExceptions("product not found"));

        Orders order = new Orders();
        order.setAddress(request.getAddress());
        order.setProduct(product);
        orderRepository.save(order);
        return new GeneralResponse().response(new OrderDto(order));

    }

    public ResponseEntity<GeneralResponse> viewToggleOrderByStatus(Pageable page,boolean isValid) throws BusinessExceptions {
        Page<Orders> all = getOrderByStatus(page,isValid);
        return new GeneralResponse().response(all);
    }

    public ResponseEntity<GeneralResponse> viewUndeliveredOrders(Pageable page) throws BusinessExceptions {
        Page<Orders> all = getOrderByStatus(page,false);
        return new GeneralResponse().response(all);
    }

    public ResponseEntity<GeneralResponse> viewDeliveredOrders(Pageable page) throws BusinessExceptions {
        Page<Orders> all = getOrderByStatus(page,true);
        return new GeneralResponse().response(all);
    }

    public ResponseEntity<GeneralResponse> deliver(DeliverOrderRequest request) throws BusinessExceptions {

        Orders order = orderRepository.findById(request.getOrderId())
                                        .orElseThrow(() -> new BusinessExceptions("order not exist"));
        order.setStatus(true);

        orderRepository.save(order);
        return new GeneralResponse().response(new OrderDto(order));

    }

    private Page<Orders> getOrderByStatus(Pageable page,Boolean status) throws BusinessExceptions {
        Page<Orders> all = orderRepository.findAllByStatus(page,status);
        if (all.isEmpty()){
            throw new BusinessExceptions("no data found");
        }
        return  all;
    }

}

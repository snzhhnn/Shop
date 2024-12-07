package com.fialka.service;

import com.fialka.dto.request.OrderRequest;
import com.fialka.dto.response.OrderResponse;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderResponse getByID(UUID id);
    OrderResponse save(OrderRequest orderRequest);
    OrderResponse update(OrderRequest orderRequest);
    OrderResponse delete(OrderRequest orderRequest);
    List<OrderResponse> findAll();
    List<OrderResponse> filter();
}
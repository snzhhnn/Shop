package com.fialka.service;

import com.fialka.dto.request.ProductInOrderRequest;
import com.fialka.dto.response.ProductInOrderResponse;

import java.util.List;
import java.util.UUID;

public interface ProductInOrderService {
    ProductInOrderResponse getByID(UUID id);
    ProductInOrderResponse save(ProductInOrderRequest productInOrderRequest);
    ProductInOrderResponse update(ProductInOrderRequest productInOrderRequest);
    ProductInOrderResponse delete(ProductInOrderRequest productInOrderRequest);
    List<ProductInOrderResponse> findAll();
    List<ProductInOrderResponse> filter();
}

package com.fialka.mapper;

import com.fialka.dto.request.ProductInOrderRequest;
import com.fialka.dto.response.ProductInOrderResponse;
import com.fialka.model.ProductInOrder;

public class ProductInOrderMapper {
    public static ProductInOrder toEntity(ProductInOrderRequest productInOrderRequest) {
        if (productInOrderRequest == null) {
            return null;
        }

        return ProductInOrder.builder()
                .id(productInOrderRequest.getId())
                .quantity(productInOrderRequest.getQuantity())
                .build();
    }

    public static ProductInOrderResponse toDTO(ProductInOrder productInOrder) {
        if (productInOrder == null) {
            return null;
        }

        return ProductInOrderResponse.builder()
                .id(productInOrder.getId())
                .quantity(productInOrder.getQuantity())
                .build();
    }
}
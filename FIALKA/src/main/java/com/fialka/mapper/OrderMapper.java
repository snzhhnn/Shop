package com.fialka.mapper;

import com.fialka.dto.request.OrderRequest;
import com.fialka.dto.response.OrderResponse;
import com.fialka.model.Ordering;

public class OrderMapper {
    public static Ordering toEntity(OrderRequest orderRequest) {
        if (orderRequest == null) {
            return null;
        }

        return Ordering.builder()
                .id(orderRequest.getId())
                .status(orderRequest.getStatus())
                .orderDate(orderRequest.getOrderDate())
                .build();
    }

    public static OrderResponse toDTO(Ordering order) {
        if (order == null) {
            return null;
        }

        return OrderResponse.builder()
                .id(order.getId())
                .status(order.getStatus())
                .orderDate(order.getOrderDate())
                .build();
    }
}
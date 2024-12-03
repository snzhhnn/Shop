package com.fialka.mapper;

import com.fialka.dto.request.OrderRequest;
import com.fialka.dto.response.OrderResponse;
import com.fialka.model.Order;

public class OrderMapper {
    public static Order toEntity(OrderRequest orderRequest) {
        if (orderRequest == null) {
            return null;
        }

        return Order.builder()
                .id(orderRequest.getId())
                .orderDate(orderRequest.getOrderDate())
                .build();
    }

    public static OrderResponse toDTO(Order order) {
        if (order == null) {
            return null;
        }

        return OrderResponse.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate())
                .build();
    }
}
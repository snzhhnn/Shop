package com.fialka.mapper;

import com.fialka.dto.request.ProductInOrderRequest;
import com.fialka.dto.request.ProductLocationRequest;
import com.fialka.dto.response.ProductLocationResponse;
import com.fialka.model.ProductLocation;
import jakarta.servlet.http.HttpServletRequest;

public class ProductLocationMapper {
    public static ProductLocation toEntity(ProductLocationRequest productLocationRequest) {
        if (productLocationRequest == null) {
            return null;
        }

        return ProductLocation.builder()
                .id(productLocationRequest.getId())
                .quantity(productLocationRequest.getQuantity())
                .build();
    }

    public static ProductLocationResponse toDTO(ProductLocation productLocation) {
        if (productLocation == null) {
            return null;
        }

        return ProductLocationResponse.builder()
                .id(productLocation.getId())
                .quantity(productLocation.getQuantity())
                .product(ProductMapper.toDTO(productLocation.getProduct()))
                .warehouse(WarehouseMapper.toDTO(productLocation.getWarehouse()))
                .build();
    }

    public static ProductLocationRequest toRequestDTO(HttpServletRequest req) {
        return ProductLocationRequest.builder()
                .quantity(Integer.parseInt(req.getParameter("quantity")))
                .build();
    }
}
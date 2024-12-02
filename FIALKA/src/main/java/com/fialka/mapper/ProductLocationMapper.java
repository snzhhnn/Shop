package com.fialka.mapper;

import com.fialka.dto.ProductLocationDTO;
import com.fialka.model.Product;
import com.fialka.model.ProductLocation;
import com.fialka.model.Warehouse;

public class ProductLocationMapper {
    public static ProductLocation toEntity(ProductLocationDTO productLocationDTO) {
        if (productLocationDTO == null) {
            return null;
        }

        return ProductLocation.builder()
                .id(productLocationDTO.getId())
                .product(Product.builder().build())
                .warehouse(Warehouse.builder().build())
                .build();
    }

    public static ProductLocationDTO toDTO(ProductLocation productLocation) {
        if (productLocation == null) {
            return null;
        }

        return ProductLocationDTO.builder()
                .id(productLocation.getId())
                .productID(productLocation.getProduct().getId())
                .warehouseID(productLocation.getWarehouse().getId())
                .build();
    }
}

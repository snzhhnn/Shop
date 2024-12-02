package com.fialka.contract.mapper;

import com.fialka.contract.ProductLocationDTO;
import com.fialka.model.ProductLocation;

public class ProductLocationMapper {
    public static ProductLocation toEntity(ProductLocationDTO productLocationDTO) {
        if (productLocationDTO == null) {
            return null;
        }

        return ProductLocation.builder()
                .id(productLocationDTO.getId())
                .product(productLocationDTO.getProductID())
                .warehouse(productLocationDTO.getWarehouseID())
                .build();
    }

    public static ProductLocationDTO toDTO(ProductLocation productLocation) {
        if (productLocation == null) {
            return null;
        }

        return ProductLocationDTO.builder()
                .id(productLocation.getId())
                .productID(productLocation.getProduct())
                .warehouseID(productLocation.getWarehouse())
                .build();
    }
}

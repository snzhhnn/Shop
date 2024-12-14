package com.fialka.mapper;

import com.fialka.dto.ProductDTO;
import com.fialka.dto.WarehouseDTO;
import com.fialka.model.Warehouse;
import jakarta.servlet.http.HttpServletRequest;

public class WarehouseMapper {
    public static Warehouse toEntity(WarehouseDTO warehouseDTO) {
        if (warehouseDTO == null) {
            return null;
        }

        return Warehouse.builder()
                .id(warehouseDTO.getId())
                .title(warehouseDTO.getTitle())
                .address(warehouseDTO.getAddress())
                .build();
    }

    public static WarehouseDTO toDTO(Warehouse warehouse) {
        if (warehouse == null) {
            return null;
        }

        return WarehouseDTO.builder()
                .id(warehouse.getId())
                .title(warehouse.getTitle())
                .address(warehouse.getAddress())
                .build();
    }

    public static WarehouseDTO toDTO(HttpServletRequest req) {
        return WarehouseDTO.builder()
                .title(req.getParameter("title"))
                .address(req.getParameter("address"))
                .build();
    }
}
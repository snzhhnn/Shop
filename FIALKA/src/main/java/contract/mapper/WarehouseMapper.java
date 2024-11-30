package contract.mapper;

import contract.WarehouseDTO;
import model.Warehouse;

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
}
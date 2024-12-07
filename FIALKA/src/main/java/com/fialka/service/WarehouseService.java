package com.fialka.service;

import com.fialka.dto.WarehouseDTO;

import java.util.List;
import java.util.UUID;

public interface WarehouseService {
    WarehouseDTO getByID(UUID id);
    WarehouseDTO save(WarehouseDTO warehouseDTO);
    WarehouseDTO update(WarehouseDTO warehouseDTO);
    WarehouseDTO delete(WarehouseDTO warehouseDTO);
    List<WarehouseDTO> findAll();
    List<WarehouseDTO> filter();
}
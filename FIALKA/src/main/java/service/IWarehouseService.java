package service;

import contract.WarehouseDTO;
import model.Warehouse;

import java.util.List;

public interface IWarehouseService {
    WarehouseDTO getByID(WarehouseDTO warehouseDTO);
    WarehouseDTO save(WarehouseDTO warehouseDTO);
    WarehouseDTO update(WarehouseDTO warehouseDTO);
    WarehouseDTO delete(WarehouseDTO warehouseDTO);
    List<WarehouseDTO> findAll();
    List<WarehouseDTO> filter();
}
package com.fialka.service.Impl;

import com.fialka.dto.WarehouseDTO;
import com.fialka.mapper.WarehouseMapper;
import lombok.AllArgsConstructor;
import com.fialka.model.Warehouse;
import com.fialka.repository.IWarehouseRepository;
import com.fialka.service.IWarehouseService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class WarehouseService implements IWarehouseService {

    private IWarehouseRepository repository;

    @Override
    public WarehouseDTO getByID(UUID id) {
        return WarehouseMapper.toDTO(repository.getByID(id));
    }

    @Override
    public WarehouseDTO save(WarehouseDTO warehouseDTO) {
        return WarehouseMapper.toDTO(repository.save(WarehouseMapper.toEntity(warehouseDTO)));
    }

    @Override
    public WarehouseDTO update(WarehouseDTO warehouseDTO) {
        return WarehouseMapper.toDTO(repository.update(WarehouseMapper.toEntity(warehouseDTO)));
    }

    @Override
    public WarehouseDTO delete(WarehouseDTO warehouseDTO) {
        return WarehouseMapper.toDTO(repository.delete(WarehouseMapper.toEntity(warehouseDTO)));
    }

    @Override
    public List<WarehouseDTO> findAll() {
        List<Warehouse> warehouses = repository.findAll();
        return warehouses.stream()
                .map(WarehouseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<WarehouseDTO> filter() {
        return null;
    }
}

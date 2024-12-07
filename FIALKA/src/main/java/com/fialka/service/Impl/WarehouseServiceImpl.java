package com.fialka.service.Impl;

import com.fialka.dto.WarehouseDTO;
import com.fialka.mapper.WarehouseMapper;
import lombok.AllArgsConstructor;
import com.fialka.model.Warehouse;
import com.fialka.repository.WarehouseRepository;
import com.fialka.service.WarehouseService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseRepository warehouseRepository;

    @Override
    public WarehouseDTO getByID(UUID id) {
        return WarehouseMapper.toDTO(warehouseRepository.getByID(id));
    }

    @Override
    public WarehouseDTO save(WarehouseDTO warehouseDTO) {
        return WarehouseMapper.toDTO(warehouseRepository.save(WarehouseMapper.toEntity(warehouseDTO)));
    }

    @Override
    public WarehouseDTO update(WarehouseDTO warehouseDTO) {
        return WarehouseMapper.toDTO(warehouseRepository.update(WarehouseMapper.toEntity(warehouseDTO)));
    }

    @Override
    public WarehouseDTO delete(WarehouseDTO warehouseDTO) {
        return WarehouseMapper.toDTO(warehouseRepository.delete(WarehouseMapper.toEntity(warehouseDTO)));
    }

    @Override
    public List<WarehouseDTO> findAll() {
        List<Warehouse> warehouses = warehouseRepository.findAll();
        return warehouses.stream()
                .map(WarehouseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<WarehouseDTO> filter() {
        return null;
    }
}

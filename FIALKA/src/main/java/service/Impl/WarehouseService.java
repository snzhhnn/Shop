package service.Impl;

import contract.WarehouseDTO;
import contract.mapper.WarehouseMapper;
import lombok.AllArgsConstructor;
import model.Warehouse;
import repository.IWarehouseRepository;
import service.IWarehouseService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class WarehouseService implements IWarehouseService {

    private IWarehouseRepository repository;

    @Override
    public WarehouseDTO getByID(WarehouseDTO warehouseDTO) {
        return WarehouseMapper.toDTO(repository.getByID(WarehouseMapper.toEntity(warehouseDTO)));
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

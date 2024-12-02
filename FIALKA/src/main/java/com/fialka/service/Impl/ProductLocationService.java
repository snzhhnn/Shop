package com.fialka.service.Impl;

import com.fialka.dto.ProductLocationDTO;
import com.fialka.mapper.ProductLocationMapper;
import lombok.AllArgsConstructor;
import com.fialka.model.ProductLocation;
import com.fialka.repository.IProductLocationRepository;
import com.fialka.service.IProductLocationService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductLocationService implements IProductLocationService {

    private IProductLocationRepository repository;

    @Override
    public ProductLocationDTO getByID(UUID id) {
        return ProductLocationMapper.toDTO(repository.getByID(id));
    }

    @Override
    public ProductLocationDTO save(ProductLocationDTO productLocationDTO) {
        return ProductLocationMapper.toDTO(repository.save(ProductLocationMapper.toEntity(productLocationDTO)));
    }

    @Override
    public ProductLocationDTO update(ProductLocationDTO productLocationDTO) {
        return ProductLocationMapper.toDTO(repository.update(ProductLocationMapper.toEntity(productLocationDTO)));
    }

    @Override
    public ProductLocationDTO delete(ProductLocationDTO productLocationDTO) {
        return ProductLocationMapper.toDTO(repository.delete(ProductLocationMapper.toEntity(productLocationDTO)));
    }

    @Override
    public List<ProductLocationDTO> findAll() {
        List<ProductLocation> productLocations = repository.findAll();
        return productLocations.stream()
                .map(ProductLocationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductLocationDTO> filter() {
        return null;
    }
}

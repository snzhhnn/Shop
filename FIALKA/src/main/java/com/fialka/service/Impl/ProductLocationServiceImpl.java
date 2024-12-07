package com.fialka.service.Impl;

import com.fialka.dto.request.ProductLocationRequest;
import com.fialka.dto.response.ProductLocationResponse;
import com.fialka.mapper.ProductLocationMapper;
import com.fialka.model.Product;
import com.fialka.model.Warehouse;
import com.fialka.repository.ProductRepository;
import com.fialka.repository.WarehouseRepository;
import lombok.AllArgsConstructor;
import com.fialka.model.ProductLocation;
import com.fialka.repository.ProductLocationRepository;
import com.fialka.service.ProductLocationService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductLocationServiceImpl implements ProductLocationService {

    private ProductLocationRepository productLocationRepository;
    private ProductRepository productRepository;
    private WarehouseRepository warehouseRepository;

    @Override
    public ProductLocationResponse getByID(UUID id) {
        return ProductLocationMapper.toDTO(productLocationRepository.getByID(id));
    }

    @Override
    public ProductLocationResponse save(ProductLocationRequest productLocationRequest) {
        Product product = productRepository.getByID(productLocationRequest.getProductID());
        Warehouse warehouse = warehouseRepository.getByID(productLocationRequest.getWarehouseID());
        ProductLocation productLocation = ProductLocationMapper.toEntity(productLocationRequest);
        productLocation.setProduct(product);
        productLocation.setWarehouse(warehouse);
        return ProductLocationMapper.toDTO(productLocationRepository.save(productLocation));
    }

    @Override
    public ProductLocationResponse update(ProductLocationRequest productLocationRequest) {
        Product product = productRepository.getByID(productLocationRequest.getProductID());
        Warehouse warehouse = warehouseRepository.getByID(productLocationRequest.getWarehouseID());
        ProductLocation productLocation = ProductLocationMapper.toEntity(productLocationRequest);
        productLocation.setProduct(product);
        productLocation.setWarehouse(warehouse);
        return ProductLocationMapper.toDTO(productLocationRepository.update(productLocation));
    }

    @Override
    public ProductLocationResponse delete(ProductLocationRequest productLocationRequest) {
        return ProductLocationMapper.toDTO(productLocationRepository.delete(ProductLocationMapper.toEntity(productLocationRequest)));
    }

    @Override
    public List<ProductLocationResponse> findAll() {
        List<ProductLocation> productLocations = productLocationRepository.findAll();
        return productLocations.stream()
                .map(ProductLocationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductLocationResponse> filter() {
        return null;
    }
}
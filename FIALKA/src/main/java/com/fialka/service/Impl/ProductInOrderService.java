package com.fialka.service.Impl;

import com.fialka.dto.request.ProductInOrderRequest;
import com.fialka.dto.response.ProductInOrderResponse;
import com.fialka.mapper.ProductInOrderMapper;
import com.fialka.model.ProductInOrder;
import com.fialka.repository.IProductInOrderRepository;
import com.fialka.service.IProductInOrderService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductInOrderService implements IProductInOrderService {

    private IProductInOrderRepository repository;

    @Override
    public ProductInOrderResponse getByID(UUID id) {
        return ProductInOrderMapper.toDTO(repository.getByID(id));
    }

    @Override
    public ProductInOrderResponse save(ProductInOrderRequest productInOrderRequest) {
        return ProductInOrderMapper.toDTO(repository.save(ProductInOrderMapper.toEntity(productInOrderRequest)));
    }

    @Override
    public ProductInOrderResponse update(ProductInOrderRequest productInOrderRequest) {
        return ProductInOrderMapper.toDTO(repository.update(ProductInOrderMapper.toEntity(productInOrderRequest)));
    }

    @Override
    public ProductInOrderResponse delete(ProductInOrderRequest productInOrderRequest) {
        return ProductInOrderMapper.toDTO(repository.delete(ProductInOrderMapper.toEntity(productInOrderRequest)));
    }

    @Override
    public List<ProductInOrderResponse> findAll() {
        List<ProductInOrder> productInOrders = repository.findAll();
        return productInOrders.stream()
                .map(ProductInOrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductInOrderResponse> filter() {
        return null;
    }
}

package com.fialka.service.Impl;

import com.fialka.dto.request.ProductInOrderRequest;
import com.fialka.dto.response.ProductInOrderResponse;
import com.fialka.mapper.ProductInOrderMapper;
import com.fialka.model.Ordering;
import com.fialka.model.Product;
import com.fialka.model.ProductInOrder;
import com.fialka.repository.IOrderRepository;
import com.fialka.repository.IProductInOrderRepository;
import com.fialka.repository.IProductRepository;
import com.fialka.service.IProductInOrderService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductInOrderService implements IProductInOrderService {

    private IProductInOrderRepository repository;
    private IProductRepository productRepository;
    private IOrderRepository orderRepository;

    @Override
    public ProductInOrderResponse getByID(UUID id) {
        return ProductInOrderMapper.toDTO(repository.getByID(id));
    }

    @Override
    public ProductInOrderResponse save(ProductInOrderRequest productInOrderRequest) {
        Product product = productRepository.getByID(productInOrderRequest.getProductID());
        Ordering ordering = orderRepository.getByID(productInOrderRequest.getOrderID());
        ProductInOrder productInOrder = ProductInOrderMapper.toEntity(productInOrderRequest);
        double totalCost = productInOrder.getQuantity() * product.getPrice();
        productInOrder.setProduct(product);
        productInOrder.setOrder(ordering);
        productInOrder.setTotalCost(totalCost);
        return ProductInOrderMapper.toDTO(repository.save(productInOrder));
    }

    @Override
    public ProductInOrderResponse update(ProductInOrderRequest productInOrderRequest) {
        Product product = productRepository.getByID(productInOrderRequest.getProductID());
        Ordering ordering = orderRepository.getByID(productInOrderRequest.getOrderID());
        ProductInOrder productInOrder = ProductInOrderMapper.toEntity(productInOrderRequest);
        double totalCost = productInOrder.getQuantity() * product.getPrice();
        productInOrder.setProduct(product);
        productInOrder.setOrder(ordering);
        productInOrder.setTotalCost(totalCost);
        return ProductInOrderMapper.toDTO(repository.update(productInOrder));
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
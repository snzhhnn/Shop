package com.fialka.service.Impl;

import com.fialka.dto.request.ProductInOrderRequest;
import com.fialka.dto.response.ProductInOrderResponse;
import com.fialka.mapper.ProductInOrderMapper;
import com.fialka.model.Ordering;
import com.fialka.model.Product;
import com.fialka.model.ProductInOrder;
import com.fialka.repository.OrderRepository;
import com.fialka.repository.ProductInOrderRepository;
import com.fialka.repository.ProductRepository;
import com.fialka.service.ProductInOrderService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductInOrderServiceImpl implements ProductInOrderService {

    private ProductInOrderRepository productInOrderRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    @Override
    public ProductInOrderResponse getByID(UUID id) {
        return ProductInOrderMapper.toDTO(productInOrderRepository.getByID(id));
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
        return ProductInOrderMapper.toDTO(productInOrderRepository.save(productInOrder));
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
        return ProductInOrderMapper.toDTO(productInOrderRepository.update(productInOrder));
    }

    @Override
    public ProductInOrderResponse delete(ProductInOrderRequest productInOrderRequest) {
        return ProductInOrderMapper.toDTO(productInOrderRepository.delete(ProductInOrderMapper.toEntity(productInOrderRequest)));
    }

    @Override
    public List<ProductInOrderResponse> findAll() {
        List<ProductInOrder> productInOrders = productInOrderRepository.findAll();
        return productInOrders.stream()
                .map(ProductInOrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductInOrderResponse> filter() {
        return null;
    }
}
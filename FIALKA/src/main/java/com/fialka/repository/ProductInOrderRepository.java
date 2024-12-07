package com.fialka.repository;

import com.fialka.model.ProductInOrder;

import java.util.List;
import java.util.UUID;

public interface ProductInOrderRepository {
    ProductInOrder getByID(UUID id);
    ProductInOrder save(ProductInOrder productInOrder);
    ProductInOrder update(ProductInOrder productInOrder);
    ProductInOrder delete(ProductInOrder productInOrder);
    List<ProductInOrder> findAll();
    List<ProductInOrder> filter();
}
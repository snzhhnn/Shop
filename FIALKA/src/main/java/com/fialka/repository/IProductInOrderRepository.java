package com.fialka.repository;

import com.fialka.model.Ordering;
import com.fialka.model.ProductInOrder;

import java.util.List;
import java.util.UUID;

public interface IProductInOrderRepository {
    ProductInOrder getByID(UUID id);
    ProductInOrder save(ProductInOrder productInOrder);
    ProductInOrder update(ProductInOrder productInOrder);
    ProductInOrder delete(ProductInOrder productInOrder);
    List<ProductInOrder> findAll();
    List<ProductInOrder> filter();
}
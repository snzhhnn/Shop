package com.fialka.repository;

import com.fialka.model.Order;

import java.util.List;
import java.util.UUID;

public interface IOrderRepository {
    Order getByID(UUID id);
    Order save(Order order);
    Order update(Order order);
    Order delete(Order order);
    List<Order> findAll();
    List<Order> filter();
}
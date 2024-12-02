package com.fialka.repository;

import com.fialka.model.Order;

import java.util.List;

public interface IOrderRepository {
    Order getByID(Order order);
    Order save(Order order);
    Order update(Order order);
    Order delete(Order order);
    List<Order> findAll();
    List<Order> filter();
}
package com.fialka.service;

import com.fialka.dto.OrderDTO;

import java.util.List;
import java.util.UUID;

public interface IOrderService {
    OrderDTO getByID(UUID id);
    OrderDTO save(OrderDTO orderDTO);
    OrderDTO update(OrderDTO orderDTO);
    OrderDTO delete(OrderDTO orderDTO);
    List<OrderDTO> findAll();
    List<OrderDTO> filter();
}
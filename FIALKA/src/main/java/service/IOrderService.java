package service;

import contract.OrderDTO;
import model.Order;

import java.util.List;

public interface IOrderService {
    OrderDTO getByID(OrderDTO orderDTO);
    OrderDTO save(OrderDTO orderDTO);
    OrderDTO update(OrderDTO orderDTO);
    OrderDTO delete(OrderDTO orderDTO);
    List<OrderDTO> findAll();
    List<OrderDTO> filter();
}
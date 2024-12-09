package com.fialka.service.Impl;

import com.fialka.dto.request.OrderRequest;
import com.fialka.dto.response.OrderResponse;
import com.fialka.mapper.OrderMapper;
import com.fialka.model.User;
import com.fialka.repository.UserRepository;
import lombok.AllArgsConstructor;
import com.fialka.model.Ordering;
import com.fialka.repository.OrderRepository;
import com.fialka.service.OrderService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;

    @Override
    public OrderResponse getByID(UUID id) {
        return OrderMapper.toDTO(orderRepository.getByID(id));
    }

    @Override
    public OrderResponse save(OrderRequest orderRequest) {
        User user = userRepository.getByID(orderRequest.getUserID());
        Ordering order = OrderMapper.toEntity(orderRequest);
        order.setUser(user);
        return OrderMapper.toDTO(orderRepository.save(order));
    }

    @Override
    public OrderResponse update(OrderRequest orderRequest) {
        User user = userRepository.getByID(orderRequest.getUserID());
        Ordering order = OrderMapper.toEntity(orderRequest);
        order.setUser(user);
        return OrderMapper.toDTO(orderRepository.update(order));
    }

    @Override
    public OrderResponse delete(OrderRequest orderRequest) {
        return OrderMapper.toDTO(orderRepository.delete(OrderMapper.toEntity(orderRequest)));
    }

    @Override
    public List<OrderResponse> findAll() {
        List<Ordering> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderResponse> filter() {
        return null;
    }
}
package service.Impl;

import contract.OrderDTO;
import contract.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import model.Order;
import repository.IOrderRepository;
import service.IOrderService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OrderService implements IOrderService {

    private IOrderRepository repository;

    @Override
    public OrderDTO getByID(OrderDTO orderDTO) {
        return OrderMapper.toDTO(repository.getByID(OrderMapper.toEntity(orderDTO)));
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        return OrderMapper.toDTO(repository.save(OrderMapper.toEntity(orderDTO)));
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO) {
        return OrderMapper.toDTO(repository.update(OrderMapper.toEntity(orderDTO)));
    }

    @Override
    public OrderDTO delete(OrderDTO orderDTO) {
        return OrderMapper.toDTO(repository.delete(OrderMapper.toEntity(orderDTO)));
    }

    @Override
    public List<OrderDTO> findAll() {
        List<Order> orders = repository.findAll();
        return orders.stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> filter() {
        return null;
    }
}

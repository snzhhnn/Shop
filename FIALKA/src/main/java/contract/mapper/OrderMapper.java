package contract.mapper;

import contract.OrderDTO;
import model.Order;
import model.User;

public class OrderMapper {
    public static Order toEntity(OrderDTO orderDTO) {
        if (orderDTO == null) {
            return null;
        }

        return Order.builder()
                .id(orderDTO.getId())
                .orderDate(orderDTO.getOrderDate())
                .user(User.builder().id(orderDTO.getUserID()).build())
                .build();
    }

    public static OrderDTO toDTO(Order order) {
        if (order == null) {
            return null;
        }

        return OrderDTO.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate())
                .userID(order.getUser().getId())
                .build();
    }
}
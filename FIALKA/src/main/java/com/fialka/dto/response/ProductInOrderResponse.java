package com.fialka.dto.response;

import com.fialka.dto.ProductDTO;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProductInOrderResponse {
    private UUID id;
    private double totalCost;
    private int quantity;
    private ProductDTO product;
    private OrderResponse order;
}
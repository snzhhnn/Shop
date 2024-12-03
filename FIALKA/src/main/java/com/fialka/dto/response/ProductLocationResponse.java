package com.fialka.dto.response;

import com.fialka.dto.ProductDTO;
import com.fialka.dto.WarehouseDTO;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProductLocationResponse {
    private UUID id;
    private int quantity;
    private ProductDTO product;
    private WarehouseDTO warehouse;
}

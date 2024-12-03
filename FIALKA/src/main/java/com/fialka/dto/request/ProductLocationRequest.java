package com.fialka.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProductLocationRequest {
    private UUID id;
    private int quantity;
    private UUID productID;
    private UUID warehouseID;
}

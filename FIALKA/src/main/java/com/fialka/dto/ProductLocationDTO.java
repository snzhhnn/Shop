package com.fialka.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProductLocationDTO {
    private UUID id;
    private UUID productID;
    private UUID warehouseID;
}
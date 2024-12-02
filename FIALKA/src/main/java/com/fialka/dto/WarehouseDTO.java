package com.fialka.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class WarehouseDTO {
    private UUID id;
    private String title;
    private String address;
}

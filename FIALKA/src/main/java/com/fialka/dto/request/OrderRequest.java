package com.fialka.dto.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class OrderRequest {
    private UUID id;
    private String status;
    private LocalDate orderDate;
    private UUID userID;
}
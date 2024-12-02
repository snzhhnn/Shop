package com.fialka.contract;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class OrderDTO {
    private UUID id;
    private LocalDate orderDate;
    private UUID userID;
}
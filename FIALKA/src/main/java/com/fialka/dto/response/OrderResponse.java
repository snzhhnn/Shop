package com.fialka.dto.response;

import com.fialka.model.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class OrderResponse {
    private UUID id;
    private String status;
    private LocalDate orderDate;
    private User user;
}
package com.fialka.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProductDTO {
    private UUID id;
    private String title;
    private String color;
    private double price;
    private String parameter;
    private String description;
    private byte[] photos;
}
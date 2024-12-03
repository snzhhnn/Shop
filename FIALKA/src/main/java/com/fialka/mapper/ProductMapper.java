package com.fialka.mapper;

import com.fialka.dto.ProductDTO;
import com.fialka.model.Product;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ProductMapper {
    public static Product toEntity(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }

        return Product.builder()
                .id(productDTO.getId())
                .title(productDTO.getTitle())
                .color(productDTO.getColor())
                .price(productDTO.getPrice())
                .parameter(productDTO.getParameter())
                .description(productDTO.getDescription())
                .photos(productDTO.getPhotos())
                .build();
    }

    public static ProductDTO toDTO(Product product) {
        if (product == null) {
            return null;
        }

        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .color(product.getColor())
                .price(product.getPrice())
                .parameter(product.getParameter())
                .description(product.getDescription())
                .photos(product.getPhotos())
                .build();
    }
}

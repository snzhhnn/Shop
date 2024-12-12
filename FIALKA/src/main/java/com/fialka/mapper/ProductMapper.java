package com.fialka.mapper;

import com.fialka.dto.ProductDTO;
import com.fialka.model.Product;
import jakarta.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

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
                .category(productDTO.getCategory())
                .parameter(productDTO.getParameter())
                .description(productDTO.getDescription())
                .urlImage(productDTO.getUrlImage())
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
                .category(product.getCategory())
                .parameter(product.getParameter())
                .description(product.getDescription())
                .urlImage(product.getUrlImage())
                .build();
    }

    public static ProductDTO createProduct(HttpServletRequest req) {
        return ProductDTO.builder()
                .title(req.getParameter("title"))
                .color(req.getParameter("color"))
                .price(Double.parseDouble(req.getParameter("price")))
                .category(req.getParameter("category"))
                .parameter(req.getParameter("parameter"))
                .description(req.getParameter("description"))
                .urlImage(req.getParameter("urlImage"))
                .build();
    }
}

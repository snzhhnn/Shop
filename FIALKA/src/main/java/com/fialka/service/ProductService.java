package com.fialka.service;

import com.fialka.dto.ProductDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductDTO getByID(UUID id);
    ProductDTO save(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);
    ProductDTO delete(ProductDTO productDTO);
    List<ProductDTO> findAll();
    void filter(HttpServletRequest req, HttpServletResponse resp);
}
package com.fialka.service;

import com.fialka.dto.ProductDTO;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    ProductDTO getByID(UUID id);
    ProductDTO save(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);
    ProductDTO delete(ProductDTO productDTO);
    List<ProductDTO> findAll();
    List<ProductDTO> filter();
}
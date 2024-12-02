package com.fialka.service;

import com.fialka.dto.ProductLocationDTO;

import java.util.List;
import java.util.UUID;

public interface IProductLocationService {
    ProductLocationDTO getByID(UUID id);
    ProductLocationDTO save(ProductLocationDTO productLocationDTO);
    ProductLocationDTO update(ProductLocationDTO productLocationDTO);
    ProductLocationDTO delete(ProductLocationDTO productLocationDTO);
    List<ProductLocationDTO> findAll();
    List<ProductLocationDTO> filter();
}
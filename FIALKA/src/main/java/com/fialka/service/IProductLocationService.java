package com.fialka.service;

import com.fialka.contract.ProductLocationDTO;

import java.util.List;

public interface IProductLocationService {
    ProductLocationDTO getByID(ProductLocationDTO productLocationDTO);
    ProductLocationDTO save(ProductLocationDTO productLocationDTO);
    ProductLocationDTO update(ProductLocationDTO productLocationDTO);
    ProductLocationDTO delete(ProductLocationDTO productLocationDTO);
    List<ProductLocationDTO> findAll();
    List<ProductLocationDTO> filter();
}
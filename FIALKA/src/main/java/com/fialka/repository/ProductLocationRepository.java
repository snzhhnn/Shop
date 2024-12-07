package com.fialka.repository;

import com.fialka.model.ProductLocation;

import java.util.List;
import java.util.UUID;

public interface ProductLocationRepository {
    ProductLocation getByID(UUID id);
    ProductLocation save(ProductLocation productLocation);
    ProductLocation update(ProductLocation productLocation);
    ProductLocation delete(ProductLocation productLocation);
    List<ProductLocation> findAll();
    List<ProductLocation> filter();
}
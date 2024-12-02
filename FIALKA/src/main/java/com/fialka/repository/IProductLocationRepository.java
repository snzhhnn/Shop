package com.fialka.repository;

import com.fialka.model.ProductLocation;

import java.util.List;

public interface IProductLocationRepository {
    ProductLocation getByID(ProductLocation productLocation);
    ProductLocation save(ProductLocation productLocation);
    ProductLocation update(ProductLocation productLocation);
    ProductLocation delete(ProductLocation productLocation);
    List<ProductLocation> findAll();
    List<ProductLocation> filter();
}
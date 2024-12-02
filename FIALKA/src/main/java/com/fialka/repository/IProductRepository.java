package com.fialka.repository;

import com.fialka.model.Product;

import java.util.List;

public interface IProductRepository {
    Product getByID(Product product);
    Product save(Product product);
    Product update(Product product);
    Product delete(Product product);
    List<Product> findAll();
    List<Product> filter();
}
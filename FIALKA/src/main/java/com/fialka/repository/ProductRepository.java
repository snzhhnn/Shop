package com.fialka.repository;

import com.fialka.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    Product getByID(UUID id);
    List<Product> getByTitle(String title);
    Product save(Product product);
    Product update(Product product);
    Product delete(Product product);
    List<Product> findAll();
    List<Product> filter(double minPrice, double maxPrice, String category);
}
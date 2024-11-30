package repository;

import model.Product;

import java.util.List;
import java.util.UUID;

public interface IProductRepository {
    Product getByID(Product product);
    Product save(Product product);
    Product update(Product product);
    Product delete(Product product);
    List<Product> findAll();
    List<Product> filter();
}
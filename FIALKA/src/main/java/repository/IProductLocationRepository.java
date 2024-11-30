package repository;

import model.Order;
import model.ProductLocation;

import java.util.List;

public interface IProductLocationRepository {
    ProductLocation getByID(ProductLocation productLocation);
    ProductLocation save(ProductLocation productLocation);
    ProductLocation update(ProductLocation productLocation);
    ProductLocation delete(ProductLocation productLocation);
    List<ProductLocation> findAll();
    List<ProductLocation> filter();
}
package service;

import contract.ProductLocationDTO;
import model.ProductLocation;

import java.util.List;

public interface IProductLocationService {
    ProductLocationDTO getByID(ProductLocationDTO productLocationDTO);
    ProductLocationDTO save(ProductLocationDTO productLocationDTO);
    ProductLocationDTO update(ProductLocationDTO productLocationDTO);
    ProductLocationDTO delete(ProductLocationDTO productLocationDTO);
    List<ProductLocationDTO> findAll();
    List<ProductLocationDTO> filter();
}
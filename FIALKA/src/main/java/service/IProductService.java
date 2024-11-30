package service;

import contract.ProductDTO;
import model.Product;

import java.util.List;

public interface IProductService {
    ProductDTO getByID(ProductDTO productDTO);
    ProductDTO save(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);
    ProductDTO delete(ProductDTO productDTO);
    List<ProductDTO> findAll();
    List<ProductDTO> filter();
}
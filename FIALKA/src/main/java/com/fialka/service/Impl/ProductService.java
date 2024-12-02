package com.fialka.service.Impl;

import com.fialka.dto.ProductDTO;
import com.fialka.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import com.fialka.model.Product;
import com.fialka.repository.IProductRepository;
import com.fialka.service.IProductService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductService implements IProductService {

    private IProductRepository repository;

    @Override
    public ProductDTO getByID(UUID id) {
        return ProductMapper.toDTO(repository.getByID(id));
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return ProductMapper.toDTO(repository.save(ProductMapper.toEntity(productDTO)));
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        return ProductMapper.toDTO(repository.update(ProductMapper.toEntity(productDTO)));
    }

    @Override
    public ProductDTO delete(ProductDTO productDTO) {
        return ProductMapper.toDTO(repository.delete(ProductMapper.toEntity(productDTO)));
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = repository.findAll();
        return products.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> filter() {
        return null;
    }
}

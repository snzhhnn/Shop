package com.fialka.service.Impl;

import com.fialka.dto.ProductDTO;
import com.fialka.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import com.fialka.model.Product;
import com.fialka.repository.ProductRepository;
import com.fialka.service.ProductService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public ProductDTO getByID(UUID id) {
        return ProductMapper.toDTO(productRepository.getByID(id));
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return ProductMapper.toDTO(productRepository.save(ProductMapper.toEntity(productDTO)));
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        return ProductMapper.toDTO(productRepository.update(ProductMapper.toEntity(productDTO)));
    }

    @Override
    public ProductDTO delete(ProductDTO productDTO) {
        return ProductMapper.toDTO(productRepository.delete(ProductMapper.toEntity(productDTO)));
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> filter() {
        return null;
    }
}

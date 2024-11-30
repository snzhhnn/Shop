package service.Impl;

import contract.ProductLocationDTO;
import contract.mapper.ProductLocationMapper;
import lombok.AllArgsConstructor;
import model.ProductLocation;
import repository.IProductLocationRepository;
import service.IProductLocationService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductLocationService implements IProductLocationService {

    private IProductLocationRepository repository;

    @Override
    public ProductLocationDTO getByID(ProductLocationDTO productLocationDTO) {
        return ProductLocationMapper.toDTO(repository.getByID(ProductLocationMapper.toEntity(productLocationDTO)));
    }

    @Override
    public ProductLocationDTO save(ProductLocationDTO productLocationDTO) {
        return ProductLocationMapper.toDTO(repository.save(ProductLocationMapper.toEntity(productLocationDTO)));
    }

    @Override
    public ProductLocationDTO update(ProductLocationDTO productLocationDTO) {
        return ProductLocationMapper.toDTO(repository.update(ProductLocationMapper.toEntity(productLocationDTO)));
    }

    @Override
    public ProductLocationDTO delete(ProductLocationDTO productLocationDTO) {
        return ProductLocationMapper.toDTO(repository.delete(ProductLocationMapper.toEntity(productLocationDTO)));
    }

    @Override
    public List<ProductLocationDTO> findAll() {
        List<ProductLocation> productLocations = repository.findAll();
        return productLocations.stream()
                .map(ProductLocationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductLocationDTO> filter() {
        return null;
    }
}

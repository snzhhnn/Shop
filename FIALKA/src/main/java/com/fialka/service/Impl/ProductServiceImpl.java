package com.fialka.service.Impl;

import com.fialka.dto.ProductDTO;
import com.fialka.mapper.ProductMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import com.fialka.model.Product;
import com.fialka.repository.ProductRepository;
import com.fialka.service.ProductService;

import java.io.IOException;
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
    public void filter(HttpServletRequest req, HttpServletResponse resp) {
        double minPrice = 0;
        double maxPrice = 0;
        String category = null;
        if (!req.getParameter("min-price").isEmpty()) {
            minPrice = Double.parseDouble(req.getParameter("min-price"));
        }

        if (!req.getParameter("max-price").isEmpty()) {
            maxPrice = Double.parseDouble(req.getParameter("max-price"));
        }

        if (!req.getParameter("category").isEmpty()) {
            category = req.getParameter("category");
        }
        List<ProductDTO> products = productRepository.filter(minPrice, maxPrice, category).stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());

        forward(req, resp, products);
    }

    @Override
    public void search(HttpServletRequest req, HttpServletResponse resp) {
        String title;
        if (!req.getParameter("title").isEmpty()) {
            title = req.getParameter("title");
            List<ProductDTO> products = productRepository.getByTitle(title).stream()
                    .map(ProductMapper::toDTO)
                    .collect(Collectors.toList());
            forward(req, resp, products);
        }
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp, List<ProductDTO> productDTOS) {
        try {
            HttpSession session = req.getSession();
            session.setAttribute("productDTOS", productDTOS);
            req.getRequestDispatcher("/catalog.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

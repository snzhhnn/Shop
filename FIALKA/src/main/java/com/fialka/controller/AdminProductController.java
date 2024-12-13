package com.fialka.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fialka.dto.ProductDTO;
import com.fialka.mapper.ProductMapper;
import com.fialka.repository.Impl.ProductRepositoryImpl;
import com.fialka.service.Impl.ProductServiceImpl;
import com.fialka.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminController", value = "/admin/product")
public class AdminProductController extends HttpServlet {

    private final ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> productDTOS = productService.findAll();
        HttpSession session = req.getSession();
        session.setAttribute("productDTOS", productDTOS);
        resp.sendRedirect("/FIALKA_war/products.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDTO productDTO = ProductMapper.createProduct(req);
        productService.save(productDTO);
        req.getRequestDispatcher("/FIALKA_war/products.jsp").forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ProductDTO productDTO = jsonToObject(req);
        productService.update(productDTO);
        req.getRequestDispatcher("/FIALKA_war/products.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ProductDTO productDTO = jsonToObject(req);
        productService.delete(productDTO);
    }

    private ProductDTO jsonToObject(HttpServletRequest req) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder jsonBuilder = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
        }
        return mapper.readValue(jsonBuilder.toString(), ProductDTO.class);
    }
}
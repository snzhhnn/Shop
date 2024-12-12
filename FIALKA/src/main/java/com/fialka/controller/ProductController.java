package com.fialka.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fialka.dto.ProductDTO;
import com.fialka.mapper.ProductMapper;
import com.fialka.repository.Impl.ProductRepositoryImpl;
import com.fialka.service.ProductService;
import com.fialka.service.Impl.ProductServiceImpl;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {

    private final ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            UUID id  = UUID.fromString(req.getParameter("id"));
            productService.getByID(id);
        } else {
            List<ProductDTO> productDTOS = productService.findAll();
            HttpSession session = req.getSession();
            session.setAttribute("productDTOS", productDTOS);
            resp.sendRedirect("/FIALKA_war/products.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDTO productDTO = ProductMapper.createProduct(req);
        productService.save(productDTO);
        req.getRequestDispatcher("/products.jsp").forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder jsonBuilder = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
        }
        ProductDTO productDTO = mapper.readValue(jsonBuilder.toString(), ProductDTO.class);
        productService.update(productDTO);
        req.getRequestDispatcher("/products.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder jsonBuilder = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
        }
        ProductDTO productDTO = mapper.readValue(jsonBuilder.toString(), ProductDTO.class);
        productService.delete(productDTO);
    }
}
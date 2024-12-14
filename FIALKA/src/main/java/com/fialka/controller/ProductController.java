package com.fialka.controller;

import com.fialka.dto.ProductDTO;
import com.fialka.mapper.JsonMapper;
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

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminController", value = "/admin/product")
public class ProductController extends HttpServlet {

    private final ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> productDTOS = productService.findAll();
        HttpSession session = req.getSession();
        session.setAttribute("productDTOS", productDTOS);
        resp.sendRedirect("/FIALKA_war/products.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ProductDTO productDTO = ProductMapper.toDTO(req);
        productService.save(productDTO);
        resp.sendRedirect("/FIALKA_war/products.jsp");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ProductDTO productDTO = JsonMapper.jsonToObject(req, ProductDTO.class);
        productService.update(productDTO);
        resp.sendRedirect("/FIALKA_war/products.jsp");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ProductDTO productDTO = JsonMapper.jsonToObject(req, ProductDTO.class);
        productService.delete(productDTO);
    }
}
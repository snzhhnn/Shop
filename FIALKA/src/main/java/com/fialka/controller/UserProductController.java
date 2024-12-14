package com.fialka.controller;

import com.fialka.dto.ProductDTO;
import com.fialka.repository.Impl.ProductRepositoryImpl;
import com.fialka.service.ProductService;
import com.fialka.service.Impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/product")
public class UserProductController extends HttpServlet {

    private final ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> productDTOS = productService.findAll();
        HttpSession session = req.getSession();
        session.setAttribute("productDTOS", productDTOS);
        resp.sendRedirect("/FIALKA_war/catalog.jsp");
    }
}
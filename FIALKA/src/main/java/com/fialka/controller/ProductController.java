package com.fialka.controller;

import com.fialka.dto.ProductDTO;
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
            resp.sendRedirect("/FIALKA-1.0-SNAPSHOT/catalog.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        ProductDTO productDTO = getJsonFromRequest(req);
        productService.save(productDTO);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        ProductDTO productDTO = getJsonFromRequest(req);
        productService.update(productDTO);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        ProductDTO productDTO = getJsonFromRequest(req);
        productService.delete(productDTO);
    }

    private ProductDTO getJsonFromRequest(HttpServletRequest req) {
        ProductDTO productDTO = null;
        try (BufferedReader reader = req.getReader()) {
            Gson gson = new Gson();
            productDTO = gson.fromJson(reader, ProductDTO.class);
        } catch (IOException ex) {
            req.setAttribute("productDTO", "There was an error: " + ex.getMessage());
        }

        return productDTO;
    }
}

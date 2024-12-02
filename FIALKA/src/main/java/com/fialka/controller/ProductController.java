package com.fialka.controller;

import com.fialka.dto.ProductDTO;
import com.fialka.repository.Impl.ProductRepository;
import com.fialka.service.IProductService;
import com.fialka.service.Impl.ProductService;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "productController", value = "/product")
public class ProductController extends HttpServlet {

    private final IProductService service = new ProductService(new ProductRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("id") != null) {
            UUID id  = UUID.fromString(req.getParameter("id"));
            service.getByID(id);
        } else {
            service.findAll();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        ProductDTO productDTO = getJsonFromRequest(req);
        service.save(productDTO);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        ProductDTO productDTO = getJsonFromRequest(req);
        service.update(productDTO);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        ProductDTO productDTO = getJsonFromRequest(req);
        service.delete(productDTO);
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

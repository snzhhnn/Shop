package com.fialka.controller;

import com.fialka.dto.request.ProductLocationRequest;
import com.fialka.repository.Impl.ProductLocationRepositoryImpl;
import com.fialka.repository.Impl.ProductRepositoryImpl;
import com.fialka.repository.Impl.WarehouseRepositoryImpl;
import com.fialka.service.ProductLocationService;
import com.fialka.service.Impl.ProductLocationServiceImpl;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "productLocationController", value = "/product-location")
public class ProductLocationController extends HttpServlet {
    private final ProductLocationService productLocationService = new ProductLocationServiceImpl(new ProductLocationRepositoryImpl(), new ProductRepositoryImpl(), new WarehouseRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        if (req.getParameter("id") != null) {
            UUID id  = UUID.fromString(req.getParameter("id"));
            productLocationService.getByID(id);
        } else {
            productLocationService.findAll();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        ProductLocationRequest productLocationRequest = getJsonFromRequest(req);
        productLocationService.save(productLocationRequest);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        ProductLocationRequest productLocationRequest = getJsonFromRequest(req);
        productLocationService.update(productLocationRequest);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        ProductLocationRequest productLocationRequest = getJsonFromRequest(req);
        productLocationService.delete(productLocationRequest);
    }

    private ProductLocationRequest getJsonFromRequest(HttpServletRequest req) {
        ProductLocationRequest productLocationDTO = null;
        try (BufferedReader reader = req.getReader()) {
            Gson gson = new Gson();
            productLocationDTO = gson.fromJson(reader, ProductLocationRequest.class);
        } catch (IOException ex) {
            req.setAttribute("productLocationDTO", "There was an error: " + ex.getMessage());
        }

        return productLocationDTO;
    }
}
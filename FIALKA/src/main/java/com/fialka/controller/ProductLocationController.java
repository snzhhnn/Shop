package com.fialka.controller;

import com.fialka.dto.request.ProductLocationRequest;
import com.fialka.dto.response.ProductLocationResponse;
import com.fialka.repository.Impl.ProductLocationRepository;
import com.fialka.repository.Impl.ProductRepository;
import com.fialka.repository.Impl.WarehouseRepository;
import com.fialka.service.IProductLocationService;
import com.fialka.service.Impl.ProductLocationService;
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
    private final IProductLocationService service = new ProductLocationService(new ProductLocationRepository(), new ProductRepository(), new WarehouseRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        if (req.getParameter("id") != null) {
            UUID id  = UUID.fromString(req.getParameter("id"));
            service.getByID(id);
        } else {
            service.findAll();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        ProductLocationRequest productLocationRequest = getJsonFromRequest(req);
        service.save(productLocationRequest);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        ProductLocationRequest productLocationRequest = getJsonFromRequest(req);
        service.update(productLocationRequest);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        ProductLocationRequest productLocationRequest = getJsonFromRequest(req);
        service.delete(productLocationRequest);
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
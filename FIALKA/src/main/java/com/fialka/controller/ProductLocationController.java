package com.fialka.controller;

import com.fialka.dto.ProductLocationDTO;
import com.fialka.repository.Impl.ProductLocationRepository;
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
    private final IProductLocationService service = new ProductLocationService(new ProductLocationRepository());

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
        ProductLocationDTO productLocationDTO = getJsonFromRequest(req);
        service.save(productLocationDTO);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        ProductLocationDTO productLocationDTO = getJsonFromRequest(req);
        service.update(productLocationDTO);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        ProductLocationDTO productLocationDTO = getJsonFromRequest(req);
        service.delete(productLocationDTO);
    }

    private ProductLocationDTO getJsonFromRequest(HttpServletRequest req) {
        ProductLocationDTO productLocationDTO = null;
        try (BufferedReader reader = req.getReader()) {
            Gson gson = new Gson();
            productLocationDTO = gson.fromJson(reader, ProductLocationDTO.class);
        } catch (IOException ex) {
            req.setAttribute("productLocationDTO", "There was an error: " + ex.getMessage());
        }

        return productLocationDTO;
    }
}
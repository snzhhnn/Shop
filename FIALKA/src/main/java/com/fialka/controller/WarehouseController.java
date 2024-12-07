package com.fialka.controller;


import com.fialka.dto.WarehouseDTO;
import com.fialka.repository.Impl.WarehouseRepositoryImpl;
import com.fialka.service.WarehouseService;
import com.fialka.service.Impl.WarehouseServiceImpl;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "warehouseController", value = "/warehouse")
public class WarehouseController extends HttpServlet {
    private final WarehouseService warehouseService = new WarehouseServiceImpl(new WarehouseRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("id") != null) {
            UUID id  = UUID.fromString(req.getParameter("id"));
            warehouseService.getByID(id);
        } else {
            warehouseService.findAll();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        WarehouseDTO warehouseDTO = getJsonFromRequest(req);
        warehouseService.save(warehouseDTO);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        WarehouseDTO warehouseDTO = getJsonFromRequest(req);
        warehouseService.update(warehouseDTO);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        WarehouseDTO warehouseDTO = getJsonFromRequest(req);
        warehouseService.delete(warehouseDTO);
    }

    private WarehouseDTO getJsonFromRequest(HttpServletRequest req) {
        WarehouseDTO warehouseDTO = null;
        try (BufferedReader reader = req.getReader()) {
            Gson gson = new Gson();
            warehouseDTO = gson.fromJson(reader, WarehouseDTO.class);
        } catch (IOException ex) {
            req.setAttribute("warehouseDTO", "There was an error: " + ex.getMessage());
        }

        return warehouseDTO;
    }
}
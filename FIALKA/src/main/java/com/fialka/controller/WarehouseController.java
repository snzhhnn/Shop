package com.fialka.controller;


import com.fialka.dto.WarehouseDTO;
import com.fialka.mapper.JsonMapper;
import com.fialka.mapper.WarehouseMapper;
import com.fialka.repository.Impl.WarehouseRepositoryImpl;
import com.fialka.service.WarehouseService;
import com.fialka.service.Impl.WarehouseServiceImpl;
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

@WebServlet(name = "warehouseController", value = "/admin/warehouse")
public class WarehouseController extends HttpServlet {
    private final WarehouseService warehouseService = new WarehouseServiceImpl(new WarehouseRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<WarehouseDTO> warehouseDTOS = warehouseService.findAll();
        HttpSession session = req.getSession();
        session.setAttribute("warehouseDTOS", warehouseDTOS);
        resp.sendRedirect("/FIALKA_war/warehouses.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WarehouseDTO warehouseDTO = WarehouseMapper.createDTO(req);
        warehouseService.save(warehouseDTO);
        resp.sendRedirect("/FIALKA_war/warehouses.jsp");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WarehouseDTO warehouseDTO = JsonMapper.jsonToObject(req, WarehouseDTO.class);
        warehouseService.update(warehouseDTO);
        resp.sendRedirect("/FIALKA_war/warehouses.jsp");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WarehouseDTO warehouseDTO = JsonMapper.jsonToObject(req, WarehouseDTO.class);
        warehouseService.delete(warehouseDTO);
    }

}
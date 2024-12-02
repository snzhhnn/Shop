package com.fialka.controller;

import com.fialka.adapter.LocalDateAdapter;
import com.fialka.dto.OrderDTO;
import com.fialka.repository.Impl.OrderRepository;
import com.fialka.service.IOrderService;
import com.fialka.service.Impl.OrderService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@WebServlet(name = "orderController", value = "/order")
public class OrderController extends HttpServlet {
    private final IOrderService service = new OrderService(new OrderRepository());

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
        OrderDTO orderDTO = getJsonFromRequest(req);
        service.save(orderDTO);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        OrderDTO orderDTO = getJsonFromRequest(req);
        service.update(orderDTO);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        OrderDTO orderDTO = getJsonFromRequest(req);
        service.delete(orderDTO);
    }

    private OrderDTO getJsonFromRequest(HttpServletRequest req) {
        OrderDTO orderDTO = null;
        try (BufferedReader reader = req.getReader()) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                    .create();
            orderDTO = gson.fromJson(reader, OrderDTO.class);
        } catch (IOException ex) {
            req.setAttribute("orderDTO", "There was an error: " + ex.getMessage());
        }

        return orderDTO;
    }
}

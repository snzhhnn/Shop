package com.fialka.controller;

import com.fialka.adapter.LocalDateAdapter;
import com.fialka.dto.request.OrderRequest;
import com.fialka.repository.Impl.OrderRepositoryImpl;
import com.fialka.repository.Impl.UserRepositoryImpl;
import com.fialka.service.OrderService;
import com.fialka.service.Impl.OrderServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@WebServlet(name = "OrderController", value = "/order")
public class OrderController extends HttpServlet {
    private final OrderService orderService = new OrderServiceImpl(new OrderRepositoryImpl(), new UserRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        if (req.getParameter("id") != null) {
            UUID id  = UUID.fromString(req.getParameter("id"));
            orderService.getByID(id);
        } else {
            orderService.findAll();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        OrderRequest orderRequest = getJsonFromRequest(req);
        orderService.save(orderRequest);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        OrderRequest orderRequest = getJsonFromRequest(req);
        orderService.update(orderRequest);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        OrderRequest orderRequest = getJsonFromRequest(req);
        orderService.delete(orderRequest);
    }

    private OrderRequest getJsonFromRequest(HttpServletRequest req) {
        OrderRequest orderRequest = null;
        try (BufferedReader reader = req.getReader()) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                    .create();
            orderRequest = gson.fromJson(reader, OrderRequest.class);
        } catch (IOException ex) {
            req.setAttribute("orderRequest", "There was an error: " + ex.getMessage());
        }

        return orderRequest;
    }
}

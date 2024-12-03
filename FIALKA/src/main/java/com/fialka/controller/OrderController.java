package com.fialka.controller;

import com.fialka.adapter.LocalDateAdapter;
import com.fialka.dto.request.OrderRequest;
import com.fialka.dto.response.OrderResponse;
import com.fialka.repository.Impl.OrderRepository;
import com.fialka.repository.Impl.UserRepository;
import com.fialka.service.IOrderService;
import com.fialka.service.Impl.OrderService;
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
import java.util.List;
import java.util.UUID;

@WebServlet(name = "OrderController", value = "/order")
public class OrderController extends HttpServlet {
    private final IOrderService service = new OrderService(new OrderRepository(), new UserRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            UUID id  = UUID.fromString(req.getParameter("id"));
            service.getByID(id);
        } else {
            service.findAll();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        OrderRequest orderRequest = getJsonFromRequest(req);
        service.save(orderRequest);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        OrderRequest orderRequest = getJsonFromRequest(req);
        service.update(orderRequest);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        OrderRequest orderRequest = getJsonFromRequest(req);
        service.delete(orderRequest);
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

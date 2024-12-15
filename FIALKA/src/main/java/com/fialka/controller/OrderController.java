package com.fialka.controller;

import com.fialka.dto.request.OrderRequest;
import com.fialka.mapper.JsonMapper;
import com.fialka.mapper.OrderMapper;
import com.fialka.repository.Impl.OrderRepositoryImpl;
import com.fialka.repository.Impl.UserRepositoryImpl;
import com.fialka.service.OrderService;
import com.fialka.service.Impl.OrderServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "OrderController", value = "/order")
public class OrderController extends HttpServlet {
    private final OrderService orderService = new OrderServiceImpl(new OrderRepositoryImpl(), new UserRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        orderService.findAll();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        OrderRequest orderRequest = OrderMapper.toRequestDTO(req);
        orderService.save(orderRequest);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OrderRequest orderRequest = JsonMapper.jsonToObject(req, OrderRequest.class);
        orderService.update(orderRequest);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OrderRequest orderRequest = JsonMapper.jsonToObject(req, OrderRequest.class);
        orderService.delete(orderRequest);
    }
}

package com.fialka.controller;

import com.fialka.dto.request.ProductInOrderRequest;
import com.fialka.dto.response.ProductInOrderResponse;
import com.fialka.mapper.JsonMapper;
import com.fialka.mapper.ProductInOrderMapper;
import com.fialka.repository.Impl.OrderRepositoryImpl;
import com.fialka.repository.Impl.ProductInOrderRepositoryImpl;
import com.fialka.repository.Impl.ProductRepositoryImpl;
import com.fialka.service.ProductInOrderService;
import com.fialka.service.Impl.ProductInOrderServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductInOrderController", value = "/product-in-order")
public class ProductInOrderController extends HttpServlet {

    private final ProductInOrderService productInOrderService = new ProductInOrderServiceImpl(new ProductInOrderRepositoryImpl(), new ProductRepositoryImpl(), new OrderRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<ProductInOrderResponse> products = productInOrderService.findAll();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        ProductInOrderRequest product = ProductInOrderMapper.toRequestDTO(req);
        productInOrderService.save(product);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ProductInOrderRequest product = JsonMapper.jsonToObject(req, ProductInOrderRequest.class);
        productInOrderService.update(product);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ProductInOrderRequest product = JsonMapper.jsonToObject(req, ProductInOrderRequest.class);
        productInOrderService.delete(product);
    }
}

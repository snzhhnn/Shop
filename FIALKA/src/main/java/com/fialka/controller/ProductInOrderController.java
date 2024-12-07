package com.fialka.controller;

import com.fialka.dto.request.ProductInOrderRequest;
import com.fialka.dto.response.ProductInOrderResponse;
import com.fialka.repository.Impl.OrderRepositoryImpl;
import com.fialka.repository.Impl.ProductInOrderRepositoryImpl;
import com.fialka.repository.Impl.ProductRepositoryImpl;
import com.fialka.service.ProductInOrderService;
import com.fialka.service.Impl.ProductInOrderServiceImpl;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ProductInOrderController", value = "/product-in-order")
public class ProductInOrderController extends HttpServlet {

    private final ProductInOrderService productInOrderService = new ProductInOrderServiceImpl(new ProductInOrderRepositoryImpl(), new ProductRepositoryImpl(), new OrderRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("id") != null) {
            UUID id = UUID.fromString(req.getParameter("id"));
            productInOrderService.getByID(id);
        } else {
            List<ProductInOrderResponse> products = productInOrderService.findAll();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        ProductInOrderRequest product = getJsonFromRequest(req);
        productInOrderService.save(product);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        ProductInOrderRequest product = getJsonFromRequest(req);
        productInOrderService.update(product);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        ProductInOrderRequest product = getJsonFromRequest(req);
        productInOrderService.delete(product);
    }

    private ProductInOrderRequest getJsonFromRequest(HttpServletRequest req) {
        ProductInOrderRequest productInOrderRequest = null;
        try (BufferedReader reader = req.getReader()) {
            Gson gson = new Gson();
            productInOrderRequest = gson.fromJson(reader, ProductInOrderRequest.class);
        } catch (IOException ex) {
            req.setAttribute("productInOrderRequest", "There was an error: " + ex.getMessage());
        }

        return productInOrderRequest;
    }
}

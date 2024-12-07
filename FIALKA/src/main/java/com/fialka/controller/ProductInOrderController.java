package com.fialka.controller;

import com.fialka.dto.request.ProductInOrderRequest;
import com.fialka.dto.response.ProductInOrderResponse;
import com.fialka.repository.Impl.OrderRepository;
import com.fialka.repository.Impl.ProductInOrderRepository;
import com.fialka.repository.Impl.ProductRepository;
import com.fialka.service.IProductInOrderService;
import com.fialka.service.Impl.ProductInOrderService;
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

    private IProductInOrderService service = new ProductInOrderService(new ProductInOrderRepository(), new ProductRepository(), new OrderRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            UUID id = UUID.fromString(req.getParameter("id"));
            service.getByID(id);
        } else {
            List<ProductInOrderResponse> product = service.findAll();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductInOrderRequest product = getJsonFromRequest(req);
        service.save(product);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductInOrderRequest product = getJsonFromRequest(req);
        service.update(product);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductInOrderRequest product = getJsonFromRequest(req);
        service.delete(product);
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

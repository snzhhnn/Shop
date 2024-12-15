package com.fialka.controller;

import com.fialka.dto.ProductDTO;
import com.fialka.mapper.JsonMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BucketController", value = "/bucket")
public class BucketController extends HttpServlet {

    private List<ProductDTO> bucketItems;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bucketItems", bucketItems);
        resp.sendRedirect("/FIALKA_war/bucket.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDTO productDTO = JsonMapper.jsonToObject(req, ProductDTO.class);
        System.out.println(productDTO.getCategory());
        bucketItems.add(productDTO);
        resp.sendRedirect("/FIALKA_war/catalog.jsp");
    }
}
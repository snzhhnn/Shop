package com.fialka.controller;

import com.fialka.dto.ProductDTO;
import com.fialka.dto.UserDTO;
import com.fialka.repository.Impl.ProductRepositoryImpl;
import com.fialka.repository.Impl.UserRepositoryImpl;
import com.fialka.service.ProductService;
import com.fialka.service.UserService;
import com.fialka.service.Impl.ProductServiceImpl;
import com.fialka.service.Impl.UserServiceImpl;
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

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {

    private final ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());
    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            UUID id  = UUID.fromString(req.getParameter("id"));
            productService.getByID(id);
        } else {
            List<ProductDTO> productDTOS = productService.findAll();
            UUID id = UUID.fromString(req.getParameter("idUser"));
            UserDTO userDTO = userService.getByID(id);
            req.setAttribute("productDTOS", productDTOS);
            req.setAttribute("userDTO", userDTO);
            req.getRequestDispatcher("/catalog.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        ProductDTO productDTO = getJsonFromRequest(req);
        productService.save(productDTO);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        ProductDTO productDTO = getJsonFromRequest(req);
        productService.update(productDTO);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        ProductDTO productDTO = getJsonFromRequest(req);
        productService.delete(productDTO);
    }

    private ProductDTO getJsonFromRequest(HttpServletRequest req) {
        ProductDTO productDTO = null;
        try (BufferedReader reader = req.getReader()) {
            Gson gson = new Gson();
            productDTO = gson.fromJson(reader, ProductDTO.class);
        } catch (IOException ex) {
            req.setAttribute("productDTO", "There was an error: " + ex.getMessage());
        }

        return productDTO;
    }
}

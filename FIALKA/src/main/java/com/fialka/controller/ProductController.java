package com.fialka.controller;

import com.fialka.dto.ProductDTO;
import com.fialka.repository.Impl.ProductRepository;
import com.fialka.service.IProductService;
import com.fialka.service.Impl.ProductService;
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

@WebServlet(name = "productController", value = "/product")
public class ProductController extends HttpServlet {

    private final IProductService service = new ProductService(new ProductRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            UUID id  = UUID.fromString(req.getParameter("id"));
            service.getByID(id);
        } else {
            List<ProductDTO> productDTOS = service.findAll();
            req.setAttribute("productDTOS", productDTOS);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        ProductDTO productDTO = getJsonFromRequest(req);
        service.save(productDTO);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        ProductDTO productDTO = getJsonFromRequest(req);
        service.update(productDTO);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        ProductDTO productDTO = getJsonFromRequest(req);
        service.delete(productDTO);
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

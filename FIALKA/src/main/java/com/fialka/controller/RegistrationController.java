package com.fialka.controller;

import com.fialka.repository.Impl.UserRepositoryImpl;
import com.fialka.service.UserService;
import com.fialka.service.Impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegistrationController", value = "/registration")
public class RegistrationController extends HttpServlet {

    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("idUser") != null) {
            req.getRequestDispatcher("/updateUser.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        userService.registration(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/updateUser.jsp").forward(req, resp);
    }
}
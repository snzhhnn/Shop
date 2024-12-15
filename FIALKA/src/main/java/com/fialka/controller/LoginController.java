package com.fialka.controller;

import com.fialka.repository.Impl.UserRepositoryImpl;
import com.fialka.service.UserService;
import com.fialka.service.Impl.UserServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        userService.login(req, resp);
    }
}
package com.fialka.controller;

import com.fialka.dto.UserDTO;
import com.fialka.model.User;
import com.fialka.repository.Impl.UserRepository;
import com.fialka.service.IUserService;
import com.fialka.service.Impl.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private final IUserService userService = new UserService(new UserRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.login(req, resp);
    }
}
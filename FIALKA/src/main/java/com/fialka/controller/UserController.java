package com.fialka.controller;

import com.fialka.adapter.LocalDateAdapter;
import com.fialka.dto.UserDTO;
import com.fialka.mapper.JsonMapper;
import com.fialka.mapper.UserMapper;
import com.fialka.repository.Impl.UserRepositoryImpl;
import com.fialka.service.UserService;
import com.fialka.service.Impl.UserServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@WebServlet(name = "userController", value = "/user")
public class UserController extends HttpServlet {
    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        if (req.getParameter("id") != null) {
            UUID id  = UUID.fromString(req.getParameter("id"));
            userService.getByID(id);
        } else {
            userService.findAll();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        UserDTO userDTO = UserMapper.toDTO(req);
        userService.save(userDTO);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDTO userDTO = JsonMapper.jsonToObject(req, UserDTO.class);
        userService.update(userDTO);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDTO userDTO = JsonMapper.jsonToObject(req, UserDTO.class);
        userService.delete(userDTO);
    }
}

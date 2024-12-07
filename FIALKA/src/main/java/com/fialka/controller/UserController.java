package com.fialka.controller;

import com.fialka.adapter.LocalDateAdapter;
import com.fialka.dto.UserDTO;
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
        UserDTO userDTO = getJsonFromRequest(req);
        userService.save(userDTO);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        UserDTO userDTO = getJsonFromRequest(req);
        userService.update(userDTO);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        UserDTO userDTO = getJsonFromRequest(req);
        userService.delete(userDTO);
    }

    private UserDTO getJsonFromRequest(HttpServletRequest req) {
        UserDTO userDTO = null;
        try (BufferedReader reader = req.getReader()) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                    .create();
            userDTO = gson.fromJson(reader, UserDTO.class);
        } catch (IOException ex) {
            req.setAttribute("userDTO", "There was an error: " + ex.getMessage());
        }

        return userDTO;
    }
}

package com.fialka.service;

import com.fialka.dto.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDTO getByID(UUID id);
    UserDTO save(UserDTO userDTO);
    UserDTO update(UserDTO userDTO);
    UserDTO delete(UserDTO userDTO);
    List<UserDTO> findAll();
    void login(HttpServletRequest req, HttpServletResponse resp);
    void registration(HttpServletRequest req, HttpServletResponse resp);
    UserDTO isAdmin(String username);
}
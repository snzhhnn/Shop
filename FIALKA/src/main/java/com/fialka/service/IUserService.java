package com.fialka.service;

import com.fialka.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    UserDTO getByID(UUID id);
    UserDTO save(UserDTO userDTO);
    UserDTO update(UserDTO userDTO);
    UserDTO delete(UserDTO userDTO);
    List<UserDTO> findAll();
    List<UserDTO> filter();
}
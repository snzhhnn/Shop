package service;

import contract.UserDTO;
import model.User;

import java.util.List;

public interface IUserService {
    UserDTO getByID(UserDTO userDTO);
    UserDTO save(UserDTO userDTO);
    UserDTO update(UserDTO userDTO);
    UserDTO delete(UserDTO userDTO);
    List<UserDTO> findAll();
    List<UserDTO> filter();
}
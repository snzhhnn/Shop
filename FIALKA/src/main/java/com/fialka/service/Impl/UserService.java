package com.fialka.service.Impl;

import com.fialka.dto.UserDTO;
import com.fialka.mapper.UserMapper;
import com.fialka.validator.UserValidator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import com.fialka.model.User;
import com.fialka.repository.IUserRepository;
import com.fialka.service.IUserService;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserService implements IUserService {

    private IUserRepository userRepository;

    @Override
    public UserDTO getByID(UUID id) {
        return UserMapper.toDTO(userRepository.getByID(id));
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return UserMapper.toDTO(userRepository.save(UserMapper.toEntity(userDTO)));
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return UserMapper.toDTO(userRepository.update(UserMapper.toEntity(userDTO)));
    }

    @Override
    public UserDTO delete(UserDTO userDTO) {
        return UserMapper.toDTO(userRepository.delete(UserMapper.toEntity(userDTO)));
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> filter() {
        return null;
    }

    @Override
    public void login(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            UserDTO userDTO = isLoginUser(username);
            if (!userDTO.getPassword().equals(password)) {
                forward(req, resp, "You entered the wrong password.");
            } else {
                redirect(resp, userDTO);
            }
        } catch (NullPointerException e) {
            forward(req, resp, "The specified username doesn't exist.");
        }
    }

    @Override
    public void registration(HttpServletRequest req, HttpServletResponse resp) {
        UserDTO userDTO = UserMapper.createDTO(req);
        boolean isValidate = UserValidator.validate(userDTO);
        if (isValidate) {
            forward(req, resp, "The data doesn't meet the requirements.");
        }
        UserDTO registrationUser;
        try {
            isRegistrationUser(userDTO);
            forward(req, resp, "A user with the same data is already exists. Try a different email, phone number or username.");
        } catch (NullPointerException e) {
            registrationUser = this.save(userDTO);
            redirect(resp, registrationUser);
        }
    }

    private UserDTO isLoginUser(String username) {
        List<User> users = userRepository.checkExistForLogin(username);
        if (!users.isEmpty()) {
            return UserMapper.toDTO(users.get(0));
        } else {
            throw new NullPointerException();
        }
    }


    private void isRegistrationUser(UserDTO userDTO) {
        List<User> users = userRepository.checkExistForRegistration(userDTO.getEmail(), userDTO.getUsername(), userDTO.getPhoneNumber());
        if (users.isEmpty()) {
            throw new NullPointerException();
        }
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp, String message)  {
        req.setAttribute("errorMessage", message);
        try {
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void redirect(HttpServletResponse resp, UserDTO registrationUser) {
        try {
            resp.sendRedirect("/FIALKA_war/product?idUser=" + registrationUser.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
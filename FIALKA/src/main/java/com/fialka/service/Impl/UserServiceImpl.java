package com.fialka.service.Impl;

import com.fialka.dto.UserDTO;
import com.fialka.exception.NonUserDataException;
import com.fialka.exception.UserExistException;
import com.fialka.mapper.UserMapper;
import com.fialka.validator.UserValidator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import com.fialka.model.User;
import com.fialka.repository.UserRepository;
import com.fialka.service.UserService;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

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
                forward(req, resp, "You entered the wrong password.", "/auth.jsp");
            } else {
                redirect(req, resp, userDTO);
            }
        } catch (NonUserDataException e) {
            //redirect(req, resp, null);
            forward(req, resp, "The specified username doesn't exist.", "/auth.jsp");
        }
    }

    @Override
    public void registration(HttpServletRequest req, HttpServletResponse resp) {
        UserDTO userDTO = UserMapper.createDTO(req);
        boolean isValidate = UserValidator.validate(userDTO);
        if (isValidate) {
            forward(req, resp, "The data doesn't meet the requirements.", "/registration.jsp");
        }
        UserDTO registrationUser;
        try {
            isRegistrationUser(userDTO);
            registrationUser = this.save(userDTO);
            redirect(req, resp, registrationUser);
        } catch (UserExistException e) {
            forward(req, resp, "A user with the same data is already exists. Try a different email, phone number or username.", "/registration.jsp");
        }
    }

    private UserDTO isLoginUser(String username) throws NonUserDataException {
        List<User> users = userRepository.checkExistForLogin(username);
        if (!users.isEmpty()) {
            return UserMapper.toDTO(users.get(0));
        } else {
            throw new NonUserDataException();
        }
    }


    private void isRegistrationUser(UserDTO userDTO) throws UserExistException {
        List<User> users = userRepository.checkExistForRegistration(userDTO.getEmail(), userDTO.getUsername(), userDTO.getPhoneNumber());
        if (!users.isEmpty()) {
            throw new UserExistException();
        }
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp, String message, String address)  {
        req.setAttribute("errorMessage", message);
        try {
            req.getRequestDispatcher(address).forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void redirect(HttpServletRequest req, HttpServletResponse resp, UserDTO registrationUser) {
        try {
            HttpSession session = req.getSession();
            session.setAttribute("userDTO",registrationUser);
            resp.sendRedirect("/FIALKA_war/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
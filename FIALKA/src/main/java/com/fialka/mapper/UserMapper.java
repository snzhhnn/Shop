package com.fialka.mapper;

import com.fialka.dto.UserDTO;
import com.fialka.model.User;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;

public class UserMapper {
    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        return User.builder()
                .id(userDTO.getId())
                .lastname(userDTO.getLastname())
                .firstname(userDTO.getFirstname())
                .surname(userDTO.getSurname())
                .password(userDTO.getPassword())
                .username(userDTO.getUsername())
                .birthdate(userDTO.getBirthdate())
                .phoneNumber(userDTO.getPhoneNumber())
                .gender(userDTO.getGender())
                .address(userDTO.getAddress())
                .email(userDTO.getEmail())
                .photo(userDTO.getPhoto())
                .build();
    }

    public static UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        return UserDTO.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .surname(user.getSurname())
                .username(user.getUsername())
                .password(user.getPassword())
                .birthdate(user.getBirthdate())
                .phoneNumber(user.getPhoneNumber())
                .gender(user.getGender())
                .address(user.getAddress())
                .email(user.getEmail())
                .photo(user.getPhoto())
                .build();
    }

    public static UserDTO createDTO(HttpServletRequest req) {
        return UserDTO.builder()
                .lastname(req.getParameter("lastname"))
                .firstname(req.getParameter("firstname"))
                .surname(req.getParameter("surname"))
                .birthdate(LocalDate.parse(req.getParameter("birthdate")))
                .username(req.getParameter("username"))
                .password(req.getParameter("password"))
                .email(req.getParameter("email"))
                .phoneNumber(req.getParameter("phoneNumber"))
                .confirmPassword(req.getParameter("confirmPassword"))
                .address(req.getParameter("address"))
                .gender(req.getParameter("gender"))
                .build();
    }
}
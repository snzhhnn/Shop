package com.fialka.validator;


import com.fialka.dto.UserDTO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UserValidator {
    public static boolean validate(UserDTO userDTO) {
        if (userDTO == null) {
            return false;
        }

        if (userDTO.getPassword() == null || userDTO.getPassword().length() <= 8) {
            return false;
        }

        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            return false;
        }

        if (userDTO.getEmail() == null || userDTO.getEmail().length() <= 3) {
            return false;
        }

        if (!userDTO.getEmail().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            return false;
        }

        if (userDTO.getPhoneNumber() == null || userDTO.getPhoneNumber().length() <= 3) {
            return false;
        }

        if (userDTO.getLastname() == null || userDTO.getLastname().length() <= 3) {
            return false;
        }

        if (userDTO.getFirstname() == null || userDTO.getFirstname().length() <= 3) {
            return false;
        }

        if (userDTO.getSurname() == null || userDTO.getSurname().length() <= 3) {
            return false;
        }

        if (userDTO.getUsername() == null || userDTO.getUsername().length() <= 3) {
            return false;
        }

        if (!userDTO.getPhoneNumber().matches("\\+375(44|29|33|25)\\d{7}")) {
            return false;
        }

        return userDTO.getBirthdate() != null && ChronoUnit.YEARS.between(userDTO.getBirthdate(), LocalDate.now()) >= 18;
    }
}
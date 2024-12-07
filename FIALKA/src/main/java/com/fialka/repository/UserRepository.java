package com.fialka.repository;

import com.fialka.model.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    User getByID(UUID id);
    User save(User user);
    User update(User user);
    User delete(User user);
    List<User> findAll();
    List<User> filter();
    List<User> checkExistForLogin(String username);
    List<User> checkExistForRegistration(String username, String email, String phoneNumber);
}
package com.fialka.repository;

import com.fialka.model.User;

import java.util.List;
import java.util.UUID;

public interface IUserRepository {
    User getByID(UUID id);
    User save(User user);
    User update(User user);
    User delete(User user);
    List<User> findAll();
    List<User> filter();
}
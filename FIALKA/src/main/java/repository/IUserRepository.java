package repository;

import model.User;

import java.util.List;

public interface IUserRepository {
    User getByID(User user);
    User save(User user);
    User update(User user);
    User delete(User user);
    List<User> findAll();
    List<User> filter();
}
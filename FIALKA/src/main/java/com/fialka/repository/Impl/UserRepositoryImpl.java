package com.fialka.repository.Impl;

import com.fialka.model.User;
import org.hibernate.Session;
import com.fialka.repository.UserRepository;
import com.fialka.util.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User getByID(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User loadUser = session.get(User.class, id);
        session.close();
        return loadUser;
    }

    @Override
    public User save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User update(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User delete(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public List<User> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User", User.class).getResultList();
        session.close();
        return users;
    }

    @Override
    public List<User> filter() {
        return null;
    }

    @Override
    public List<User> checkExistForLogin(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .getResultList();
        session.close();
        return users;
    }

    @Override
    public List<User> checkExistForRegistration(String username, String email, String phoneNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("SELECT u FROM User u WHERE u.email = :email OR u.username = :username OR u.phoneNumber = :phoneNumber", User.class)
                .setParameter("email", email)
                .setParameter("username", username)
                .setParameter("phoneNumber", phoneNumber)
                .getResultList();
        session.close();
        return users;
    }
}

package com.fialka.repository.Impl;

import com.fialka.model.User;
import org.hibernate.Session;
import com.fialka.repository.IUserRepository;
import com.fialka.util.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class UserRepository implements IUserRepository {
    @Override
    public User getByID(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User loadUser = session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        return loadUser;
    }

    @Override
    public User save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
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
        session.beginTransaction();
        List<User> users = session.createQuery("from User", User.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    @Override
    public List<User> filter() {
        return null;
    }
}

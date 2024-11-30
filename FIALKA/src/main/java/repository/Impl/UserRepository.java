package repository.Impl;

import model.User;
import org.hibernate.Session;
import repository.IUserRepository;
import util.HibernateUtil;

import java.util.List;

public class UserRepository implements IUserRepository {
    @Override
    public User getByID(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.get(User.class, user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(user);
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

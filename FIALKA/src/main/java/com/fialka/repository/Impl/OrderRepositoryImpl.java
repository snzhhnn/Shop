package com.fialka.repository.Impl;

import com.fialka.model.Ordering;
import org.hibernate.Session;
import com.fialka.repository.OrderRepository;
import com.fialka.util.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public Ordering getByID(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Ordering order = session.get(Ordering.class, id);
        session.close();
        return order;
    }

    @Override
    public Ordering save(Ordering order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
        return order;
    }

    @Override
    public Ordering update(Ordering order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(order);
        session.getTransaction().commit();
        session.close();
        return order;
    }

    @Override
    public Ordering delete(Ordering order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(order);
        session.getTransaction().commit();
        session.close();
        return order;
    }

    @Override
    public List<Ordering> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Ordering> orders = session.createQuery("from Ordering", Ordering.class).getResultList();
        session.close();
        return orders;
    }

    @Override
    public List<Ordering> filter() {
        return null;
    }
}

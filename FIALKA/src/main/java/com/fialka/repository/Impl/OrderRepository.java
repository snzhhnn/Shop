package com.fialka.repository.Impl;

import com.fialka.model.Order;
import org.hibernate.Session;
import com.fialka.repository.IOrderRepository;
import com.fialka.util.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class OrderRepository implements IOrderRepository {
    @Override
    public Order getByID(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Order order = session.get(Order.class, id);
        session.getTransaction().commit();
        session.close();
        return order;
    }

    @Override
    public Order save(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
        return order;
    }

    @Override
    public Order update(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(order);
        session.getTransaction().commit();
        session.close();
        return order;
    }

    @Override
    public Order delete(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(order);
        session.getTransaction().commit();
        session.close();
        return order;
    }

    @Override
    public List<Order> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Order> orders = session.createQuery("from Order", Order.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return orders;
    }

    @Override
    public List<Order> filter() {
        return null;
    }
}

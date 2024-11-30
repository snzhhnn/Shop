package repository.Impl;

import model.Order;
import org.hibernate.Session;
import repository.IOrderRepository;
import util.HibernateUtil;

import java.util.List;

public class OrderRepository implements IOrderRepository {
    @Override
    public Order getByID(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.get(Order.class, order);
        session.getTransaction().commit();
        session.close();
        return order;
    }

    @Override
    public Order save(Order order) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(order);
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

package com.fialka.repository.Impl;

import com.fialka.model.ProductInOrder;
import com.fialka.repository.ProductInOrderRepository;
import com.fialka.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class ProductInOrderRepositoryImpl implements ProductInOrderRepository {
    @Override
    public ProductInOrder getByID(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ProductInOrder productInOrder = session.get(ProductInOrder.class, id);
        session.close();
        return productInOrder;
    }

    @Override
    public ProductInOrder save(ProductInOrder productInOrder) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(productInOrder);
        session.getTransaction().commit();
        session.close();
        return productInOrder;
    }

    @Override
    public ProductInOrder update(ProductInOrder productInOrder) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(productInOrder);
        session.getTransaction().commit();
        session.close();
        return productInOrder;
    }

    @Override
    public ProductInOrder delete(ProductInOrder productInOrder) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(productInOrder);
        session.getTransaction().commit();
        session.close();
        return productInOrder;
    }

    @Override
    public List<ProductInOrder> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductInOrder> productInOrders = session.createQuery("from ProductInOrder", ProductInOrder.class).getResultList();
        session.close();
        return productInOrders;
    }

    @Override
    public List<ProductInOrder> filter() {
        return null;
    }
}

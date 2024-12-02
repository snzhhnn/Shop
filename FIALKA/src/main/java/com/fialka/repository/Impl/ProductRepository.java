package com.fialka.repository.Impl;

import com.fialka.model.Product;
import org.hibernate.Session;
import com.fialka.repository.IProductRepository;
import util.HibernateUtil;

import java.util.List;

public class ProductRepository implements IProductRepository {
    @Override
    public Product getByID(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.get(Product.class, product);
        session.getTransaction().commit();
        session.close();
        return product;
    }

    @Override
    public Product save(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(product);
        session.getTransaction().commit();
        session.close();
        return product;
    }

    @Override
    public Product update(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(product);
        session.getTransaction().commit();
        session.close();
        return product;
    }

    @Override
    public Product delete(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(product);
        session.getTransaction().commit();
        session.close();
        return product;
    }

    @Override
    public List<Product> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("from Product", Product.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return products;
    }

    @Override
    public List<Product> filter() {
        return null;
    }
}
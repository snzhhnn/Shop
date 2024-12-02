package com.fialka.repository.Impl;

import com.fialka.model.Product;
import org.hibernate.Session;
import com.fialka.repository.IProductRepository;
import com.fialka.util.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class ProductRepository implements IProductRepository {
    @Override
    public Product getByID(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        session.close();
        return product;
    }

    @Override
    public Product save(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(product);
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
package com.fialka.repository.Impl;

import com.fialka.model.ProductLocation;
import org.hibernate.Session;
import com.fialka.repository.IProductLocationRepository;
import com.fialka.util.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class ProductLocationRepository implements IProductLocationRepository {
    @Override
    public ProductLocation getByID(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ProductLocation productLocation = session.get(ProductLocation.class, id);
        session.getTransaction().commit();
        session.close();
        return productLocation;
    }

    @Override
    public ProductLocation save(ProductLocation productLocation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(productLocation);
        session.getTransaction().commit();
        session.close();
        return productLocation;
    }

    @Override
    public ProductLocation update(ProductLocation productLocation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(productLocation);
        session.getTransaction().commit();
        session.close();
        return productLocation;
    }

    @Override
    public ProductLocation delete(ProductLocation productLocation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(productLocation);
        session.getTransaction().commit();
        session.close();
        return productLocation;
    }

    @Override
    public List<ProductLocation> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<ProductLocation> productLocations = session.createQuery("from ProductLocation", ProductLocation.class)
                .getResultList();
        session.getTransaction().commit();
        session.close();
        return productLocations;
    }

    @Override
    public List<ProductLocation> filter() {
        return null;
    }
}

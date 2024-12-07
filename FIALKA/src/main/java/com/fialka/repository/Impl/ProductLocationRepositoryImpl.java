package com.fialka.repository.Impl;

import com.fialka.model.ProductLocation;
import org.hibernate.Session;
import com.fialka.repository.ProductLocationRepository;
import com.fialka.util.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class ProductLocationRepositoryImpl implements ProductLocationRepository {
    @Override
    public ProductLocation getByID(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        ProductLocation productLocation = session.get(ProductLocation.class, id);
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
        List<ProductLocation> productLocations = session.createQuery("from ProductLocation", ProductLocation.class).getResultList();
        session.close();
        return productLocations;
    }

    @Override
    public List<ProductLocation> filter() {
        return null;
    }
}

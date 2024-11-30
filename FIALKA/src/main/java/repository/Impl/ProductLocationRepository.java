package repository.Impl;

import model.ProductLocation;
import org.hibernate.Session;
import repository.IProductLocationRepository;
import util.HibernateUtil;

import java.util.List;

public class ProductLocationRepository implements IProductLocationRepository {
    @Override
    public ProductLocation getByID(ProductLocation productLocation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.get(ProductLocation.class, productLocation);
        session.getTransaction().commit();
        session.close();
        return productLocation;
    }

    @Override
    public ProductLocation save(ProductLocation productLocation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(productLocation);
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

package com.fialka.repository.Impl;

import com.fialka.model.Product;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import com.fialka.repository.ProductRepository;
import com.fialka.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public Product getByID(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    @Override
    public List<Product> getByTitle(String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Product> products = session.createQuery("from Product u where u.title= :title", Product.class)
                .setParameter("title", title)
                .getResultList();
        session.close();
        return products;
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
        List<Product> products = session.createQuery("from Product", Product.class).getResultList();
        session.close();
        return products;
    }

    @Override
    public List<Product> filter(double minPrice, double maxPrice, String category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root);

        List<Predicate> predicates = new ArrayList<>();

        if (minPrice > 0) {
            predicates.add(builder.ge(root.get("price"), minPrice));
        }

        if (maxPrice > 0) {
            predicates.add(builder.le(root.get("price"), maxPrice));
        }

        if (category != null) {
            predicates.add(builder.equal(root.get("category"), category));
        }

        criteriaQuery.where(builder.and(predicates.toArray(new Predicate[0])));

        List<Product> products = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return products;
    }
}
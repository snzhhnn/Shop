package com.fialka.repository.Impl;

import com.fialka.model.Warehouse;
import org.hibernate.Session;
import com.fialka.repository.IWarehouseRepository;
import com.fialka.util.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class WarehouseRepository implements IWarehouseRepository {
    @Override
    public Warehouse getByID(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Warehouse warehouse = session.get(Warehouse.class, id);
        session.getTransaction().commit();
        session.close();
        return warehouse;
    }

    @Override
    public Warehouse save(Warehouse warehouse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(warehouse);
        session.getTransaction().commit();
        session.close();
        return warehouse;
    }

    @Override
    public Warehouse update(Warehouse warehouse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(warehouse);
        session.getTransaction().commit();
        session.close();
        return warehouse;
    }

    @Override
    public Warehouse delete(Warehouse warehouse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(warehouse);
        session.getTransaction().commit();
        session.close();
        return warehouse;
    }

    @Override
    public List<Warehouse> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Warehouse> warehouses = session.createQuery("from Warehouse", Warehouse.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return warehouses;
    }

    @Override
    public List<Warehouse> filter() {
        return null;
    }
}
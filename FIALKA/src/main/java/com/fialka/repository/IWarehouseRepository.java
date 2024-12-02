package com.fialka.repository;

import com.fialka.model.Warehouse;

import java.util.List;

public interface IWarehouseRepository {
    Warehouse getByID(Warehouse warehouse);
    Warehouse save(Warehouse warehouse);
    Warehouse update(Warehouse warehouse);
    Warehouse delete(Warehouse warehouse);
    List<Warehouse> findAll();
    List<Warehouse> filter();
}
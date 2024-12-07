package com.fialka.repository;

import com.fialka.model.Warehouse;

import java.util.List;
import java.util.UUID;

public interface WarehouseRepository {
    Warehouse getByID(UUID id);
    Warehouse save(Warehouse warehouse);
    Warehouse update(Warehouse warehouse);
    Warehouse delete(Warehouse warehouse);
    List<Warehouse> findAll();
    List<Warehouse> filter();
}
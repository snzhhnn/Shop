package com.fialka.repository;

import com.fialka.model.Ordering;

import java.util.List;
import java.util.UUID;

public interface IOrderRepository {
    Ordering getByID(UUID id);
    Ordering save(Ordering order);
    Ordering update(Ordering order);
    Ordering delete(Ordering order);
    List<Ordering> findAll();
    List<Ordering> filter();
}
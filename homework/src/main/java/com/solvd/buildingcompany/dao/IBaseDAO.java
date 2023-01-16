package com.solvd.buildingcompany.dao;

import java.util.List;

public interface IBaseDAO<T> {
    T create(T t);

    T find(Object id);

    T update(T t);

    void delete(Object id);

    List<T> findAll();

    int count();
}

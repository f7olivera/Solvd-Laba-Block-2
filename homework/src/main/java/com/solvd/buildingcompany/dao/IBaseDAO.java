package com.solvd.buildingcompany.dao;

import java.util.List;

public interface IBaseDAO<T> {
    T create(T t);

    T get(long id);

    T update(T t);

    void delete(long id);

    List<T> findAll();

    int count();
}

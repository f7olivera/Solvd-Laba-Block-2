package com.solvd.buildingcompany.dao;

import java.util.List;

public interface IBaseDAO<T> {
    T create(T t);

    T find(long id);

    void update(T t);

    void delete(long id);

    List<T> findAll();

    int count();
}

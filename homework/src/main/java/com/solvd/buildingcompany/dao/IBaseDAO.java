package com.solvd.buildingcompany.dao;

import java.util.List;

public interface IBaseDAO<T> extends AutoCloseable {
    T create(T t);

    T get(int id);

    T update(T t);

    void delete(int id);

    List<T> findAll();

    int count();
}

package com.solvd.buildingcompany.dao;

import java.sql.SQLException;
import java.util.List;

public interface IBaseDAO<T> extends AutoCloseable {
    T create(T t) throws SQLException;

    T get(int id) throws SQLException;

    T update(T t) throws SQLException;

    void delete(int id) throws SQLException;

    List<T> findAll() throws SQLException;

    int count() throws SQLException;
}

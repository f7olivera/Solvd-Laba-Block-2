package com.solvd.buildingcompany.services;

import com.solvd.buildingcompany.dao.IBaseDAO;

public class MySQLService<T> implements IBaseService<T> {
    IBaseDAO<T> dao;

    public MySQLService(IBaseDAO<T> dao) {
        this.dao = dao;
    }

    @Override
    public T create(T entity) {
        return dao.create(entity);
    }

    @Override
    public T get(int id) {
        return dao.get(id);
    }

    @Override
    public T update(T entity) {
        return dao.update(entity);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}

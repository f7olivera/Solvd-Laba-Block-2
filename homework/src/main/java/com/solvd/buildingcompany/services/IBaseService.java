package com.solvd.buildingcompany.services;

public interface IBaseService<T> {
    public T create(T user);

    public T get(int id);

    public T update(T user);

    public void delete(int id);
}

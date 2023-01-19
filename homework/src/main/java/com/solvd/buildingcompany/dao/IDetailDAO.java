package com.solvd.buildingcompany.dao;

import java.sql.SQLException;

public interface IDetailDAO<T> extends IBaseDAO<T> {
    /**
     * Inserts an entry into a table if it doesn't exist.
     *
     * @param element: the element to be inserted.
     * @return int: the id of the inserted or existing element.
     */
    public int createIfNotExists(T element) throws SQLException;
}

package com.solvd.buildingcompany.dao.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class MySQLDAO implements AutoCloseable {
    Connection connection;
    private final static Logger LOGGER = LogManager.getLogger(MySQLDAO.class);

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            LOGGER.info("Could not close connection.");
        }
    }
}

package com.solvd.buildingcompany.dao.mysql;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool implements AutoCloseable {
    private static ConnectionPool instance;
    private final BasicDataSource dataSource;
    private final static Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private ConnectionPool() {
        LOGGER.info("Creating connection pool to MySQL database");
        BasicDataSource dataSource = new BasicDataSource();
        LOGGER.info("Reading properties file.");
        Properties properties = new Properties();
        try (InputStream inputStream = Files.newInputStream(Paths.get("src/main/resources/mysql.db.properties"))) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        dataSource.setDriverClassName(properties.getProperty("driver"));
        dataSource.setUrl(properties.getProperty("base_url") + "Building_Company");
        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));
        dataSource.setInitialSize(5);
        this.dataSource = dataSource;
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void close() throws SQLException {
        dataSource.close();
    }
}

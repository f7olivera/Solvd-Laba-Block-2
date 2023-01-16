package com.solvd.buildingcompany;

import com.solvd.buildingcompany.dao.IPersonDAO;
import com.solvd.buildingcompany.dao.mysql.PersonDAO;
import com.solvd.buildingcompany.models.people.Person;
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

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        LOGGER.info("Starting program.");
        try (BasicDataSource dataSource = new BasicDataSource()) {
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

            Connection connection = dataSource.getConnection();

            IPersonDAO personDAO = new PersonDAO(connection);
            Person person = new Person("John Doe", 34, 1245);
            personDAO.create(person);

            LOGGER.info("Person found:\n" + personDAO.get(person.getId()));

            // String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";
            // try (Statement statement = connection.createStatement()) {
            //     ResultSet rs = statement.executeQuery(query);
            //     while (rs.next()) {
            //         String coffeeName = rs.getString("COF_NAME");
            //         int supplierID = rs.getInt("SUP_ID");
            //         float price = rs.getFloat("PRICE");
            //         int sales = rs.getInt("SALES");
            //         int total = rs.getInt("TOTAL");
            //         System.out.println(coffeeName + ", " + supplierID + ", " + price +
            //                 ", " + sales + ", " + total);
            //     }
            // }
        }
    }
}

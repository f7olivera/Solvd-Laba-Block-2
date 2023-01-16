package com.solvd.buildingcompany;

import com.solvd.buildingcompany.dao.IPersonDAO;
import com.solvd.buildingcompany.mysql.PersonDAO;
import com.solvd.buildingcompany.people.Person;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        try (BasicDataSource dataSource = new BasicDataSource()) {
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/Building_Company");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            dataSource.setInitialSize(5);

            Connection connection = dataSource.getConnection();

            IPersonDAO personDAO = new PersonDAO(connection);
            Person person = new Person("John Doe", 34, 1245);
            personDAO.create(person);

            LOGGER.info("Person found:\n" + personDAO.find(person.getId()));

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

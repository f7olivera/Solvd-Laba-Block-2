package com.solvd.buildingcompany;

import com.solvd.buildingcompany.dao.mysql.ConnectionPool;
import com.solvd.buildingcompany.dao.mysql.PersonDAO;
import com.solvd.buildingcompany.models.people.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("Starting program.");
        try (PersonDAO personDAO = new PersonDAO()) {
            Person person = new Person("John Doe", 34, 1245);
            LOGGER.info("Creating person with id " + person.getId() + ".");
            personDAO.create(person);

            LOGGER.info("Person found:\n" + personDAO.get(person.getId()));

            ConnectionPool.getInstance().close();
        }
    }
}

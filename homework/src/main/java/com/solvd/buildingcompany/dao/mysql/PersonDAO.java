package com.solvd.buildingcompany.dao.mysql;

import com.solvd.buildingcompany.dao.IPersonDAO;
import com.solvd.buildingcompany.models.people.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO extends MySQLDAO implements IPersonDAO {
    private final static Logger LOGGER = LogManager.getLogger(PersonDAO.class);

    public PersonDAO() throws SQLException {
        super();
    }

    @Override
    public Person create(Person person) throws SQLException {
        LOGGER.info("Creating person with id " + person.getId() + ".");
        String sql = "INSERT INTO Persons (name, age, national_id) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE id = id";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, person.getName());
        statement.setInt(2, person.getAge());
        statement.setInt(3, person.getId());
        statement.executeUpdate();

        return person;
    }

    @Override
    public Person get(int id) throws SQLException {
        LOGGER.info("Finding person by id " + id + ".");
        String query = "SELECT * FROM Persons WHERE national_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next())
            return new Person(
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    resultSet.getInt("national_id")
            );

        return null;
    }

    @Override
    public Person update(Person person) throws SQLException {
        LOGGER.info("Updating person with id " + person.getId() + ".");
        String query = "UPDATE Persons SET name = ?, age = ?, national_id = ? WHERE national_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, person.getName());
        statement.setInt(2, person.getAge());
        statement.setInt(3, person.getId());
        statement.setInt(4, person.getId());
        statement.executeUpdate();

        return person;
    }

    @Override
    public void delete(int id) throws SQLException {
        LOGGER.info("Deleting person with id " + id + ".");
        String query = "DELETE FROM Persons WHERE national_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setLong(1, id);
        statement.executeUpdate();
    }

    @Override
    public List<Person> findAll() throws SQLException {
        LOGGER.info("Finding all persons.");
        List<Person> persons = new ArrayList<>();
        String query = "SELECT * FROM Persons";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next())
            persons.add(new Person(
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    resultSet.getInt("national_id")
            ));

        return persons;
    }

    @Override
    public int count() throws SQLException {
        LOGGER.info("Counting persons.");
        String query = "SELECT COUNT(*) FROM Persons";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next())
            return resultSet.getInt(1);

        return 0;
    }
}

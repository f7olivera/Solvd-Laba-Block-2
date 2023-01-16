package com.solvd.buildingcompany.mysql;

import com.solvd.buildingcompany.dao.IPersonDAO;
import com.solvd.buildingcompany.people.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonDAO implements IPersonDAO {
    private final static Logger LOGGER = LogManager.getLogger(PersonDAO.class);

    private final Connection connection;

    PersonDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Person create(Person person) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Persons (name, age, national_id) VALUES (?, ?, ?)");
            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.setInt(3, person.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return person;
    }

    @Override
    public Person find(long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT FROM Persons WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return new Person(
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getInt("national_id")
                );
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}

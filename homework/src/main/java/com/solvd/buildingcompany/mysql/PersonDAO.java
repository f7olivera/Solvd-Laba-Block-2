package com.solvd.buildingcompany.mysql;

import com.solvd.buildingcompany.dao.IPersonDAO;
import com.solvd.buildingcompany.people.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements IPersonDAO {
    private final static Logger LOGGER = LogManager.getLogger(PersonDAO.class);

    private final Connection connection;

    public PersonDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Person create(Person person) {
        try {
            String sql = "INSERT INTO Persons (name, age, national_id) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
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
            String query = "SELECT * FROM Persons WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
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
        try {
            String query = "UPDATE Persons SET name = ?, age = ?, national_id = ? WHERE national_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.setInt(3, person.getId());
            statement.setInt(4, person.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void delete(long id) {
        try {
            String query = "DELETE FROM Persons WHERE national_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        try {
            String query = "SELECT * FROM Persons";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
                persons.add(new Person(
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getInt("national_id")
                ));
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return persons;
    }

    @Override
    public int count() {
        try {
            String query = "SELECT COUNT(*) FROM Persons";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return resultSet.getInt(1);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return 0;
    }
}

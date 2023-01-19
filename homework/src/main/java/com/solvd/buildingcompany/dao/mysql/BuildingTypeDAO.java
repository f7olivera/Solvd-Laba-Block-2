package com.solvd.buildingcompany.dao.mysql;

import com.solvd.buildingcompany.dao.IDetailDAO;
import com.solvd.buildingcompany.models.building.details.BuildingType;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BuildingTypeDAO extends MySQLDAO implements IDetailDAO<BuildingType> {
    public BuildingTypeDAO() throws SQLException {
        super();
    }

    @Override
    public BuildingType create(BuildingType type) {
        return null;
    }

    @Override
    public BuildingType get(int id) {
        return null;
    }

    @Override
    public BuildingType update(BuildingType type) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<BuildingType> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int createIfNotExists(BuildingType type) throws SQLException {
        String insertQuery = "INSERT INTO Building_Timelines (capacity, floors, category, square_meters)\n" +
                "VALUES (?, ?, ?, ?)\n" +
                "ON DUPLICATE KEY UPDATE id = id;";
        PreparedStatement statement = connection.prepareStatement(insertQuery);

        statement.setInt(1, type.getCapacity());
        statement.setInt(2, type.getFloors());
        statement.setString(3, type.getCategory().toString());
        statement.setInt(4, type.getSquareMeters());

        String getIdQuery = "SELECT id FROM Building_Timelines WHERE capacity = ? AND floors = ? AND category = ? AND square_meters = ?";
        PreparedStatement idStatement = connection.prepareStatement(getIdQuery);
        idStatement.setInt(1, type.getCapacity());
        idStatement.setInt(2, type.getFloors());
        idStatement.setString(3, type.getCategory().toString());
        idStatement.setInt(4, type.getSquareMeters());

        return createIfNotExists(statement, idStatement);
    }
}

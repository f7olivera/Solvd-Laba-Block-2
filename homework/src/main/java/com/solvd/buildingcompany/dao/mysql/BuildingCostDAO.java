package com.solvd.buildingcompany.dao.mysql;

import com.solvd.buildingcompany.dao.IDetailDAO;
import com.solvd.buildingcompany.models.building.details.BuildingCost;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BuildingCostDAO extends MySQLDAO implements IDetailDAO<BuildingCost> {
    public BuildingCostDAO() throws SQLException {
        super();
    }

    @Override
    public BuildingCost create(BuildingCost cost) {
        return null;
    }

    @Override
    public BuildingCost get(int id) {
        return null;
    }

    @Override
    public BuildingCost update(BuildingCost cost) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<BuildingCost> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int createIfNotExists(BuildingCost cost) throws SQLException {
        String insertQuery = "INSERT INTO Building_Costs (cost_per_square_meter, permit_cost)\n" +
                "VALUES (?, ?)\n" +
                "ON DUPLICATE KEY UPDATE id = id;";
        PreparedStatement statement = connection.prepareStatement(insertQuery);

        statement.setInt(1, cost.getCostPerSquareMeter());
        statement.setInt(2, cost.getPermitCost());

        String getIdQuery = "SELECT id FROM Building_Costs WHERE cost_per_square_meter = ? AND permit_cost = ?";
        PreparedStatement idStatement = connection.prepareStatement(getIdQuery);
        idStatement.setInt(1, cost.getCostPerSquareMeter());
        idStatement.setInt(2, cost.getPermitCost());

        return createIfNotExists(statement, idStatement);
    }
}

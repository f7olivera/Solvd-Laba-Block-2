package com.solvd.buildingcompany.dao.mysql;

import com.solvd.buildingcompany.dao.IDetailDAO;
import com.solvd.buildingcompany.models.building.details.BuildingTimeline;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BuildingTimelineDAO extends MySQLDAO implements IDetailDAO<BuildingTimeline> {
    public BuildingTimelineDAO() throws SQLException {
        super();
    }

    @Override
    public BuildingTimeline create(BuildingTimeline timeline) {
        return null;
    }

    @Override
    public BuildingTimeline get(int id) {
        return null;
    }

    @Override
    public BuildingTimeline update(BuildingTimeline timeline) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<BuildingTimeline> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int createIfNotExists(BuildingTimeline timeline) throws SQLException {
        String insertQuery = "INSERT INTO Building_Timelines (construction_time, permit_process_time)\n" +
                "VALUES (?, ?)\n" +
                "ON DUPLICATE KEY UPDATE id = id;";
        PreparedStatement statement = connection.prepareStatement(insertQuery);

        statement.setInt(1, timeline.getConstructionTime());
        statement.setInt(2, timeline.getPermitProcessTime());

        String getIdQuery = "SELECT id FROM Building_Timelines WHERE construction_time = ? AND permit_process_time = ?";
        PreparedStatement idStatement = connection.prepareStatement(getIdQuery);
        idStatement.setInt(1, timeline.getConstructionTime());
        idStatement.setInt(2, timeline.getPermitProcessTime());

        return createIfNotExists(statement, idStatement);
    }
}

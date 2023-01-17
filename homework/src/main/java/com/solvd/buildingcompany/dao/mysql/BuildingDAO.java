package com.solvd.buildingcompany.dao.mysql;

import com.solvd.buildingcompany.dao.IBuildingDAO;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.building.BuildingCategory;
import com.solvd.buildingcompany.models.building.ConstructionDetails;
import com.solvd.buildingcompany.models.construction.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BuildingDAO extends MySQLDAO implements IBuildingDAO {
    private final Connection connection;
    private final static Logger LOGGER = LogManager.getLogger(BuildingDAO.class);

    public BuildingDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Building create(Building building) {
        ConstructionDetails details = building.getDetails();
        LOGGER.info("Creating " + details.getCategory() + " building.");

        // Searching costId, timelineId and typeId will create them if they don't exist
        int costId = getBuildingCostId(details.getCostPerSquareMeter(), details.getPermitCost());
        int timelineId = getBuildingTimelineId(details.getConstructionTime(), details.getPermitProcessTime());
        int typeId = getBuildingTypeId(details.getCapacity(), details.getFloors(), details.getCategory(), details.getSquareMeters());

        try {
            String sql = "INSERT INTO Buildings (name, building_cost_id, building_timeline_id, building_type_id)" +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, building.getName());
            statement.setInt(2, costId);
            statement.setInt(3, timelineId);
            statement.setInt(4, typeId);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return building;
    }

    @Override
    public Building get(int id) {
        LOGGER.info("Finding building by id " + id + ".");
        // TODO
        return null;
    }

    @Override
    public Building update(Building building) {
        LOGGER.info("Updating building " + building.getName() + ".");
        // TODO
        return building;
    }

    @Override
    public void delete(int id) {
        LOGGER.info("Deleting building with id " + id + ".");
        // TODO
    }

    @Override
    public List<Building> findAll() {
        LOGGER.info("Finding all buildings.");
        // TODO
        return new ArrayList<>();
    }

    @Override
    public int count() {
        LOGGER.info("Counting buildings.");
        // TODO
        return 0;
    }

    @Override
    public Building getByName(String name) {
        return null;
    }

    @Override
    public List<Building> getByCategory(BuildingCategory category) {
        return null;
    }

    @Override
    public List<Building> getByDetails(ConstructionDetails details) {
        return null;
    }

    @Override
    public int getBuildingCostId(int costPerSquareMeter, int permitCost) {
        try {
            String query = "INSERT INTO Building_Costs (cost_per_square_meter, permit_cost)\n" +
                    String.format("VALUES (%d, %d)\n", costPerSquareMeter, permitCost) +
                    "ON DUPLICATE KEY UPDATE id = LAST_INSERT_ID(id);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                return resultSet.getInt(1);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return -1;
    }

    @Override
    public int getBuildingTimelineId(int constructionTime, int permitProcessTime) {
        return 0;
    }

    @Override
    public int getBuildingTypeId(int capacity, int floors, BuildingCategory category, int squareMeters) {
        return 0;
    }

    public ConstructionDetails getConstructionDetails(int buildingId) {
        try {
            String query = "SELECT * FROM buildings\n" +
                    "JOIN building_costs ON buildings.building_cost_id = building_costs.id\n" +
                    "JOIN building_timelines ON buildings.building_timeline_id = building_timelines.id\n" +
                    "JOIN building_types ON buildings.building_type_id = building_types.id;" + buildingId;
            PreparedStatement costStatement = connection.prepareStatement(query);
            ResultSet resultSet = costStatement.executeQuery();
            if (resultSet.next())
                return new ConstructionDetails(
                        resultSet.getInt("cost_per_square_meter"),
                        resultSet.getInt("permit_cost"),
                        resultSet.getInt("construction_time"),
                        resultSet.getInt("permit_process_time"),
                        resultSet.getInt("square_meters"),
                        resultSet.getInt("capacity"),
                        resultSet.getInt("floors"),
                        BuildingCategory.valueOf(resultSet.getString("category")),
                        // TODO: Get items from building_items table
                        new HashSet<Item>()
                );
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
